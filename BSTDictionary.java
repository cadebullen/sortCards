package BST114.Dictionary;


/** This class represent a binary search tree, it is both a BTEnumerator and a Dictionary */ 
public class BSTDictionary implements DictionaryADT<Integer>, BTEnumerator {

	BSTNode root;
	int nodeCount;
	
	public BSTDictionary() {
		root = null;
		nodeCount = 0;
	}

	
	///////////////////////////////////
	// Binary tree enumeration methods
	///////////////////////////////////
	@Override
	public void printPreOrder() {
		preOrderRecursive(root);
		System.out.println();
	}

	@Override
	public void printPostOrder() {
		postOrderRecursive(root);
		System.out.println();
	}

	@Override
	public void printInOrder() {
		inOrderRecursive(root);
		System.out.println();
	}

	private void preOrderRecursive(BSTNode rt) {
		if (rt != null) {
			System.out.print(rt.getValue() + " ");
			preOrderRecursive(rt.getLeftChild());
			preOrderRecursive(rt.getRightChild());			
		}

	}

	private void postOrderRecursive(BSTNode rt) {
		if (rt != null) {
			postOrderRecursive(rt.getLeftChild());
			postOrderRecursive(rt.getRightChild());
			System.out.print(rt.getValue() + " ");
		}
	}

	private void inOrderRecursive(BSTNode rt) {
		if (rt != null) {
			inOrderRecursive(rt.getLeftChild());
			System.out.print(rt.getValue() + " ");
			inOrderRecursive(rt.getRightChild());
		}

	}

	//////////////////////
	// Dictionary methods
	//////////////////////
	@Override
	public void clear() {
		root = null;
	}

	@Override
	public int size() {
		return nodeCount;
	}
	
	@Override
	public void insert(Integer record) {
		root = insertRecursive(record, root);
	}

	@Override
	public Integer remove(Integer k) {
		Integer val = find(k); // find it
		if (val != null) {
			root = removeRecursive(k, root); // remove it
			nodeCount--;
		}
		return val;
	}

	@Override
	public Integer find(Integer k) {
		Integer temp;
		BSTNode rec = findRecursive(k, root);
		try {
			temp = rec.getValue();
		}
		catch (NullPointerException n) {
			temp = null;
		}
		return temp;
	}

	private BSTNode insertRecursive(Integer r, BSTNode rt) {
		//Tree is empty
		if (rt == null) {
			++nodeCount;
			return new BSTNode(r);
		}
		// if value is smaller, insert in the left subtree
		if (r < rt.getValue()) {
			rt.setLeftChild(insertRecursive(r, rt.getLeftChild()));
		}
		// if value is bigger, insert in the right subtree
		else {
			rt.setRightChild(insertRecursive(r, rt.getRightChild()));
		}
		return rt;

	}

	private BSTNode removeRecursive(Integer k, BSTNode rt) {
		if (rt == null)
			return null;
		if (rt.getValue() > k)
			rt.setLeftChild(removeRecursive(k, rt.getLeftChild()));
		else if (rt.getValue() < k)
			rt.setRightChild(removeRecursive(k, rt.getRightChild()));
		else { // Found it, remove it
			// if at most on child - return child
			if (rt.getLeftChild() == null)
				return rt.getRightChild();
			else if (rt.getRightChild() == null)
				return rt.getLeftChild();
			else { // Two children
				BSTNode temp = getMin(rt.getRightChild());
				rt.setValue(temp.getValue());
				rt.setRightChild(removeRecursive(temp.getValue(), rt.getRightChild()));
			}
		}
		return rt;
	}

	private BSTNode findRecursive(Integer k, BSTNode rt) {
		//BSTNode res = null;
		if (rt == null) return null;
		if (k < rt.getValue()){
			return findRecursive(k, rt.getLeftChild());
		}
		else if (k > rt.getValue()){
			return findRecursive(k, rt.getRightChild());
		}else {
			return rt;
		}
	}

	private BSTNode getMin(BSTNode rt) {
		// This is the smallest value
		if (rt.getLeftChild() == null) {
			return rt;
		}
		else {
			return getMin(rt.getLeftChild());
		}
	}
}
