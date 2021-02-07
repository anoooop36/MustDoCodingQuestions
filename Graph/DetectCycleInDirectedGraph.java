/*
Given a Directed Graph. The task is to check whether it contains any cycle or not.
https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
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
            }
            if(new DetectCycle().isCyclic(nov, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

/*
ArrayList<ArrayList<Integer>> adj: to represent graph containing 'v'
                                    vertices and edges between them
N: represent number of vertices
*/
class DetectCycle
{
	/*
	A cycle exists if there is an edge from child to parent (back edge). Do dfs by maintaining vertices visited and vertices in current recursion stack. There is a cycle if there is
	an adjacent visited node in recursion stack.
	*/
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> g, int u, boolean[] visited, boolean[] recStack){
        visited[u] = true;
        recStack[u] = true;
        
        for(int v: g.get(u)){
            if(!visited[v]){
                if(isCyclicUtil(g,v,visited,recStack))
                    return true;
            }
            else if(recStack[v])
                return true;
        }
        recStack[u] = false;
        return false;
    }
    
    static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];
        Arrays.fill(visited,false);
        Arrays.fill(recStack,false);
        
        for(int u=0;u<N;u++){
            if(!visited[u] && isCyclicUtil(adj,u,visited,recStack))
                return true;
        }
        return false;
    }
}