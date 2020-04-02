class Demo {
	public static void main(String[] commands) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(5);
		tree.insert(7);
		tree.insert(3);
		tree.print();
	}
}

class BinarySearchTree {
	Node root = null;
	void insert(int k) {
		root = insert(root, k);
	}
	Node insert(Node r, int k) {
		if (r == null) {
			r = new Node();
			r.key = k;
			return r;
		}
		if (k <  r.key) { r.left  = insert(r.left,  k); }
		if (k >= r.key) { r.right = insert(r.right, k); }
		return r;
	}
	void print() {
		print(root);
	}
	void print(Node r) {
		if (r.left  != null) { print(r.left); }
		System.out.println(r.key);
		if (r.right != null) { print(r.right); }
	}
	class Node {
		int key;
		Node left;
		Node right;
	}
}
