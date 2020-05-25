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

class Activity implements Comparable<Activity>{
    int time;
    int type;
    Activity(int time, int type){
        this.time = time;
        this.type = type;
    }
    
    public int compareTo(Activity a){
        if(this.time == a.time)
            return this.type - a.type;
        return this.time - a.time;
    }
}

class GFG
 {
    // Arrivals will always increment number of platforms required, Departure will Always require reduction in number
    // of platforms. Keep Arrival and departure time in sorted order. iterate through sorted array and increment number
    // of platforms if its arrival otherwise decement it.
    static int getNumberOfPlatforms(int arrival[], int departure[], int n){
        
        Activity time[] = new Activity[2*n];
        for(int i=0;i<n;i++){
            time[i] = new Activity(arrival[i],1);
            time[n+i] = new Activity(departure[i],2);
	    }
	    
	    // if arrival and departure arrays are sorted use two variables method to add them to time array in sorted
	    // order. O(n)
        Arrays.sort(time);
        
        int numberOfPlatforms = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<2*n;i++){
            if(time[i].type == 1){
                numberOfPlatforms++;
            } else {
                numberOfPlatforms--;
            }
            max = Math.max(numberOfPlatforms, max);
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