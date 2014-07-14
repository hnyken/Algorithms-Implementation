public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int key){
			data = key;
			left = null;
			right = null;
		}
		
		public int getKey(){
			return data;
		}
		
		public Node getLeft(){
			return left;
		}
		
		public Node getRight(){
			return right;
		}
}
