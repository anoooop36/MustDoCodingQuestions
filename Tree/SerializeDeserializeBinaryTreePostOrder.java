class Tree {
    /*
        Use preorder or postorder to serialize tree. its not space optimized as there will be n data and (n+1) null nodes
        We can do space optimization by maintaining a Arraylist of bits representing leaf and non leaf nodes along with preorder list of data nodes. 
        We need to put marker for single child.
    */
	public void serialize(Node root, ArrayList<Integer> A) {
	    if(root == null){
	        A.add(null);
	        return;
	    }
	    serialize(root.left, A);
	    serialize(root.right, A);
	    A.add(root.data);
	}
	
    public Node deSerialize(ArrayList<Integer> A){
        Integer data = A.remove(A.size()-1);
        if(data == null)
            return null;
        Node root = new Node(data);
        root.right = deSerialize(A);
        root.left = deSerialize(A);
        return root;
    }
}