/*
Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum 
number of platforms required for the railway station so that no train waits.
Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure 
times will not be same for a train, but we can have arrival time of one train equal to departure of the other. 
In such cases, we need different platforms, i.e at any given instance of time, same platform can not be used for 
both departure of a train and arrival of another.
https://practice.geeksforgeeks.org/problems/minimum-platforms/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;


class GFG
 {
    // Arrivals will always increment number of platforms required, Departure will Always require reduction in number
    // of platforms. Keep Arrival and departure time in sorted order. iterate through sorted array and increment number
    // of platforms if its arrival otherwise decement it.
    static int getNumberOfPlatforms(int arrival[], int departure[], int n){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        
        int arrivalIndex=0,departureIndex=0;
        int numberOfPlatforms = 0;
        int max = Integer.MIN_VALUE;
        
        while(arrivalIndex<n){
            if(arrival[arrivalIndex] <= departure[departureIndex]){
                numberOfPlatforms++;
                arrivalIndex++;
            } else {
                numberOfPlatforms--;
                departureIndex++;
            }
            max = Math.max(max,numberOfPlatforms);
        }
        
        return max;
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split("\\s+");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        strs = br.readLine().split("\\s+");
	        int arr2[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr2[i] = Integer.parseInt(strs[i]);
	        }
	        sb.append(getNumberOfPlatforms(arr,arr2,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}
