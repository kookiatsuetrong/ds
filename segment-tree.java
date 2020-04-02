class Demo {
	public static void main(String[] commands) {
		SegmentTree tree = new SegmentTree( 3, 2, 4, 5, 7, 8, 2, 1, 9 );
										//  0  1  2  3  4  5  6  7  8
		System.out.println( tree.find(0, 8) );
		System.out.println( tree.find(0, 1) );
		System.out.println( tree.find(5, 7) );
		System.out.println( tree.find(2, 6) );
	}
}
class SegmentTree {
	int[] data = null;
	Node root = null;
	SegmentTree(int ... all) {
		data = new int[all.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = all[i];
		}
		root = build(root, 0, data.length - 1);
	}
	int find(int left, int right) {
		return find(root, left, right);
	}
	int find(Node e, int left, int right) {
		if (left > right) return 0;
		if (left == e.start && right == e.finish) {
			return e.value;
		}
		int mid = (e.start + e.finish) / 2;
		if (right   <= mid)  { return find(e.left,  left, right); }
		if (mid + 1 <= left) { return find(e.right, left, right); }
		int a = find(e.left, left, mid);
		int b = find(e.right, mid + 1, right);
		return a > b ? a : b;
	}
	Node build(Node e, int left, int right) {
		if (left > right) { return null; }

		e = new Node();
		if (left == right) {
			e.value = data[left];
			e.start = left;
			e.finish = right;
			return e;
		}
		e.start  = left;
		e.finish = right;
		int mid = (left + right) / 2;
		e.left  = build(e.left, left, mid);
		e.right = build(e.right, mid + 1, right);
		e.value = e.left.value;
		if (e.value < e.right.value) { e.value = e.right.value; }
		return e;
	}

	class Node {
		int value;
		int start;
		int finish;
		Node left;
		Node right;
	}
}