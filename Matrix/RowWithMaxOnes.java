/*
Given a boolean 2D array of n x m dimensions where each row is sorted. 
Find the 0-based index of the first row that has the maximum number of 1's.
https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#
*/

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int getNextRowWithOne(int row, int col, int arr[][], int n){
        while(row < n){
            if(arr[row][col] ==  1)
                return row;
            row++;
        }
        return -1;
    }
    
    /*
        picking right start point is important in case of sorted matrix(rowwise, columnwise). idea is to start from rightmost top cell and move in left if it is 1 else find next
        nearest row having one (if no such row found we should stop our search).
    */
    int rowWithMax1s(int arr[][], int n, int m) {
        int row = 0;
        int col = m-1;
        
        while(row<n && col >=0){
            if(arr[row][col] == 1)
                col--;
            else {
                int nextRow = getNextRowWithOne(row+1,col,arr,n);
                if(nextRow == -1)
                    break;
                row = nextRow;
            }
        }
        
        // if now row found with one
        if(arr[row][m-1]==0)
            return -1;
            
        return row;
    }
}