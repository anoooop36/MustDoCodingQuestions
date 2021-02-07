/*
Given a Undirected Graph. Check whether it contains a cycle or not.
https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/#
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}


/*
ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
	
	/*
		Idea is to do dfs by maintaining parent node during dfs of node u if its adjacent v is already visited and its not parent(u) then there is a cycle.
	*/
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> g, int u, int parent, boolean visited[]){
		
        visited[u] = true;
		
        for(int v: g.get(u)){
			
            if(!visited[v]){
                if(isCyclicUtil(g,v,u,visited))
                    return true;
            } else if(v != parent){
                return true;
            }
        }
        return false;
    }
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       boolean[] visited = new boolean[V];
       Arrays.fill(visited, false);
       
       for(int u=0;u<V;u++){
           if(!visited[u] && isCyclicUtil(g,u,-1,visited))
                return true;
       }
       return false;
    }
}