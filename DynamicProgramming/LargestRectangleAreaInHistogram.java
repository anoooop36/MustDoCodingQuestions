/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous
bars. For simplicity, assume that all bars have same width and the width is 1 unit.
https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    /*
     * each pair of index i and j min value decides area. So consider each bar as
     * min and calculate area. this will require knowing left immediate min index
     * and right immediate min index to current bar That can be done using stack
     * keep element in stack if its greater than top. since we are maintaining
     * elements in stack non descending order . if current element is less than
     * stack's then it is right immediate min for stack peek and second top element
     * of stack is left immediate min.
     */
    static int largestRectanagleAreaInHistogram(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] > arr[i]) {
                int currentIndex = st.pop();
                if (st.size() == 0) {
                    max = Math.max(max, i * arr[currentIndex]);
                } else {
                    max = Math.max(max, (i - st.peek() - 1) * arr[currentIndex]);
                }
            }
            st.push(i);
        }

        while (st.size() > 0) {
            int currentIndex = st.pop();
            if (st.size() == 0) {
                max = Math.max(max, n * arr[currentIndex]);
            } else {
                max = Math.max(max, ((n - st.peek() - 1) * arr[currentIndex]));
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String strs[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            sb.append(largestRectanagleAreaInHistogram(arr, n) + "\n");
        }
        System.out.print(sb);
    }
}