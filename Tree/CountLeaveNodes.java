/*
Given a Binary Tree of size N , You have to count leaves in it. For example, there are two leaves in following tree

        1
     /      \
   10      39
  /
5

https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
*/

class Tree
{
    int countLeaves(Node node) 
    {
         if(node == null)
            return 0;
        
         if(node.left == null && node.right == null)
            return 1;
        
         return countLeaves(node.left) + countLeaves(node.right);
    }
}