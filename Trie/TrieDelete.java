/*
Trie is an efficient information retrieval data structure. This data structure is used to store Strings and search strings,
String stored can also be deleted so, Your task is to complete the function deleteKey to delete the given string A.
The String A if exists in the larger String, must be deleted from Trie. Larger string contains space separated small strings.
And if the string is deleted successfully than 1 will be printed.
If any other string other than String A is deleted, you will get wrong answer.
https://practice.geeksforgeeks.org/problems/trie-delete/1#
*/

import java.util.*;
 
class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
public class TrieTest
{   private static TrieNode root;
    TrieTest(){
        root = new TrieNode(' '); 
		}
    public static void main(String[] args)
    {   Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		TrieTest z=new TrieTest(); 
		GfG g = new GfG();
		int n=sc.nextInt();
		ArrayList<String> keys=new ArrayList<String>();
		for(int i=0;i<n;i++){
			keys.add(sc.next());}
		for(int i = 0; i < keys.size(); i++)
		{
			insert(keys.get(i));
		}
		String abc=sc.next();
		g.deleteKey(root,abc);
		if(ifExsist(abc)==false)
		System.out.print("1");
		else
			System.out.print("");
		System.out.println();
		}
	}		
	public static boolean ifExsist(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
	public static void insert(String word)
    {
        if (ifExsist(word) == true) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
}


class GfG
{
    public static boolean deleteKeyUtil(TrieNode root, String word, int i, int n){
        if(i<n && root != null){
            TrieNode curr = root.subNode(word.charAt(i));
            if(curr != null){
                if(deleteKeyUtil(curr,word,i+1,n)){
                    if(i==n-1){
                        // last character
                        curr.isEnd = false;
                    }
                    if(curr.childList.size() == 0){
                        root.childList.remove(curr);
                    }
                    return root.childList.size() == 0;
                }
            }
            return false;
        }
        return true;
    }
    
    public static void deleteKey(TrieNode root,String word)
    {
        // case 1: last node has child
        // case 2: last node doesnt have child (remove current node but remove parent only if it is not endOfWord and has only one child)
        deleteKeyUtil(root,word,0,word.length());
     }
}