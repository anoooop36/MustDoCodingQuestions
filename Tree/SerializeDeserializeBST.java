/**
 * Definition for a binary tree node. 
 * public class TreeNode 
 * { 
 *   int val; 
 *   TreeNode left;
 *   TreeNode right; 
 *   TreeNode(int x) 
 *   { 
 *     val = x; 
 *   } 
 * }
 */


/*
    idea is to use preorder form to serialize BST
    only Preorder or PostOrder of BST is enough for reconstruction of BST.
*/

class PreIndex {
    int val = 0;
}

public class Codec {

    public void serializeUtil(TreeNode root, StringBuffer res) {
        if (root == null)
            return;

        res.append(root.val);
        
        if (root.left != null)
            res.append(" " + serialize(root.left));
        if (root.right != null)
            res.append(" " + serialize(root.right));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        serializeUtil(root, res);
        return res.toString();
    }

    public TreeNode deserializeUtil(int[] preorder, int min, int max, PreIndex preIndex, int n) {
        if (preIndex.val >= n)
            return null;
        int curr = preorder[preIndex.val];
        if (curr > min && curr < max) {
            TreeNode newNode = new TreeNode(curr);
            preIndex.val++;
            newNode.left = deserializeUtil(preorder, min, curr, preIndex, n);
            newNode.right = deserializeUtil(preorder, curr, max, preIndex, n);
            return newNode;
        }
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String strs[] = data.split(" ");
        int arr[] = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        return deserializeUtil(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, new PreIndex(), arr.length);
    }
}