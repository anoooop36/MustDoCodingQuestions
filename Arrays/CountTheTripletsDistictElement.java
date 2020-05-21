/*
Given an array of distinct integers. 
The task is to count all the triplets such that sum of two elements equals the third element.
https://practice.geeksforgeeks.org/problems/count-the-triplets/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    // Use two pointer method to find sum in sorted array
    // this will not work with non-distinct element array, ex: [4,3,1,5,3,6]
    // use dictionary for better solution cases: 000, 0xx, xy(x+y)
    static int getTripleCount(int arr[], int n){
        int count = 0;
        Arrays.sort(arr);
        for(int i=n-1;i>1;i--){
            int j=0,k=i-1;
            while(j<k){
                if(arr[i] == arr[j]+arr[k]){
                    count++;
                    j++;k--;
                } else if(arr[i]>arr[j]+arr[k]){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return count==0?-1:count;
    }
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        sb.append(getTripleCount(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}