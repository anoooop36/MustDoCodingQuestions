/*
Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall.
Note: There are only a single source and a single destination.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}


class Solution
{
    int X[] = {0,0,1,-1};
    int Y[] = {1,-1,0,0};
    
    boolean isValidMove(int[][] grid, boolean[][] visited, int n, int i, int j){
        if(i<0 || j<0 || i>=n || j>=n || visited[i][j] || grid[i][j] == 0)
            return false;
        return true;
    }
    
	/*
		bfs and dfs should work here
	*/
    boolean dfs(int[][] grid, boolean[][] visited, int n, int i, int j){
        if(grid[i][j]==2)
            return true;

        visited[i][j] = true;
        
        for(int k=0;k<4;k++){
            int nextI = X[k]+i;
            int nextJ = Y[k]+j;
            if(isValidMove(grid,visited,n,nextI,nextJ) && dfs(grid,visited,n,nextI,nextJ))
                return true;
        }

        return false;
    }
    
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        int srcI = 0, srcJ=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    srcI =  i;
                    srcJ = j;
                }
            }
        }
        
        return dfs(grid,visited,n,srcI,srcJ);
    }
}