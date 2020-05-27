/*
Given a matrix mat[][] of size M*N. Traverse and print the matrix in spiral form.
https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static void printForwardRow(int arr[][], int start, int end, int row){
        for(int i=start;i<=end;i++){
            System.out.print(arr[row][i]+" ");
        }
    }
    
    static void printBackwardRow(int arr[][], int start, int end, int row){
        for(int i=end;i>=start;i--){
            System.out.print(arr[row][i]+" ");
        }
    }
    
    static void printDownwardCol(int arr[][], int start, int end, int col){
        for(int i=start;i<=end;i++){
            System.out.print(arr[i][col]+" ");
        }
    }
    
    static void printUpwardCol(int arr[][], int start, int end, int col){
            for(int i=end;i>=start;i--){
                System.out.print(arr[i][col]+" ");
            }
    }
    
    // Break down problem to printing rowise left-right, colwise up-down, rowise right-left, colwise down
    // avoid printing twice
    static void printSpirally(int arr[][], int m, int n){
        int startRow = 0, startCol = 0, endRow = m-1, endCol = n-1;
        
        while(startRow <= endRow && startCol <= endCol){
            printForwardRow(arr,startCol,endCol,startRow);
            printDownwardCol(arr,startRow+1,endRow-1,endCol);
            //no need to print backward row if it is single row already covered before
            if(startRow < endRow)
                printBackwardRow(arr,startCol,endCol,endRow);
            //no need to print upward col if it is single col already covered before
            if(startCol < endCol)
                printUpwardCol(arr,startRow+1,endRow-1,startCol);
            startRow++;endRow--;startCol++;endCol--;
        }
    }
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String strs[] = br.readLine().split(" ");
	        int m = Integer.parseInt(strs[0]);
	        int n = Integer.parseInt(strs[1]);
	        strs = br.readLine().split(" ");
	        int arr[][] = new int[m][n];
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                arr[i][j] = Integer.parseInt(strs[i*n+j]);
	            }
	        }
	        printSpirally(arr,m,n);
	        System.out.print("\n");
	    }
	 }
}