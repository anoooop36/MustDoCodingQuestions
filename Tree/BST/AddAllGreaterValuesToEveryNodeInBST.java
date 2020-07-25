/*
Given a BST, modify it so that all greater values in the given BST are added to every node.

https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            root = T.modify(root);
            inorder(root);
            System.out.println();
            t--;
        }
    }
    
    static void inorder(Node root)
    {
        if(root==null)  return;
    
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
// } Driver Code Ends


class Solution{
    
    /*
        idea is to do reverse inorder (right, root, left) and maintain previous sum (reverse inorder visits node in descending order)
        so previous will have sum of all greater elements than current.
    */
    
    int modifyUtil(Node root, int previousSum){
        if(root == null)
            return previousSum;
        int rightSum = modifyUtil(root.right, previousSum);
        root.data = root.data  + rightSum;
        return modifyUtil(root.left, root.data);
    }
    
    
    public Node modify(Node root)
    {
        //Write your code here
        
        modifyUtil(root, 0);
        return root;
    }
    
}