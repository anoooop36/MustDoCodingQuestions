/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, 
a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, 
vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
If it is impossible for all the n nodes to receive the signal, return -1.
https://leetcode.com/problems/network-delay-time/
*/

public class Pair implements Comparable<Pair> {
    public int dist, vertex;
    Pair(int vertex, int dist){
        this.vertex = vertex;
        this.dist = dist;
    }
    
    public int compareTo(Pair other){
        return this.dist - other.dist;
    }
    
}

class Solution {
    
    HashMap<Integer, ArrayList<Pair>> getGraph(int[][] times){
        HashMap<Integer, ArrayList<Pair>> graph = new HashMap<Integer, ArrayList<Pair>>();
        for(int i=0;i<times.length;i++){
            int u = times[i][0]-1;
            int v = times[i][1]-1;
            int w = times[i][2];
            ArrayList<Pair> list = graph.get(u);
            if(list == null){
                list = new ArrayList<Pair>();
                graph.put(u,list);
            }
            list.add(new Pair(v,w));
            
        }
        return graph;
    }
    
    public int networkDelayTime(int[][] times, int V, int k) {
        int[] distArr = new int[V];
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        
        Arrays.fill(distArr, Integer.MAX_VALUE);
        HashMap<Integer, ArrayList<Pair>> adj = getGraph(times);

        pq.add(new Pair(k-1,0));
        
        while(pq.size() > 0){
            Pair pair = pq.poll();
            int u = pair.vertex;
            int dist = pair.dist;
            
            if(!visited[u]){
                visited[u] = true;
                distArr[u] = dist;
                
                if(adj.get(u) != null){
                    for(Pair curr: adj.get(u)){
                        int v = curr.vertex;
                        int w = curr.dist;
                        if(!visited[v]){
                            if(dist+w < distArr[v]){
                                pq.add(new Pair(v, dist+w));
                                distArr[v] = dist+w;
                            }
                        }
                    }
                }
            }
        }
        
        int maxWeight = 0;
        for(int i=0;i<V;i++){
            if(distArr[i] == Integer.MAX_VALUE)
                return -1;
            maxWeight = Math.max(maxWeight, distArr[i]);
        }
        
        return maxWeight;
    }
}