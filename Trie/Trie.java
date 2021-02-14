import java.io.*;
import java.util.*;

class TrieNode{
	HashMap<Character, TrieNode> children;
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
	void insert(String key){
		TrieNode curr = root;
		for(int i=0;i<key.length();i++){
			char c = key.charAt(i);
			if(!curr.children.containsKey(c)){
				curr.children.put(c, new TrieNode());
			}
			curr = curr.children.get(c);
		}
		curr.isEndOfWord = true;
	}

	
	boolean search(String key){
		TrieNode curr = root;
		for(int i=0;i<key.length() && curr != null;i++){
			char c = key.charAt(i);
			if(!curr.children.containsKey(c)){
				return false;
			}
			curr = curr.children.get(c);
		}
		if(curr != null)
			return curr.isEndOfWord;
		return false;
	}
	
	boolean deleteKeyUtil(TrieNode parent, String word, int i, int n){
        if(i<n && parent != null){
			char c = word.charAt(i);
            TrieNode curr = parent.children.get(c);
            if(curr != null){
                if(deleteKeyUtil(curr,word,i+1,n)){
                    if(i==n-1){
                        // last character
                        curr.isEndOfWord = false;
                    }
                    if(curr.children.size() == 0){
                        parent.children.remove(c);
                    }
                    return parent.children.size() == 0;
                }
            }
            return false;
        }
        return true;
    }
	
	void delete(String word){
		// case 1: last node has child
        // case 2: last node doesnt have child (remove current node but remove parent only if it is not endOfWord and has only one child)
		deleteKeyUtil(root,word,0,word.length());	
	}
	
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("The");
		trie.insert("Theme");
		trie.insert("Jog");
		System.out.println(trie.search("Bob")==false);
		System.out.println(trie.search("The")==true);
		trie.delete("The");
		System.out.println(trie.search("The")==false);
		System.out.println(trie.search("Theme")==true);
		System.out.println(trie.search("Themes")==false);
	}
}


