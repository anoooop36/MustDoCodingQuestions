class TopologicalSort {
    static void topoUtil(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, Stack<Integer> resultStack){
        visited[u] = true;
        for(int v: adj.get(u)){
            if(!visited[v]){
                topoUtil(adj,v,visited,resultStack);
            }
        }
        resultStack.push(u);
    }
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        boolean visited[] = new boolean[N];
        Stack<Integer> resultStack = new Stack<Integer>();
        Arrays.fill(visited, false);
        
        for(int u=0;u<N;u++){
            if(!visited[u]){
                topoUtil(adj,u,visited,resultStack);
            }
        }
        
        int result = new int[N];
        int i=0;
        while(i<N){
            result[i] = st.pop();
            i++;
        }
        return result;
    }
}