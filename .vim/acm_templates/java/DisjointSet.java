public class DisjointSet {

	private class DSet{
		int[] set;

		public DSet(int i){
			set = new int[i+1];
			for(int j=0;j<set.length;j++){
				set[j] = j;
			}
		}

		public int find(int x){
			if(set[x] == x){
				return x;
			} set[x] = find(set[x]);
			return set[x];
		}

		public void join(int x, int y){
			set[find(x)] = find(y);
		}

		public boolean isConnected(int x, int y){
			return find(x) == find(y);
		}
	}
}
