/*
Given a binary matrix your task is to find all unique rows of the given matrix.
https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1#
*/

import java.lang.Math;
import java.util.*;

class UniqueRows{
	public static void main(String[] args)
	 {  Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			while(t-->0){
				int r=sc.nextInt();
				int c=sc.nextInt();
				int[][] a=new int [r][c];
				for(int i=0;i<r;i++)
					for(int j=0;j<c;j++)
						a[i][j]=sc.nextInt();
				GfG g=new GfG();
				ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
				for(int i = 0;i<arr.size();i++){
					ArrayList<Integer> demo = arr.get(i);
					for(int j = 0;j<demo.size();j++){
						System.out.print(demo.get(j)+" ");
					}
					System.out.print("$");
				}
				System.out.println();
			}
	 }
}

class TrieNode {
    HashMap<Integer,TrieNode> children;
    Boolean isEndOfWord;
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
    
    boolean insert(int[] arr, int n){
        TrieNode curr = root;
        for(int i=0;i<n;i++){
            if(!curr.children.containsKey(arr[i])){
                curr.children.put(arr[i],new TrieNode());
            }
            curr = curr.children.get(arr[i]);
        }
        if(curr.isEndOfWord)
            return false;
        curr.isEndOfWord = true;
        return true;
    }
}

class GfG
{
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Trie trie = new Trie();
        
        for(int i=0;i<r;i++){
            
            if(trie.insert(a[i],c)){
                
                ArrayList<Integer> list = new ArrayList<>();
                
                for(int j=0;j<c;j++){
                    list.add(a[i][j]);
                }
                
                result.add(list);
            }
        }
        
        return result;
    }
}