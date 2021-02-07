/*
Given a Directed Graph with V vertices and E edges, Find the number of strongly connected components in the graph.
https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}


// adj : Adjacency list representing the graph
// V: No of vertices


class Solution
{
    
    void lateDFS(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st){
        if(!visited[u]){
            visited[u] = true;
            for(int v: adj.get(u)){
                lateDFS(v,adj,visited,st);
            }
            st.push(u);
        }
    }
    
    void DFS(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        if(!visited[u]){
            visited[u] = true;
            for(int v: adj.get(u)){
                DFS(v,adj,visited);
            }
        }
    }
    
    ArrayList<ArrayList<Integer>> reverseEdgesInGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<ArrayList<Integer>>();
        
        for(int u=0;u<V;u++){
            reverseGraph.add(new ArrayList<Integer>());
        }
        for(int u=0;u<V;u++){
            for(int v: adj.get(u)){
                reverseGraph.get(v).add(u);
            }
        }
        
        return reverseGraph;
    }
    
	/*
		DFS of SCC is tree or forest
		reverse of SCC is SCC
		Use DFS finish time to find SCCs
	*/
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        
        Stack<Integer> st = new Stack<>();
        
        for(int u=0;u<V;u++){
            lateDFS(u,adj,visited, st);
        }
        
        adj = reverseEdgesInGraph(V,adj);
        
        Arrays.fill(visited, false);
        int connectedComponents = 0;
        
        while(st.size() > 0){
            int u = st.pop();
            if(!visited[u]){
                connectedComponents++;
                DFS(u,adj,visited);
            }
        }
        
        return connectedComponents;
    }
}