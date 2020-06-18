// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class gfg
{
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    //sc.next();
    while(t-- > 0)
    {
        int n = sc.nextInt();
        
        int A[]  =new int[1000];
        int B[] = new int[1000];
        int C[] = new int[1000];
        
        for(int i = 0; i < n; i++)
        {
            int a =sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            A[i] = a;
            B[i] = b;
            C[i] = c;
        }
        
        Geeks ob = new Geeks();
        System.out.println(ob.maxHeight(A,B,C,n));
    }
   }
}// } Driver Code Ends


//User function Template for Java

class Box implements Comparable<Box> {
    int h,w,l;
    Box(int h, int w, int l){
        if(w<l){
            int temp = l;
            l = w;
            w = temp;
        }
        this.h = h;
        this.w = w;
        this.l = l;
    }
    // checke for strictly increasing first then decide base on area
    public int compareTo(Box b){
        if(this.l<b.l && this.w < b.w){
            return 1;
        } else{
            return b.l*b.w- this.l*this.w;
        }
    }
}


class Geeks 
{
    /*
        f(n) = max(box[n].h, box[n].h + f(j)) where 0<=j<=n && box[n].l < box[j].l && box[n].w < box[j].w
    */
   public static int maxHeight(int height[], int width[], int length[], int n)
   {
       // your code here
       Box[] allboxes = new Box[3*n];
       int index = 0;
       // rotate boxes and create new one (3 for 1 box)
       for(int i=0;i<n;i++){
           int l = height[i]; 
           int w = width[i];
           int h = length[i];
           allboxes[index] =   new Box(l,w,h);
           allboxes[index+1] = new Box(w,h,l);
           allboxes[index+2] = new Box(h,w,l);
           index +=3;
       }
       // sort boxes base in descending order
       Arrays.sort(allboxes);
       
       int dp[] = new int[3*n];
       dp[0] = allboxes[0].h;
       int maxHeight = Integer.MIN_VALUE;
       
       for(int i=1;i<3*n;i++){
           int leftMax = 0;
           for(int j=0;j<i;j++){
               if(allboxes[i].l < allboxes[j].l && allboxes[i].w < allboxes[j].w){
                   leftMax = Math.max(leftMax, dp[j]);
               }
           }
           dp[i] = allboxes[i].h + leftMax;
           maxHeight = Math.max(maxHeight, dp[i]);
       }
       
       return maxHeight;
   }
}

