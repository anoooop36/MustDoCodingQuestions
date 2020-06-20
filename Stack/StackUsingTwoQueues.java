/*
Implement a Stack using two queues q1 and q2.
https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
*/

// { Driver Code Starts
    import java.util.*;


    class StackUsingQueues
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t>0)
            {
                Queues g = new Queues();
                
                int q = sc.nextInt();
                while(q>0)
                {
                    int QueryType = sc.nextInt();
                    if(QueryType == 1)
                    {
                        int a = sc.nextInt();
                        g.push(a);
                    }
                    else if(QueryType == 2)
                    System.out.print(g.pop()+" ");
                q--;
                }	
                System.out.println();
                    
                
                
            t--;
            }
        }
    }
    
    // } Driver Code Ends
    
    
    /*
        Idea is to make one of the operations costilier
        Push: simply push to q1
        Pop:  last element of q1 is top so move all elements except last to q2 and save last element in temp variable and remove that and swap q1 and q2 and return temp
    */

    class Queues
    {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        /*The method pop which return the element poped out of the stack*/
        int pop()
        {
            if(q1.size() == 0)
                return -1;
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            int val = q1.poll();
            //swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            
            return val;
        }
        
        /* The method push to push element into the stack */
        void push(int a)
        {
            q1.add(a);
        }
    }
    
    