  class Demo {
	public static void main(String[] commands) {
		FenwickTree tree = new FenwickTree(2, 3, 2, 4, 7, 5, 1, 2, 8);
										// 0  1  2  3  4  5  6  7  8
										// 2  5  7 11 18 23 24 26 34
		for (int i = 0; i < 9; i++) {
			System.out.printf("%3d", tree.sum(i));
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
			if ((index | next) != index) {
				index += next;
				element[index] += value;
			}
			next *= 2;
		}
	}
	int sum(int index) {
		int t = element[index];
		int next = 1;
		while (index - next > 0) {
			if ((index | next) != index) {
				index -= next;
				t += element[index];
			}
			next *= 2;
		}
		return t;
	}
}