/*
Given an array A of N integers, find any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k.	
https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1
*/


import java.util.*;
import java.io.*;
class SubSeq {
    public static boolean isSubSequence(ArrayList<Integer> v1, ArrayList<Integer> v2,
                                 int n, int m) {

        if (m == 0) return true;
        if (n == 0) return false;

        if (v1.get(n - 1).equals(v2.get(m - 1)))
            return isSubSequence(v1, v2, n - 1, m - 1);

        return isSubSequence(v1, v2, n - 1, m);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(str[i]));
            }
            GfG g = new GfG();
            ArrayList<Integer> res = g.find3Numbers(a, n);

            // wrong format output
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            }

            if (res.isEmpty()) {
                System.out.println(0);
            } else if ((res.get(0) < res.get(1)) && (res.get(1) < res.get(2)) &&
                       isSubSequence(a, res, n, res.size())) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
}


class GfG {

    /*
    	idea is to consider each element one by one to do that we need to know min from left and max from right
	maintain two auxilary array of minFromLeft and maxFromRight.
    */
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        int[] smallerFromLeft = new int[n];
        int[] largerFromRight = new int[n];
        
        smallerFromLeft[0] = arr.get(0);
        largerFromRight[n-1] = arr.get(n-1);
        
        for(int i=1;i<n;i++){
            smallerFromLeft[i] = Math.min(smallerFromLeft[i-1], arr.get(i));
            largerFromRight[n-i-1] = Math.max(largerFromRight[n-i],arr.get(n-i-1));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=1;i<n-1;i++){
            if(smallerFromLeft[i] < arr.get(i) && largerFromRight[i] > arr.get(i)){
                result.add(smallerFromLeft[i]);
                result.add(arr.get(i));
                result.add(largerFromRight[i]);
                return result;
            }
        }
        
        return result;
    }
}
