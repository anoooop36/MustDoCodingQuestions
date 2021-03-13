/*
Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, 
and a number X is given. The task is to find whether element X is present in the matrix or not.
https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}// } Driver Code Ends


class Sol
{
    /*
        crucial is to pick starting row and column so that we can look in specific direction for given number
        ex: if startI = N-1 and startJ = M-1 in case of mat[StartI][StartJ] > X should we go up or left
        but if startI = N-1 and startJ = 0 in case of mat[StartI][StartJ] > X we would go up. all numbers in or below that row are larger
    */
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        int i=N-1;
        int j=0;
        
        while(i>=0 && j<M && mat[i][j] != X){
            if(mat[i][j] > X){
                i--;
            } else {
                j++;
            }
        }
        
        if(i<0 || j>=M || mat[i][j] != X)
            return 0;
        return 1;
    }
}