
public class BinaryTreeBasis {
	private class WordNode {
		// Data members
		private String item;
		private WordNode left, right;
		private int count;

		// Constructors
		public WordNode(String item) {
			this.item = item;
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
			return this.left;
		}

		public void setLeft(WordNode left) {
			this.left = left;
		}

		public WordNode getRight() {
			return this.right;
		}

		public void setRight(WordNode right) {
			this.right = right;
		}

	}

	private WordNode root;

	// ****** Binary Tree Methods ******

	// Add Methods
	public void add(String item) {
		root = addWord(item, root);
	}

	private WordNode addWord(String item, WordNode rootNode) {
		// If the tree is empty
		if (rootNode == null)
			return new WordNode(item);

		// Check if the rootNode's String is > the item
		if (rootNode.item.compareTo(item) == 1) {
			rootNode.setLeft(addWord(item, rootNode.getLeft()));
		}

		// Check if the rootNode's String is < the item
		if (rootNode.item.compareTo(item) == -1) {
			rootNode.setRight(addWord(item, rootNode.getRight()));
		}

		// Check if the rootNode's String is == the item
		if (rootNode.item.compareTo(item) == 0) {
			rootNode.count++;
		}
		
		return rootNode;
	}

	// Count Methods
	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(WordNode rootNode) {
		if (rootNode != null) {
			return 1 + countNodes(rootNode.getLeft()) + countNodes(rootNode.getRight());
		}
		return 0;
	}

	// Count 4 Letter Word Methods
	public int countFourLetters() {
		return countFourLetters(root);
	}

	private int countFourLetters(WordNode rootNode) {
		if (rootNode != null) {
			if (rootNode.item.length() == 4)
				return 1 + countNodes(rootNode.getLeft()) + countNodes(rootNode.getRight());
			else
				return 0 + countNodes(rootNode.getLeft()) + countNodes(rootNode.getRight());
		}
		return 0;
	}

	// Print Tree Methods
	public void printTree() {
		printTree(root);
	}

	private void printTree(WordNode rootNode) {
		if (rootNode != null) {
			System.out.print(rootNode.getItem() + " ");
			printTree(rootNode.getLeft());
			printTree(rootNode.getRight());
		}
	}

}
