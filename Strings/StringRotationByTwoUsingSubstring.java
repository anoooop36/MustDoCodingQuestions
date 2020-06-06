import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    StringBuffer sb = new StringBuffer();
	    while(t-- > 0){
	        String str1 = sc.next();
	        String str2 = sc.next();
	        int l2 = str2.length();
	        String str3 = str2.substring(2,l2) + str2.substring(0,2);
	        String str4 = str2.substring(l2-2,l2) + str2.substring(0,l2-2);
	        if(str1.equals(str3) || str1.equals(str4)){
	            sb.append("1\n");
	        } else {
	            sb.append("0\n");
	        }
	    }
	    System.out.print(sb);
	 }
}