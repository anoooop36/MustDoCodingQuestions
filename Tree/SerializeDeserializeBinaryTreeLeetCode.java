public class Codec {

    public void serializeUtil(TreeNode root, StringBuffer res) {
        if (root == null) {
            res.append("N ");
            return;
        }
        res.append(root.val + " ");
        serializeUtil(root.left, res);
        serializeUtil(root.right, res);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        serializeUtil(root, res);
        // some space optimization
        int i = res.length() - 1;
        while (i > 0) {
            if (res.charAt(i) != 'N' || res.charAt(i) != ' ') {
                break;
            }
            i--;
        }
        return res.substring(0, i + 1);
    }

    public TreeNode deserializeUtil(Queue<String> q) {
        String val = q.poll();
        if (val.equals("N"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeUtil(q);
        root.right = deserializeUtil(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeUtil(new LinkedList<>(Arrays.asList(data.split(" "))));
    }
}