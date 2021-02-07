/*
Given an array of lowercase strings A[] of size N, determine if the strings can be chained together to form a circle. A
string X can be chained together with another string Y if the last character of X is same as first
character of Y. If every string of the array can be chained, it will form a circle.

For eg for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"
https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1
*/

import java.lang.*;
import java.io.*;
class GFG
 {
	 /*
		Exponential complexity
	 */
	static boolean isCircleExist(char first, char last, int count, String strs[], boolean vis[], int n){
        if(count == n){
            return first == last;
        } else {
            for(int i=0;i<n;i++){
                if(!vis[i] && last == strs[i].charAt(0)){
                    vis[i] = true;
                    if(isCircleExist(first,strs[i].charAt(strs[i].length()-1), count+1, strs, vis, n))
                        return true;
                    vis[i] = false;
                }
            }
        }
        return false;
    }
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        boolean vis[] = new boolean[n];
	        Arrays.fill(vis,false);
	        vis[0] = true;
	        if(isCircleExist(strs[0].charAt(0),strs[0].charAt(strs[0].length()-1),1,strs,vis,n)){
	            sb.append("1\n");
	        } else{
	            sb.append("0\n");
	        }
	    }
	    System.out.print(sb);
	 }
}