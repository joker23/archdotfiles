public class PrefixTree {
	private class Trie {
		Node root;

		public Trie(){
			root = new Node();
		}

		public void addString(String str){
			Node curr = root;
			char[] arr = str.toCharArray();
			for(char c : arr){
				if(!curr.next.containsKey(c)){
					curr.next.put(c, new Node());
				} curr = curr.next.get(c);
			} curr.leaf = true;
		}

		public void clear(){
			root = new Node();
		}

		public boolean verifyWord(String word){
			Node n = root;
			char[] arr = word.toCharArray();
			for(char c: arr){
				if(!n.next.containsKey(c)){
					return false;
				}
				n = n.next.get(c);
			}
			return n.leaf;
		}

		public void inOrder(){
			inOrder(root, "");
		}

		public void inOrder(Node n, String curr){
			for (Character c : n.next.keySet()) {
				inOrder(n.next.get(c), curr + c);
			}
			if(n.leaf){
				System.out.println(curr);
			}
		}

		private class Node{
			TreeMap<Character, Node> next;
			boolean leaf;

			public Node(){
				next = new TreeMap<Character, Node>();
				leaf = false;
			}
		}
	}
}

