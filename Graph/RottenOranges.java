/*
Given a matrix of dimension r*c where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

So, we have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other 
fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. If it is impossible to rot 
every orange then simply return -1.
https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Point{
    int i,j;
    Point(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class GFG
 {
    static int X[] = new int[]{ -1, 1, 0, 0};
    static int Y[] = new int[]{ 0, 0, -1, 1};
    
    static boolean isValidMove(int i, int j, int m, int n, int[][] arr, boolean visited[][]){
        if(i<m && j<n && i>=0 && j>= 0 && arr[i][j] == 1 && !visited[i][j]  )
            return true;
        return false;
    }
    
    static int getTimeToRotOrangesBFS(int[][] arr, int m, int n){
        
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(visited[i], false);
        }
        
        int time = 0;
        
        Queue<Point> q = new LinkedList<>();
        // put all rotten oranges at depth 0 (0 time to rot)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 2){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }
        
        q.add(null);
        
        //BFS
        
        while(q.size() > 0){
            
            Point currPoint = q.poll();
            
            // one level compeleted
            if(currPoint == null){
                if(q.size() > 0){
                    
                    time++;
                    // mark next level completion
                    q.add(null);
                }
            } 
            else {
                for(int k=0;k<4;k++){
                    int i1 = X[k] + currPoint.i;
                    int j1 = Y[k] + currPoint.j;
                    
                    if(isValidMove(i1,j1,m,n,arr,visited)){
                        visited[i1][j1] = true;
                        q.add(new Point(i1,j1));
                    }
                }
            }
        }
        
        // check all fresh ones visited
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && arr[i][j] != 0){
                    return -1;
                }
            }
        }
        
        return time;
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
	        sb.append(getTimeToRotOrangesBFS(arr,m, n)+"\n");
	    }
	    System.out.print(sb);
	 }
}