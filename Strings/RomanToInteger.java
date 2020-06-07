/*
Given an string in roman no format (s)  your task is to convert it to integer .
https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        start from right if ith roman number is less then i+1 th roman number substract ith integer from result
        else add
     */
     static int romanToInteger(String roman, int n){
         HashMap<Character, Integer> roamanLiteralToIntegerMap = new HashMap<>();
         roamanLiteralToIntegerMap.put('I',1);
         roamanLiteralToIntegerMap.put('V',5);
         roamanLiteralToIntegerMap.put('X',10);
         roamanLiteralToIntegerMap.put('L',50);
         roamanLiteralToIntegerMap.put('C',100);
         roamanLiteralToIntegerMap.put('D',500);
         roamanLiteralToIntegerMap.put('M',1000);
         
         int integerNumber = roamanLiteralToIntegerMap.get(roman.charAt(n-1));
         
         for(int i=n-2;i>=0;i--){
             if(roamanLiteralToIntegerMap.get(roman.charAt(i)) < roamanLiteralToIntegerMap.get(roman.charAt(i+1))){
                 integerNumber -= roamanLiteralToIntegerMap.get(roman.charAt(i));
             } else {
                 integerNumber += roamanLiteralToIntegerMap.get(roman.charAt(i));
             }
         }
         return integerNumber;
     }
     
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        sb.append(romanToInteger(str,str.length())+"\n");
	    }
	    System.out.print(sb);
	 }
}