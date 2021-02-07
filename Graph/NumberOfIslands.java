/*
Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note:An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i,e in all 8 directions.
https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}



class Solution
{
    int[] X = {1,0,-1,0, 1,-1,-1,1};
    int[] Y = {0,1,0,-1, 1,-1,1,-1};
    
    boolean isValidMove(int i, int j, int M, int N, char[][] grid, boolean visited[][]){
        if(i<0 || j< 0 || i>= M || j>=N || visited[i][j] || grid[i][j] == '0')
            return false;
        return true;
    }
    
    void dfs(char[][] grid, int i, int j, boolean[][] visited, int M, int N){
        visited[i][j] = true;
        for(int k=0;k<8;k++){
            int a = i+X[k];
            int b = j+Y[k];
            if(isValidMove(a,b,M,N,grid,visited)){
                dfs(grid,a,b,visited,M,N);
            }
        }
    }
    
    public int numIslands(char[][] grid)
    {
        int M = grid.length;
        int N = grid[0].length;
        boolean visited[][] = new boolean[M][N];
        
        for(int i=0;i<M;i++){
            Arrays.fill(visited[i],false);
        }
        
        int count = 0;
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid,i,j,visited,M,N);
                    count++;
                }
            }
        }
        
        return count;
    }
}