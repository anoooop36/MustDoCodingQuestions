/*
Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach.
https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            
            ArrayList<Integer> res = new Traversal().dfs(list, nov);
            for (int i = 0; i < res.size (); i++) 
                System.out.print (res.get(i) + " ");
            System.out.println();
        }
    }
}



/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class Traversal
{
	/*
		Time complexity is O(V+E) and space complexity is O(V)
	*/
    static void dfsUtil(ArrayList<ArrayList<Integer>> g, int u, boolean[] visited, ArrayList<Integer> result){
        visited[u] = true;
        result.add(u);
        for(int v : g.get(u)){
            if(!visited[v]){
                dfsUtil(g,v,visited,result);
            }
        }
    }
	
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       ArrayList<Integer> result = new ArrayList<Integer>();
       boolean[] visited = new boolean[N];
       Arrays.fill(visited, false);
       dfsUtil(g,0,visited,result);
       return result;
    }
}