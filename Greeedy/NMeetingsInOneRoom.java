/*
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i 
and F[i] is finish time of meeting i.

What is the maximum number of meetings that can be accommodated in the meeting room?
https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Activity implements Comparable<Activity> {
    int start, end, index;

    public Activity(int s, int e, int i) {
        start = s;
        end = e;
        index = i;
    }

    public int compareTo(Activity b) {
        return this.end - b.end;
    }
}

class GFG {
    public static String getMaxActivity(int[] startTime, int endTime[], int n) {

        if (n <= 0)
            return "0 ";

        StringBuffer sb = new StringBuffer();
        Activity[] activity = new Activity[n];
        for (int i = 0; i < n; i++) {
            activity[i] = new Activity(startTime[i], endTime[i], i + 1);
        }
        Arrays.sort(activity);
        Activity prev = activity[0];
        sb.append(prev.index + " ");

        for (int i = 1; i < n; i++) {
            Activity curr = activity[i];
            if (prev.end <= curr.start) {
                sb.append(curr.index + " ");
                prev = curr;
            }
        }

        return sb.toString();
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