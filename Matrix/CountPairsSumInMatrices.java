/*
Given two sorted matrices mat1 and mat2 of size N x N of elements. Given a value x. 
The problem is to count all pairs from both matrices whose sum is equal to x.

Note: The pair has an element from each matrix. 
Matrices are strictly sorted which means that matrices are sorted in a way such that all elements 
in a row are sorted in increasing order and for row ‘i’, where 1 <= i <= n-1, the first element of row 'i' 
is greater than the last element of row 'i-1'.

https://practice.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1#
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}

class Solution {
    /*
        Two pointers solution. One at begining of first matrix and other at end of second matrix. 
        Move pointers according to sum
    */
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int count = 0;
        int first,sec;
        first = 0;
        sec = n*n-1;
        
        while(first<n*n && sec>=0){
            int i1= first/n;
            int j1 = first%n;
            int i2 = sec/n;
            int j2= sec%n;
            
            if(mat1[i1][j1] + mat2[i2][j2] == x){
                count++;
                first++;
                sec--;
            } else if(mat1[i1][j1] + mat2[i2][j2] < x){
                first++;
            } else {
                sec--;
            }
        }
        
        return count;
    }
}