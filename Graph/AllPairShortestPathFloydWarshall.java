/*
The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph. 
The Graph is represented as Adjancency Matrix, and the Matrix denotes the weight of the edegs (if it exists) else INF (1e7).
https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall/0#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	 /*
		consider k vertex as intermediate for vertex i and j to compute its shortest path
	 */
    static void getAllPairShortestPath(int[][] mat, int n){
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE && mat[i][k]+mat[k][j] < mat[i][j]){
                        mat[i][j] = mat[i][k]+mat[k][j];
                    }
                }
            }
        }
    } 
    
	public static void main (String[] args) throws IOException
	 {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int t = Integer.parseInt(br.readLine());
	     StringBuffer sb = new StringBuffer();
	     
	     while(t-- > 0){
	         int n = Integer.parseInt(br.readLine());
	         int mat[][] = new int[n][n];
	         
	         for(int i=0;i<n;i++){
	             String strs[] = br.readLine().split(" ");
	             for(int j=0;j<n;j++){
	                 if("INF".equals(strs[j]) || "10000000".equals(strs[j])){
	                     mat[i][j]= Integer.MAX_VALUE;
	                 } else {
	                     mat[i][j] = Integer.parseInt(strs[j]);
	                 }
	             }
	         }
	         
	         getAllPairShortestPath(mat, n);
	         
	         for(int i=0;i<n;i++){
	             for(int j=0;j<n;j++){
	                 if(mat[i][j] != Integer.MAX_VALUE)
	                    sb.append(mat[i][j]+" ");
	                 else
	                    sb.append("INF ");
	             }
	             sb.append("\n");
	         }
	     }
	     System.out.print(sb);
	 }
}