/*
Given a string of length N of lowercase alphabet characters. The task is to complete the function countDistinctSubstring(),
which returns the count of total number of distinct substrings of this string.
https://practice.geeksforgeeks.org/problems/count-of-distinct-substrings/1#
*/

import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}

class TrieNode{
    HashMap<Character,TrieNode> children;
    
    TrieNode(){
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    
    int insertWord(String key, int i, int j){
        TrieNode curr = root;
        int count = 0;
        for(;i<=j;i++){
            char c = key.charAt(i);
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNode());
                count++;
            }
            curr = curr.children.get(c);
        }
        return count;
    }
}


class GfG
{
    /*
    The idea is create a Trie of all suffixes of given string. Once the Trie is constricted, 
    our answer is total number of nodes in the constructed Trie
    Each root to node path of a Trie represents a prefix of words present in Trie. Here words are suffixes.
    So each node represents a prefix of suffixes. Every substring of a string “str” is a prefix of a suffix of “str”.
    */
   public static int countDistinctSubstring(String st)
   {
        int n = st.length();
        int count = 0;
        
        Trie trie = new Trie();
        
        for(int i=0;i<n;i++){
            count += trie.insertWord(st,i,n-1);
        }
        
        return count+1;
   }
}