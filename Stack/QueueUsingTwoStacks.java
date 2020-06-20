/*
Implement a Queue using 2 stacks s1 and s2 .
https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1
*/



/*
    Idea is use one stack for push and one for pop operations
    add: push to st1
    remove: move all elements of st1 to st2 if st2 is empty. return top element of st2 
*/
class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();


    void Push(int x)
    {
	   s1.push(x);
    }
	
    int Pop()
    {
	   if(s2.size() > 0)
	        return s2.pop();
	   else if(s1.size() == 0){
	       return -1;
	   } else {
	       while(s1.size() > 0 ){
	           s2.push(s1.pop());
	       }
	       return s2.pop();
	   }
    }
}