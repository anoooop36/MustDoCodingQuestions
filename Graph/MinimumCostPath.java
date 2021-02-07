/*
Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, 
we need to find a path from top left cell to bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j). 

Note: It is assumed that negative cost cycles do not exist in the input matrix.

https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1
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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}


class Triplet implements Comparable<Triplet> {
    int i, j, dist;
    
    Triplet(int i, int j, int dist){
        this.i =i;
        this.j = j;
        this.dist = dist;
    }
    
    public int compareTo(Triplet other){
        return this.dist - other.dist;
    }
}

class Solution
{
    
    int X[] = {0,0,1,-1};
    int Y[] ={1,-1,0,0};
    
    boolean isValidMove(boolean[][] visited, int n, int i, int j){
        if(i<0 || j<0 || i>=n|| j>=n || visited[i][j])
            return false;
        return true;
    }
    
    /*
        Dijkastra works with positive edge weights
    */
    public int minimumCostPath(int[][] grid)
    {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        
        pq.add(new Triplet(0,0,grid[0][0]));
        
        while(pq.size() > 0){
            Triplet curr = pq.poll();
            int i = curr.i;
            int j = curr.j;
            int dist = curr.dist;
            
            if(i==n-1 && j==n-1)
                return dist;
            
            if(!visited[i][j]){
                
                visited[i][j] = true;
                
                for(int k=0; k<4; k++){
                    
                    int newX = X[k] + i;
                    int newY = Y[k]+ j;
                    
                    if(isValidMove(visited,n,newX,newY)){
                        pq.add(new Triplet(newX,newY,dist+grid[newX][newY]));
                    }
                }
            }
        }
        return -1;
    }
}