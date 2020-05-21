/*
Problem: Given an unsorted array A of size N of non-negative integers, 
         find a continuous sub-array which adds to a given number S.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int leftIndex;
    int rightIndex;
    Pair(int l, int r){
        leftIndex = l;
        rightIndex = r;
    }
}
class GFG
{
 
    //sliding window O(n) solution    
    public static Pair getSubArray(long arr[], int n, long s){
        int i=0;
        int j = 0;
        long currSum = 0;
        while(j<n){
            currSum += arr[j];
            while(i<n && currSum > s){
                currSum -= arr[i];
                i++;
            }
            if(currSum == s){
                return new Pair(i+1,j+1);
            }
            j++;
        }
        return new Pair(-1,-1);
    }
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String strs[] = br.readLine().split(" ");
	        int n = Integer.parseInt(strs[0]);
	        long s = Long.parseLong(strs[1]);
	        strs = br.readLine().split(" ");
	        long arr[] = new long[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Long.parseLong(strs[i]);
	        }
	        Pair p = getSubArray(arr,n,s);
	        if(p.leftIndex != -1){
	            sb.append(p.leftIndex+" "+p.rightIndex+"\n");
	        } else{
	            sb.append("-1\n");
	        }
	    }
	    System.out.print(sb);
	 }
}