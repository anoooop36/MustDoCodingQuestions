/*
Given an input stream of N characters consisting only of lower case alphabets. The task is to find the first non repeating 
character, each time a character is inserted to the stream. If no non repeating element is found print -1.
https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    int index, count;
    char c;

    Pair(int index, int count, char c) {
        this.index = index;
        this.count = count;
        this.c = c;
    }
}

class GFG {
    /*
     * maintain visited of sized 256 to keep track of all found characters count and
     * their indexes.
     */
    static String firstNonRepeatingCharacterInStream(char[] arr, int n) {

        StringBuffer sb = new StringBuffer();
        Pair[] visited = new Pair[256];
        Arrays.fill(visited, null);

        for (int i = 0; i < n; i++) {
            char c = arr[i];
            // add character to visited
            if (visited[c] == null) {
                visited[c] = new Pair(i, 1,c);
            } else {
                visited[c].count++;
            }

            // Serach non-repeated
            Pair nonRepeatedPair = null;
            for (int j = 0; j < 256; j++) {
                if (visited[j] != null) {
                    if (visited[j].count == 1) {
                        if (nonRepeatedPair == null) {
                            nonRepeatedPair = visited[j];
                        } else {
                            if (nonRepeatedPair.index > visited[j].index) {
                                nonRepeatedPair = visited[j];
                            }
                        }
                    }
                }
            }
            // add to solution
            if (nonRepeatedPair == null) {
                // not found
                sb.append("-1 ");
            } else {
                sb.append(nonRepeatedPair.c + " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String strs[] = br.readLine().split(" ");
            char arr[] = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = strs[i].charAt(0);
            }
            sb.append(firstNonRepeatingCharacterInStream(arr, n) + "\n");
        }
        System.out.print(sb);
    }
}