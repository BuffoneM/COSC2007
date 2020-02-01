
public class BinaryTreeBasis {
	private class WordNode {
		// Data members
		private String item;
		private WordNode left, right;
		private int count;

		// Constructors
		public WordNode() {
			item = "";
			left = null;
			right = null;
			count = 0;
		}
		public WordNode(String item) {
			this.item = item;
			left = null;
			right = null;
			count = 1;
		}
		public WordNode(String item, WordNode left, WordNode right) {
			this.item = item;
			this.left = left;
			this.right = right;
			count = 1;
		}
		
		// Getters and Setters
		public String getItem() { 
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		
		public WordNode getLeft() {
			return left;
		}
		public void setLeft(WordNode left) {
			this.left = left;
		}
		
		public WordNode getRight() {
			return right;
		}
		public void setRight(WordNode right) {
			this.right = right;
		}
	
	}
	private WordNode root;
	
	// ****** Binary Tree Constructors and Methods ******
	// Constructors
	public BinaryTreeBasis() {
		root = null;
	}
	public BinaryTreeBasis(String rootItem) {
		root = new WordNode(rootItem, null, null);
	}
	
	// Methods
	public boolean isEmpty() {
		return root == null;
	}
	public void setEmpty() {
		root = null;
	}
	
	public String getRootItem() throws TreeException {
		if(isEmpty()) throw new TreeException("Cannot get item because root == null");
		else return root.getItem();
	}
	public WordNode getRoot() {
		return root;
	}

}

