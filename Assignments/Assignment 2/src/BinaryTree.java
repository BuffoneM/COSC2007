/*
 * Assignment 2
 * Michael Buffone
 * February 1st, 2020
 * 
 * This class will create a binary tree and implement
 * the appropriate methods and wordNode
 */

public class BinaryTree {
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
		
		public void setCount(int count) {
			this.count = count;
		}
		
		public int getCount() {
			return count;
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
		if (rootNode == null) {
			//System.out.println("RootNode is " + item);
			return new WordNode(item);
		}

		// Check if the rootNode's String is < the item
		if (rootNode.item.compareTo(item) >= 1) {
			//System.out.println("Adding " + item + " to the left");
			rootNode.setLeft(addWord(item, rootNode.getLeft()));
		}

		// Check if the rootNode's String is > the item
		if (rootNode.item.compareTo(item) <= -1) {
			//System.out.println("Adding " + item + " to the right");
			rootNode.setRight(addWord(item, rootNode.getRight()));
		}

		// Check if the rootNode's String is == the item
		if (rootNode.item.compareTo(item) == 0) {
			//System.out.println("Incrementing counter for " + item);
			rootNode.setCount(rootNode.getCount() + 1);
		}
		
		return rootNode;
	}
 
	// Count Methods
	// Pre order traversal
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
	// Post order traversal
	public int countFourLetters() {
		return countFourLetters(root);
	}

	private int countFourLetters(WordNode rootNode) {
		if (rootNode != null) {
			if (rootNode.item.length() == 4)
				return countFourLetters(rootNode.getLeft()) + countFourLetters(rootNode.getRight()) + 1;
			else
				return countFourLetters(rootNode.getLeft()) + countFourLetters(rootNode.getRight());
		}
		return 0;
	}

	// *** Print Tree Methods ***
	// In order traversal
	public void printInTree() {
		printInTree(root);
	}

	private void printInTree(WordNode rootNode) {
		if (rootNode != null) {
			printInTree(rootNode.getLeft());
			System.out.printf("%-20s: %d\n", rootNode.getItem(), rootNode.getCount());
			printInTree(rootNode.getRight());
		}
	}
	
	// Pre order traversal
	public void printPreTree() {
		printPreTree(root);
	}
	
	private void printPreTree(WordNode rootNode) {
		if(rootNode != null) {
			System.out.printf("%-20s: %d\n", rootNode.getItem(), rootNode.getCount());
			printPreTree(rootNode.getLeft());
			printPreTree(rootNode.getRight());
		}
	}
	
	// Post order traversal
	public void printPostTree() {
		printPostTree(root);
	}
	
	private void printPostTree(WordNode rootNode) {
		if(rootNode != null) {
			printPostTree(rootNode.getLeft());
			printPostTree(rootNode.getRight());
			System.out.printf("%-20s: %d\n", rootNode.getItem(), rootNode.getCount());
		}
	}
}
