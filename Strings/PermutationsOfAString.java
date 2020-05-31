/*
Given a string S. The task is to print all permutations of a given string.
https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
    /*
        Swapping index i with index j will create new permutation
        idea is is to start swapping from 0 index n-1 index
        for each index i there would be n-i+1 swapps on its right and each swap will create a new permutation
    */
    static void allPermutation(char arr[], int index, int n, ArrayList<String> allPermutationList){
        if(index == n-1){
            allPermutationList.add(new String(arr));
        } else {
            for(int i=index;i<n;i++){
                swap(arr, index, i);
                allPermutation(arr, index+1, n, allPermutationList);
                // backtrack changes for next index of for loop
                swap(arr, index, i);
            }
        }
    }
     
    public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        char arr[] = str.toCharArray();
	        ArrayList<String> allPermutationList = new ArrayList<String>();
	        allPermutation(arr,0,arr.length,allPermutationList);
	        Collections.sort(allPermutationList);
	        for(String strPermutation : allPermutationList)
	            sb.append(strPermutation+" ");
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
 }