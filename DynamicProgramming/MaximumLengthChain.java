/*
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. 
A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which 
can be formed from a given set of pairs. 
https://practice.geeksforgeeks.org/problems/max-length-chain/1
*/


// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}
// } Driver Code Ends



class PairComparator implements Comparator<Pair> {
    public int compare(Pair a , Pair b){
        return a.x - b.x;
    }
}

class GfG
{
    // for index i length will be Max(1, 1+Max(f(j))) where j < i and arr[j].second < arr[i].first 
    int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr, new PairComparator());
        int max = Integer.MIN_VALUE;
        int dp[] =  new int[n];
        
        for(int i=0; i<n; i++){
            int leftMax = 0;
            for(int j=0; j<i; j++){
                if(arr[i].x > arr[j].y){
                    leftMax = Math.max(leftMax, dp[j]);
                }
            }
            dp[i] = Math.max(1, 1+leftMax);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}