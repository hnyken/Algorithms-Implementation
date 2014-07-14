public class BTree {
	private Node root;

	public BTree() {}
	
	public BTree(int[] A){
		root = new Node(A[0]);
		 for (int i = 1; i < A.length; i++) {
				Insert(A[i]);
			}
	}
	
	public BTree(int rootKey) {
		root = new Node(rootKey);
	}

	public void getInorderTreeWalk(Node A) {
		if (A != null) {
			getInorderTreeWalk(A.getLeft());
			System.out.print(A.getKey() + "\t");
			getInorderTreeWalk(A.getRight());
		}
	}

	public void getInorderTreeWalk() {
		Node A = root;
		if (A != null) {
			getInorderTreeWalk(A.getLeft());
			System.out.print(A.getKey() + "\t");
			getInorderTreeWalk(A.getRight());
		}
	}

	private int Search(Node node, int key) {
		if (node == null) {
			System.out.println("Element not found");
			return -999999;
		}
		if (node.getKey() == key)
			return node.getKey();
		if (node.getKey() > key) 
			return Search(node.getLeft(), key);
		else
			return Search(node.getRight(), key);
	}

	public int Search(int key) {
		Node node = root;
		if (node == null) {
			System.out.println("Element not found");
			return -999999;
		}
		if (node.getKey() == key)
			return node.getKey();
		if (node.getKey() > key) 
			return Search(node.getLeft(), key);
		 else 
			return Search(node.getRight(), key);
	}

	public int getMin() {
		Node node = root;
		while (node.getLeft() != null)
			node = root.getLeft();
		return node.getKey();
	}

	public int getMax() {
		Node node = root;
		while (node.getRight() != null)
			node = node.getRight();
		return node.getKey();
	}

	public void Insert(int key) {
		Node z = new Node(key);
		Node y = null;
		Node x = root;
		while (x != null) {
			y = x;
			if (z.getKey() < x.getKey())
				x = x.getLeft();
			else
				x = x.getRight();
		}
		if (y == null)
			root = z;
		else if (z.getKey() < y.getKey()) {
			y.left = z;
		} else {
			y.right = z;
		}
	}
}
