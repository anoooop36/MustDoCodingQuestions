/*
Given a dictionary of distinct words and an M x N board where every cell has one character. 
Find all possible words from the dictionary that can be formed by a sequence of adjacent characters on the board. 
We can move to any of 8 adjacent characters, but a word should not have multiple instances of the same cell.
https://practice.geeksforgeeks.org/problems/word-boggle4143/1#
*/

import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;
    
    TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false;
    }
    
}

class Trie {
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    
    void insertWord(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }
}

class Solution
{
    int X[] = {0,0,1,-1,1,1,-1,-1};
    int Y[] = {1,-1,0,0,1,-1,1,-1};
    
    boolean isValidMove(int i, int j, int r, int c, boolean[][] visited, char[][] board, TrieNode node){
        if(i<0 || j<0 || i>=r || j>=c|| visited[i][j] || !node.children.containsKey(board[i][j]))
            return false;
        return true;
    }
    
    boolean findWordDfs(int i, int j, int r, int c, boolean[][] visited, char[][] board, String word, LinkedHashSet<String> result, TrieNode node){
        if(isValidMove(i,j,r,c,visited,board, node)){
            char chr = board[i][j];
            visited[i][j] = true;
            word = word+chr;
            if(node.children.get(chr).isEndOfWord){
                result.add(word);
            }
            
            for(int k=0;k<8;k++){
                int nextX = X[k]+i;
                int nextY = Y[k]+j;
                findWordDfs(nextX,nextY,r,c,visited,board,word,result, node.children.get(chr));
            }
            visited[i][j]= false;
        }
        return false;
    }
    
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // build trie of words
        Trie trie = new Trie();
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0;i<dictionary.length;i++){
            String word = dictionary[i];
            trie.insertWord(word);
        }
        
        boolean visited[][] = new boolean[r][c];
        LinkedHashSet<String> result = new LinkedHashSet<>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                findWordDfs(i,j,r,c,visited,board,"",result, trie.root);
            }
        }
        
        int length = 0;
        for(int i=0;i<dictionary.length;i++){
            if(result.contains(dictionary[i])){
                 length++;
            }
        }
        String[] res = new String[length];
        int j=0;
        for(int i=0;i<dictionary.length;i++){
            if(result.contains(dictionary[i])){
                 res[j++] = dictionary[i];
            }
        }
        return res;
    }
}