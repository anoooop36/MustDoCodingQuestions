/*
You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. 
First line of each test case contains an integer Q denoting the number of queries.
A Query Q may be of 3 Types:
    1. 1 x (a query of this type means  pushing 'x' into the stack)
    2. 2 (a query of this type means to pop element from stack and print the poped element)
    3. 3 (a query of this type means to print the minimum element from the stack)
The second line of each test case contains Q queries seperated by space.
https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
*/



// { Driver Code Starts
    import java.util.*;



    class Get_Min_From_Stack
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while(T>0)
            {
                int q = sc.nextInt();
                GfG g = new GfG();
                while(q>0)
                {
                    int qt = sc.nextInt();
                    
                    if(qt == 1)
                    {
                        int att = sc.nextInt();
                        g.push(att);
                        //System.out.println(att);
                    }
                    else if(qt == 2)
                    {
                        System.out.print(g.pop()+" ");
                    }
                    else if(qt == 3)
                    {
                        System.out.print(g.getMin()+" ");
                    }
                
                q--;
                }
                System.out.println();
            T--;
            }
            
        }
    }
    
    
    // } Driver Code Ends
    
    
    /*
        Idea is to use same stack for keeping previous minimum element
        Need to keep previous minimum only when current number is smaller than previous min
        Push
        1) keep x as it is in stack if x >= previousMin
        2) keep x-previousMin in stack if x < previousMin    (x-previousMin < currMin) helps to get previousMin from currentMin (or x)

        Pop
        1) return currMin if stack.peek() < currMin and update currMin by currMin-stack.peek()
        2) return stack.peek();
    */

    class GfG
    {
        int minEle=-1;
        Stack<Integer> s = new Stack<>();
    
        /*returns min element from stack*/
        int getMin()
        {
            return minEle;
        }
        
        /*returns poped element from stack*/
        int pop()
        {
            if(s.size()>0){
                int currentNum = s.peek();
                if(minEle > s.peek()){
                    currentNum = minEle;
                    minEle = minEle - s.peek();
                }
                s.pop();
                if(s.size() == 0)
                    minEle = -1;
                return currentNum;
            }
            return -1;
        }
    
        /*push element x into the stack*/
        void push(int x)
        {
            if(s.size() == 0){
                s.push(x);
                minEle = x;
            } else {
                if(minEle > x){
                    s.push(x-minEle);
                    minEle = x;
                } else {
                    s.push(x);
                }
            }
        }	
    }
    
    