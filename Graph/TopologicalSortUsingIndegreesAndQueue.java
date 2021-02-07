class TopologicalSort {
	
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
			int[] indegree = new int[N];
			Queue<Integer> q = new LinkedList<Integer>();
			ArrayList<Integer> result = new ArrayList<>();
			
			Arrays.fill(indegree,0);
			
			for(int u=0;u<adj.length();u++){
				for(int v: adj.get(u)){
					indegree[v]++;
				}
			}
			
			for(int u=0;u<N;u++){
				if(indegree[u] == 0){
					q.add(u);
				}
			}
			
			while(q.size() > 0){
				int u = q.pop();
				result.add(u);
				for(int v: adj.get(u)){
					indegree[v]--;
					if(indegree[v]==0)
						q.add(v);
				}
			}
			
			return result.toArray();
    }
}