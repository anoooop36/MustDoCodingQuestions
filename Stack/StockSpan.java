/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate 
the span of stock’s price for all n days. The span Si of the stock’s price on a given day i is defined as the maximum number of 
consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price
on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are 
{1, 1, 1, 2, 1, 4, 6}.

https://practice.geeksforgeeks.org/problems/stock-span-problem/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    /*
     * ith element is potential span for i+1 to n if ith element is greater than i-1
     * then 0 to i-1 can not be potential span for i+1 to n considering above always
     * push ith element but remove all consecutive smaller elements before ith
     * 
     * use stack to keep elements in descending order
     */
    static int[] stockSpan(int prices[], int n) {

        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        span[0] = 1;
        st.push(0);

        for (int i = 1; i < n; i++) {

            while (st.size() > 0 && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
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
            int spans[] = stockSpan(arr, n);
            for (int i = 0; i < n; i++)
                sb.append(spans[i] + " ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}