/*

Fenwick Tree
- insert 
- create O(n log n)
- query  O(log n)
- change O(log n)

Segment Tree
- insert
- create O(n log n)
- query  O(log n)
- change O(log n)

Bruce Force:
- insert
- create O(n)
- query  O(n)
- change O(1)

Prefix Calculation:
- insert
- create O(n)
- query  O(1)
- change O(n)

*/

class Demo {
	public static void main(String[] commands) {
		FenwickTree tree = new FenwickTree(2, 3, 2, 4, 7, 5, 1, 2, 8);
										// 0  1  2  3  4  5  6  7  8
										// 2  5  7 11 18 23 24 26 34
		System.out.printf("%3d", tree.query(0));
		for (int i = 1; i < 9; i++) {
			System.out.printf("%3d", tree.query(i) - tree.query(i-1));
		}
		System.out.println();
	}
}
class FenwickTree {
	int[] element = null;
	FenwickTree(int ... all) {
		element = new int[all.length];
		for (int i = 0; i < all.length; i++) {
			add(i, all[i]);
		}
	}
	void add(int index, int value) {
		element[index] += value;
		int next = 1;
		while ((index | next) < element.length) {
			if ((index | next) == index + next) {
				index |= next;
				element[index] += value;
			}
			next *= 2;
		}
	}
	int query(int index) {
		int total = element[index];
		int next = 1;
		while (index - next >= 0) {
			if ((index | next) == index + next) {
				index -= next;
				total += element[index];
			}
			next *= 2;
		}
		return total;
	}
}