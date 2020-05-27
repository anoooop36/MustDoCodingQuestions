/*
Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
The result is going to be very large, hence return the result in the form of a string.
https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
/*
doing individual string comparison is difficult in case to all characters of str1 matches with all characters of
str2 and some character are remaining in str1 or str2.

Important: concatnation of str1+str2 is compared with str2+str1 use this idea to sort string array

*/
class ConcatenationComparator implements Comparator<String> {
    public int compare(String str1, String str2){
        String str1str2 = str1+str2;
        String str2str1 = str2+str1;
        return str1str2.compareTo(str2str1);
    }
}

class GFG
 {
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        Arrays.sort(strs, new ConcatenationComparator());
	        //int arr[] = new int[n];
	        for(int i=n-1;i>=0;i--){
	            //arr[i] = Integer.parseInt(strs[i]);
	            sb.append(strs[i]);
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}