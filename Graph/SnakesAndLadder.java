import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}

class Solution{
    
    /*
        Idea is to do bfs use a map for snakes and ladder and a visited array to avoid loops
    */
    static int minThrow(int N, int arr[]){
        int throwsCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean visited[] = new boolean[31];
        
		/*put snakes and ladders in map*/
        for(int i=0;i<2*N;i+=2){
            map.put(arr[i],arr[i+1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
		
		/*handle snake or ladder at 1*/
        visited[1] = true;
        if(map.containsKey(1)){
            Integer next = map.get(1);
            visited[next] = true;
            q.add(next);
        } else {
            q.add(1);
        }
        
		/*mark first throw*/
        q.add(null);
        
        while(q.size() > 0){
            Integer curr = q.poll();
            if(curr == null){
                throwsCount++;
                if(q.size() > 0)
                    q.add(null);
            }             
            else if(curr == 30){
                return throwsCount;
            }
            else {
                for(int i=1;i<=6;i++){
                    int next = curr+i;
                    if(next <= 30 && !visited[next]){
                        visited[next] = true;
                        if(map.containsKey(next)){
							/*handle snake or ladder case*/
                            next = map.get(next);
                            visited[next] = true;
                        }
                        q.add(next);
                    }
                }
            }
        }
        
        if(!visited[30])
            return -1;
        
        return throwsCount;
    }
}