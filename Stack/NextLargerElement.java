/*
Given an array A of size N having distinct elements, the task is to find the next greater element for each element
of the array in order of their appearance in the array. If no such element exists, output -1 
https://practice.geeksforgeeks.org/problems/next-larger-element/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        use stack to keep track on numbers for which no larger number found.
        start from left. remove all smaller elements from stack current is larger then them
        and push current element index.
        for all elements of stack, next larger not found put -1
     */
    static long[] nextLargerElement(long arr[], int n){
        
            Stack<Integer> st = new Stack<Integer>();
            long result[] =  new long[n];
            
            for(int i=0; i<n; i++){
                
                while(st.size()!=0 && arr[st.peek()] < arr[i]){
                    result[st.peek()] = arr[i];
                    st.pop();
                }
                
                st.push(i);
            }
            
            while(st.size() > 0){
                result[st.peek()] = -1;
                st.pop();
            }
            
            return result;
    }
	 
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine().strip());
	        String strs[] = br.readLine().split("\\s+");
	        long arr[] = new long[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Long.parseLong(strs[i]);
	        }
	        long[] res = nextLargerElement(arr,n);
	        for(int i=0;i<n;i++){
	            sb.append(res[i]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}