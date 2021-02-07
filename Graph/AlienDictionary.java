/*
Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if 
the order of string returned by the function is correct else 0 denoting incorrect string returned.
https://practice.geeksforgeeks.org/problems/alien-dictionary/1
*/

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}


class Solution
{
    void topologicalTraversal(char u, HashMap<Character, ArrayList<Character>> graph, Stack<Character> st, Set<Character> visited){
        visited.add(u);
        if(graph.containsKey(u)){
            for(Character v: graph.get(u)){
                if(!visited.contains(v)){
                    topologicalTraversal(v,graph,st,visited);
                }
            }
        }
        st.add(u);
    }
    
    /*
        idea is to build directed grpah of characters and do topological sort to get order of characters
    */
    public String findOrder(String [] dict, int N, int K)
    {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        Stack<Character> st = new Stack<>();
        Set<Character> visited = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        
        /*
            compare two adjacent words and build directed graph
        */
        for(int i=0;i<N-1;i++){
           String first = dict[i];
           String second = dict[i+1];
           int length = Math.min(first.length() ,second.length());
           int j=0;
           while(j<length){
               char u = first.charAt(j);
               char v = second.charAt(j);
               if(u != v){
                   
                   ArrayList<Character> list = graph.get(u);
                   if(list == null)
                        list = new ArrayList<Character>();
                   list.add(v);
                   graph.put(u,list);
                   
                   break;
               }
               j++;
           }
        }
        
        /*
            do topological traversal to find order of characters
        */
        for(Character u : graph.keySet()){
            if(!visited.contains(u)){
                topologicalTraversal(u,graph,st,visited);
            }
        }
        
        while(K>0 && st.size()>0){
            sb.append(st.pop());
            K--;
        }
        return sb.toString();
    }
}