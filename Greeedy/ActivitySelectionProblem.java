/*
Given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, 
assuming that a person can only work on a single activity at a time.
https://practice.geeksforgeeks.org/problems/activity-selection/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Activity implements Comparable<Activity> {
    int start, end;

    public Activity(int s, int e) {
        start = s;
        end = e;
    }

    public int compareTo(Activity b) {
        return this.end - b.end;
    }
}

class GFG {

    /*
        Select activity based on least finish time in that way no overlap happens. O(n)
        why Greedy: job with less finsh time can always replace a job with more finish time. We may have more jobs to finish if 
            we choose least to finish.

        Activity selection based on low time interval doesnt work as low can overlap with two which can be part of solution.
        Activity selection based on least start time doesnt work as it may finsihs last.

    */
    public static int getMaxActivity(int[] startTime, int endTime[], int n) {

        if (n <= 0)
            return 0;

        Activity[] activity = new Activity[n];
        for (int i = 0; i < n; i++) {
            activity[i] = new Activity(startTime[i], endTime[i]);
        }
        Arrays.sort(activity);
        int count = 1;
        Activity prev = activity[0];

        for (int i = 1; i < n; i++) {
            Activity curr = activity[i];
            if (prev.end <= curr.start) {
                count++;
                prev = curr;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String strs1[] = br.readLine().split(" ");
            String strs2[] = br.readLine().split(" ");
            int startTime[] = new int[n];
            int endTime[] = new int[n];

            for (int i = 0; i < n; i++) {
                startTime[i] = Integer.parseInt(strs1[i]);
                endTime[i] = Integer.parseInt(strs2[i]);
            }
            sb.append(getMaxActivity(startTime, endTime, n) + "\n");
        }
        System.out.print(sb);
    }
}