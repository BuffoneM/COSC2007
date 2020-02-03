/*
public class BinaryTree extends BinaryTreeBasis {

	// ****** Constructors and methods ******
	public BinaryTree() {
		super("");
	}

	public BinaryTree(String rootItem) {
		super(rootItem);
	}

	protected BinaryTree(WordNode rootNode) {
		root = rootNode;
	}

	public BinaryTree(String rootItem, BinaryTree leftTree, BinaryTree rightTree) {
		root = new WordNode(rootItem, null, null);
		try {
			attachLeftSubtree(leftTree);
			attachRightSubtree(rightTree);
		} catch (TreeException e) {
			System.out.println(e.getMessage());
		}
	}

	// ****** Methods ******
	public void setRootItem(String newItem) {
		if (root == null) {
			root = new WordNode(newItem, null, null);
		} else {
			root.setItem(newItem);
		}
	}

	// *** Attach / detach ***
	public void attachLeft(String newItem) {
		if (!isEmpty() && root.getLeft() == null) {
			root.setLeft(new WordNode(newItem, null, null));
		}
	}

	public void attachRight(String newItem) {
		if (!isEmpty() && root.getRight() == null) {
			root.setRight(new WordNode(newItem, null, null));
		}
	}

	public void attachLeftSubtree(BinaryTree leftTree) throws TreeException {
		if (isEmpty())
			throw new TreeException("Cannot attach left subtree to empty tree...");
		else if (root.getLeft() != null)
			throw new TreeException("Cannot overwrite left subtree...");
		else {
			root.setLeft(leftTree.root);
			leftTree.setEmpty();
		}
	}

	public void attachRightSubtree(BinaryTree rightTree) throws TreeException {
		if (isEmpty())
			throw new TreeException("Cannot attach right subtree to empty tree...");
		else if (root.getRight() != null)
			throw new TreeException("Cannot overwrite right subtree...");
		else {
			root.setRight(rightTree.root);
			rightTree.setEmpty();
		}
	}

	public BinaryTree detachLeftSubtree() throws TreeException {
		if (isEmpty())
			throw new TreeException("Cannot detach empty tree...");
		else {
			BinaryTree leftTree = new BinaryTree(root.getLeft());
			root.setLeft(null);
			return leftTree;
		}
	}

	public BinaryTree detachRightSubtree() throws TreeException {
		if (isEmpty())
			throw new TreeException("Cannot detach empty tree...");
		else {
			BinaryTree rightTree = new BinaryTree(root.getRight());
			root.setRight(null);
			return rightTree;
		}
	}

	// *** Utility ***
	public void add(String newWord) {
		//if(!nodeExists())
	}

	public int countNodes(WordNode rootNode) throws TreeException {

		return 0;
	}
}
*/