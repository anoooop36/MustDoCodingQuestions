/*
Given a square matrix of size N x N. The task is to rotate it by 90 degrees in anti-clockwise direction without using any extra space.
https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1#
*/

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /*
        idea is to use pair of four in each cycle (n/2 cycles). A cycle can be covered by taking ith row and use its four to swap
    */
    static void rotateby90(int arr[][], int n) 
    {
        // rotateby90UsingExtraSpace(arr,n);
        //rotateby90UsingTransposeReverse(arr,n);
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int temp = arr[j][i];
                arr[j][i] = arr[i][n-j-1];
                arr[i][n-j-1] = arr[n-j-1][n-i-1];
                arr[n-j-1][n-i-1] = arr[n-i-1][j];
                arr[n-i-1][j] = temp;
            }
        }
    }
    
    static void rotateby90UsingTransposeReverse(int arr[][], int n){
        //transpose
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
        //swap rows
        
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[n-i-1][j];
                arr[n-i-1][j] = temp;
            }
        }
    }
    
    static void rotateby90UsingExtraSpace(int arr[][], int n) 
    {
        int res[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[n-j-1][i] = arr[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = res[i][j];
            }
            
        }

    }
}