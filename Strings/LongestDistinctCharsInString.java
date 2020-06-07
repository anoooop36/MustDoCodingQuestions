/*
Given a string S, find length of the longest substring with all distinct characters.  For example, for input "abca", 
the output is 3 as "abc" is the longest substring with all distinct characters.
https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /*
        every time a repeated character found start fresh from current repeated character index+1 (as there cann't)
        be bigger substring including it.
        Idea is to use sliding window worst case O(n2)
    */
    static int getMaxLengthDistictCharString(String str, int n){
        int maxLength = 0;
        for(int i=0; i<n; i++){
            
            int vis[] = new int[256];
            Arrays.fill(vis, -1);
            
            int currLength = 0;
            
            // get cuurent distinct count
            while(i<n && vis[str.charAt(i)] == -1){
                currLength++;
                vis[str.charAt(i)] = i;
                i++;
            }
            
            // considered while loop break on repeated character, set start of window to next of it
            if(i<n){
                i = vis[str.charAt(i)];
            }
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        sb.append(getMaxLengthDistictCharString(str,str.length())+"\n");
	    }
	    System.out.print(sb);
	 }
}