import java.util.*;
import java.io.*;

public class StackPermutationValidityCheck {

    static boolean isStackPermutation(int[] input, int n, int[] expected) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            st.push(input[i]);
            while (st.size() > 0 && st.peek() == expected[j]) {
                st.pop();
                j++;
            }
        }
        return j == n && st.size() == 0;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int expected[] = {2,1,3,5,4};
        System.out.println(isStackPermutation(arr, arr.length, expected));
        int expected2[] = {3,2,5,4,1};
        System.out.println(isStackPermutation(arr, arr.length, expected2));
        int expected3[] = {3,2,5,1,4};
        System.out.println(isStackPermutation(arr, arr.length, expected3));
    }
}