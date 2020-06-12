import java.util.*;
import java.lang.*;
import java.io.*;

class CompareString implements Comparator<String> {
    
    // Two string comparison based on first chaaracter (not whol string)
    public int compare(String a, String b){
        
        int minLength = Math.min(a.length(), b.length());
        if(minLength > 0){
            return a.charAt(0) - b.charAt(0);
        }
        return a.length() - b.length();
    }
}

class GFG
 {
    static String getCommonPrefix(String[] strs, int n){
        
        // sort strings by comparing only first character of strings
        Arrays.sort(strs, new CompareString());
        
        int minLength = Integer.MAX_VALUE;
        
        // get min from all string lengths
        for(int i=0;i<n;i++){
            minLength  = Math.min(minLength, strs[i].length());
        }
        
        // compare first and last strings of array till min length (of all strings)
        for(int i=0;i<minLength;i++){
            if(strs[0].charAt(i) != strs[n-1].charAt(i)){
                if(i==0)
                    return "-1";
                return strs[0].substring(0,i);
            }
        }
        
        return strs[0].substring(0, minLength);
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        sb.append(getCommonPrefix(strs,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}