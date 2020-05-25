/*
Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    
    // use two varible solution to find sum by extending to three variable. Sort Array. For each element from right most
    // use two variables to find sum equivalent to right most element.
    static boolean isPythagoreanTripletExist(int arr[], int n){
        Arrays.sort(arr);
        
        for(int i=n-1;i>=2;i--){
            int k=i-1;
            int j=0;
            while(j<k){
                double a2 = Math.pow(arr[j],2);
                double b2 = Math.pow(arr[k],2);
                double c2 = Math.pow(arr[i],2);
                if(a2+b2 == c2){
                    return true;
                } else if(a2+b2 < c2){
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return false;
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        if(isPythagoreanTripletExist(arr,n))
	            sb.append("Yes"+"\n");
	        else
	            sb.append("No"+"\n");
	    }
	    System.out.print(sb);
	 }
}