/*
Given a matrix of size R*C. Traverse the matrix in spiral form.
Input:
R = 4, C = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
*/

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution{
    
    /*
        four variable solution to track start and end of row and column and print one round in each iteration
        corner case: single row
    */
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int iStart,iEnd, jStart, jEnd;
        iStart = jStart =0;
        iEnd =r-1;
        jEnd = c-1;
        while(iStart<=iEnd && jStart<=jEnd){
            //row forward
            for(int k=jStart;k<=jEnd;k++){
                result.add(matrix[iStart][k]);
            }
            
            //column down
            for(int k=iStart+1;k<=iEnd;k++){
                result.add(matrix[k][jEnd]);
            }
            
            // row backward
            if(iStart != iEnd)  // condition to avoid printing same row twice
                for(int k=jEnd-1;k>=jStart;k--){
                    result.add(matrix[iEnd][k]);
                }
            //column upward    
            if(jStart != jEnd) // condition to avoid printing same coulumn twice
                for(int k=iEnd-1;k>=iStart+1;k--){
                    result.add(matrix[k][jStart]);
                }
            
            iStart++;
            jStart++;
            iEnd--;
            jEnd--;
        }
        return result;
    }
}