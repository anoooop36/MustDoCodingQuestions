/*
Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and if there is one path, 
print the minimum no of steps needed to reach it, else print -1 if the destination is not reachable. 
You may move in only four direction ie up, down, left and right. The path can only be created out of a cell if its value is 1.
https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path/0#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class GFG
 {
    static int[] X = {1,-1,0,0};
    static int[] Y = {0,0,1,-1};
    
    static boolean isValidMove(int[][] mat, int i, int j, int n, int m, boolean[][] visited){
        if(i<0 || j<0 || i>=n|| j>=m || visited[i][j] || mat[i][j] == 0)
            return false;
        return true;
    }
    
    static int getShortestPath(int[][] mat, int n, int m, int destinationX, int destinationY){
        boolean[][] visited = new boolean[n][m];
        int minDist = 0;
        
        Queue<Pair> q = new LinkedList<Pair>();
        if(mat[0][0] == 1){
            q.add(new Pair(0,0));
            visited[0][0] = true;
            q.add(null);
        }
        
        while(q.size() >0){
            Pair curr = q.poll();
            if(curr == null){
                if(q.size() >0){
                    q.add(null);
                }
                minDist++;
            }
            else {
                if(curr.x == destinationX && curr.y == destinationY)
                    return minDist;
                else {
                    for(int i=0;i<4;i++){
                        int nextX = X[i]+curr.x;
                        int nextY = Y[i]+curr.y;
                        if(isValidMove(mat,nextX,nextY,n,m,visited)){
                            visited[nextX][nextY] = true;
                            q.add(new Pair(nextX, nextY));
                        }
                    }
                }
            }
        }
        return -1;
    }
     
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    
	    while(t-- > 0){
	        String[] strs = br.readLine().split(" ");
	        int n = Integer.parseInt(strs[0]);
	        int m = Integer. parseInt(strs[1]);
	        strs = br.readLine().split(" ");
	        int[][] mat = new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                mat[i][j] = Integer.parseInt(strs[m*i+j]);
	            }
	        }
	        strs = br.readLine().split(" ");
	        int destinationX = Integer.parseInt(strs[0]);
	        int destinationY =Integer.parseInt(strs[1]);
	        sb.append(getShortestPath(mat,n,m,destinationX,destinationY));
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}