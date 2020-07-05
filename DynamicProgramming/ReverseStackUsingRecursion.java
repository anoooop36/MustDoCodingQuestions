import java.util.*;
import java.io.*;

public class ReverseStackUsingRecursion {

    public static void insertAtBottom(Stack<Integer> st, int num) {
        if(st.size() == 0){
            st.push(num);
        } else {
            int temp = st.pop();
            insertAtBottom(st, num);
            st.push(temp);
        }
    }
    
    public static void reverseStack(Stack<Integer> st) {
        if(st.size() > 0){
            int temp = st.pop();
            reverseStack(st);
            insertAtBottom(st, temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        reverseStack(st);
        StringBuffer sb = new StringBuffer();
        while(st.size() > 0){
            sb.append(st.pop());
        }
        System.out.println("1234".equals(sb.toString()));
    }

}