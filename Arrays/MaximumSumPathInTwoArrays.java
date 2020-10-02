/*
Given two sorted arrays A and B, such that the arrays may have some common elements. Find the sum of the maximum sum path to reach from the beginning of any array to end of any of the two arrays. We can switch from one array to another array only at the common elements.
*/


import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		GfG g = new GfG();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}


class GfG
{
    /*
	maintain sum from first and second array in two variables when equal found choose max sum and reset sums to zero.
	Inorder to cover all crossing points traverse systmatically from lower to higher number from both arrays.
    */
    int maxPathSum(int arr1[], int arr2[])
    {
        int n = arr1.length;
        int m = arr2.length;
        
        int i=0;
        int j=0;
        
        int sum = 0;
        int first = 0;
        int sec = 0;
        
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                first += arr1[i];
                i++;
            } else if(arr1[i] > arr2[j]){
                sec += arr2[j];
                j++;
            } else {
                sum += Math.max(first, sec);
                sum += arr1[i];
                i++;
                j++;
                first = sec = 0;
            }
        }
        
        while(i<n){
            first += arr1[i];
            i++;
        }
        
        while(j<m){
            sec += arr2[j];
            j++;
        }
        
        sum += Math.max(first, sec);
        
        return sum;
    }
}
