package BST114.Dictionary;

/** Binary Search Tree node  */
public class BSTNode{
	
	private Integer rec; 
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(Integer r) {
		rec = r;
	}

	public void setValue(Integer  r) {
		rec = r;
	}

	public Integer getValue() {
		return rec;
	}

	public void setLeftChild(BSTNode n) {
		left = n;
	}

	public BSTNode getLeftChild() {
		return left;
	}

	public void setRightChild(BSTNode n) {
		right = n;
	}

	public BSTNode getRightChild() {
		return right;
	}

	public boolean isLeaf() {
		if (left == null && right == null)
			return true;
		else
			return false;
	}

}
