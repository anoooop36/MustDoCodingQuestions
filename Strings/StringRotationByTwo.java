/*
Given two strings a and b. The task is to find if a string 'a' can be obtained by rotating another string 'b' by 2 places.
https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static boolean isRotationByTwoPlaces(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        
        if(m != n)
            return false;
            
        if(n==1){
            return str1.charAt(0) == str2.charAt(0);
        }
        
        boolean isClockWise = true;
        boolean isAntiClockWise = true;
        
        int clockWiseStart = n-2;
        int antiClockWiseStart = 2;
        
        for(int i=0;i<n;i++){
            int j = (i+clockWiseStart)%n;
            int k = (i+antiClockWiseStart)%n;
            if(str1.charAt(j) != str2.charAt(i)){
                isClockWise = false;
            }
            if(str1.charAt(k) != str2.charAt(i)){
                isAntiClockWise = false;
            }
        }
        
        return isAntiClockWise || isClockWise;
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str1 = br.readLine();
	        String str2 = br.readLine();
	        if(isRotationByTwoPlaces(str1,str2))
	            sb.append(1+"\n");
	        else
	            sb.append(0+"\n");
	    }
	    System.out.print(sb);
	 }
}