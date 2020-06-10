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
        Idea is to use sliding window worst case O(n).
        every time a repeated character found start fresh from current repeated character index+1 (as there can't)
        be bigger substring including it.
        Use map of (char and index) to get length and previous index (if it is repeatition of current char).
        Maintain a Start variable which points to index from where no repetition has been found yet . Every time a
        a repeated char found Update start accordingly.
    */
    static int getMaxLengthDistictCharString(String str, int n){
        
        int maxLength = 0;
        int startIndex = 0;
        int map[] = new int[256];
        Arrays.fill(map, -1);
        
        for(int i=0; i<n; i++){
            
            int previousIndexOfCurrChar = map[str.charAt(i)];
            
            // Repetition found
            if(previousIndexOfCurrChar != -1){
                
                // valid duplicate as its last char index is greater than start index (from where all are distinct) 
                if(previousIndexOfCurrChar >= startIndex){
                    
                    maxLength = Math.max(maxLength, i-startIndex);
                    
                    // set start index to next to first of duplicates
                    startIndex = previousIndexOfCurrChar + 1;
                }
            }
            
            // always put latest index of current char
            map[str.charAt(i)] = i;
        }
        
        // cover if no duplicates found for last run
        return Math.max(maxLength, n-startIndex);
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