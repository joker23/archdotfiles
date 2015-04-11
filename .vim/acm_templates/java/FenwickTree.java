public class FenwickTree {

	private static class Tree {
		int[] t;

		public Tree(int[] arr) {
			t = new int[arr.length];
			for (int i=0; i<arr.length; i++) {
				t[i] += arr[i];
				int j = i | (i + 1);
				if ( j < arr.length) {
					t[j] += t[i];
				}
			}
		}

		public long sum(int i) {
			long res = 0;

			for (;i >= 0; i = (i & (i + 1)) - 1) {
				res += t[i];
			}

			return res;
		}

		public long sum(int i, int j) {
			return sum(j) - sum(i-1);
		}

		public int get(int i) {
			int res = t[i];
			if (i > 0) {
				int lca = (i & (i + 1)) - 1;
				for (--i; i != lca; i = (i & (i + 1)) - 1) {
					res -= t[i];
				}
			}
			return res;
		}

		public void set(int i, int val) {
			add(i, -get(i) + val);
		}

		private void add(int i, int val) {
			for (; i < t.length; i |= i + 1) {
				t[i] += val;
			}
		}
	}


	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};

		Tree ftree = new Tree(arr);

		System.out.println(ftree.sum(4));
		System.out.println(ftree.get(3));

		ftree.set(2, 12);
		System.out.println(ftree.sum(4));
		System.out.println(ftree.get(2));
	}
}
