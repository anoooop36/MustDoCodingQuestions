/*
You don't need to read input or print anything. Your task is to complete the function countZeros() 
which takes the Binary Matrix A[][] and its size N as inputs and returns an integer denoting the total number of Zeros present in the matrix.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

https://practice.geeksforgeeks.org/problems/count-zeros-in-a-sorted-matrix/1#
*/

import java.util.*;

class Count_0_In_Sorted_Matrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new GfG().countZeros(arr, n));
		t--;
		}
	}
}// } Driver Code Ends


class GfG
{
    /*
        since array is sorted by row and column wise each last zero in column decides we need to look up in next column from 
        that row.
    */
    int countZeros(int arr[][], int N)
    {
        int i=N-1,j=0;

        int count = 0;
        
        while(j<N && i>=0){
            while(i>=0 && arr[i][j] == 1){
                i--;
            }
            count+= (i+1);
            j++;
        }
        
        return count;
    }
}