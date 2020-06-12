/*You are required to complete this method */
class GfG
{
    int atoi(String str)
    {
	    int n = str.length();
	    
	    int value = 0;
	    
	    for(int i=n-1;i>=0;i--){
	        
	        int currNum = str.charAt(i) - '0';
	        
	        if(currNum >= 0 && currNum <= 9){
	            
	            value += currNum * Math.pow(10, n-1-i);
	            
	        } else if(i == 0 && str.charAt(i) == '-'){
	            
	            return -value;
	            
	        } else{
	            
	            return -1;
	            
	        }
	    }
	    return value;
    }
}