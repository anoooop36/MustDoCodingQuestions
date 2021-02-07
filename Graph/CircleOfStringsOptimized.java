/*
Given an array of lowercase strings A[] of size N, determine if the strings can be chained together to form a circle. A
string X can be chained together with another string Y if the last character of X is same as first
character of Y. If every string of the array can be chained, it will form a circle.

For eg for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"
https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1#
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String A[] = in.readLine().trim().split(" ");
		    int N = Integer.parseInt(A[0]);
		    A = in.readLine().trim().split(" ");
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isCircle(N, A));
		}
    }
}

class Graph {
    HashMap<Integer, ArrayList<Integer>> adj;
    Graph(){
        adj = new HashMap<>();
    }
    
    void addEdge(int u, int v){
       ArrayList<Integer> list = adj.get(u);
       if(list == null){
           list = new ArrayList<>();
           adj.put(u,list);
       }
       list.add(v);
    }
    
    void transposeGraph(){
        HashMap<Integer, ArrayList<Integer>> newAdj = new HashMap<>();
        adj.forEach((k,v) ->{
            for(Integer c : v){
                ArrayList<Integer> list = newAdj.get(c);
                if(list == null)
                    list = new ArrayList<>();
                list.add(k);
                newAdj.put(c,list);
            }
        });
        adj = newAdj;
    }
    
    void dfs(boolean[] visited,int u){
        visited[u] = true;
        if(adj.get(u) != null){
            for(int v: adj.get(u)){
                if(!visited[v])
                    dfs(visited,v);
            }
        }
    }
    
    boolean dfsUtil(int startV){
        boolean[] visited = new boolean[26];
        dfs(visited,startV);
        
        for(int u=0;u<26;u++){
            if(adj.get(u) != null){
                if(!visited[u])
                    return false;
            }
        }
        return true;    
    }
    
    int[] getIndegrees(){
        int[] indegree = new int[26];
        Arrays.fill(indegree,0);
        for(int u=0;u<26;u++){
            if(adj.get(u) != null){
                for(int v: adj.get(u)){
                    indegree[v]++;
                }
            }
        }
        return indegree;
    }
    
    boolean isIndegreeSameAsOut(){
        int[] indegree = getIndegrees();
        for(Map.Entry<Integer, ArrayList<Integer>> e: adj.entrySet()){
            int k = e.getKey();
            ArrayList<Integer> v = e.getValue();
            if(indegree[k] != v.size())
                return false;
        }
        return true;
    }
}

class Solution
{
    /*
		all vertices must be reached from start in graph and transpose of graph 
		indegree must be equal to out degree for each vertex in Graph.
	*/
    static int isCircle(int N, String A[])
    {
        
        Graph g = new Graph();
        int startV = A[0].charAt(0)-'a';;
        for(int i=0;i<N;i++){
            int u = A[i].charAt(0)-'a';
            int v = A[i].charAt(A[i].length()-1)-'a';
            g.addEdge(u,v);
        }
        
        if(!g.dfsUtil(startV))
            return 0;
            
        g.transposeGraph();
        
        if(!g.dfsUtil(startV))
            return 0;
        
        if(g.isIndegreeSameAsOut())
            return 1;
        return 0;
        
        
    }
}