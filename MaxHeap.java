package heaps114.priorityQueue;

import java.util.ArrayList;

/** Top element in the heap has maximum key */
public class MaxHeap implements PriorityQueueADT<Integer>, BTEnumerator {

	private int count; // Number of elements in heap. 
	private ArrayList<Integer> heapArray; // Array to store data 
	
	public MaxHeap() {
		heapArray = new ArrayList<Integer>();
		count = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MaxHeap(ArrayList<Integer> arr) {
		heapArray = (ArrayList<Integer>) arr.clone();
		count = heapArray.size();
		// Arrange input array into a heap 
		buildheap();
	}

	//////////////////////////////////////////
	////// HW5 - look at buildheap ///////////
	//////////////////////////////////////////
	/** Heapify contents of Heap */
	private void buildheap() {
		// Start at least element and sift down into correct position
		for (int i = count - 1; i >= 0; --i) {
			heapifyDown(i);
		}
	}
	
	///////////////////////////////////
	// Priority queue implementation
	//////////////////////////////////	
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public void insert(Integer r) {
		int newRec = count; // place new record at the end
		heapArray.add(newRec, r);
		count++;
		// heapify up: move the new record up the heap until parent’s key > new record key
		while ((newRec != 0) && (heapArray.get(newRec) > heapArray.get(parent(newRec)))){
			swap(newRec, parent(newRec));
			newRec = parent(newRec);
		}	
	}
	
	@Override
	public Integer removeTop() {
		// heap is empty
		if (count == 0) {
			return null;
		}
		// subtract 1 from element count and swap maximum with last leaf
		swap(0, --count);
		heapifyDown(0); // sift the new root down, till it is not less then parent
		
		return heapArray.get(count);
	}
	
	@Override
	public Integer TopValue() {
		Integer top = null;
		if (!isEmpty()) {
			top = heapArray.get(0);
		}
		return top;
	}

	//////////////////////////
	// Private helper methods
	//////////////////////////	
	
	/** Put element in its correct place */
	private void heapifyDown(int pos) {
		// if legal position
		if ((pos >= 0) && (pos < count)) {
				int max = maxOfThree(pos);
				// one of the children is bigger then root
				if (max != pos) {
					swap(max,pos);
					// now the record of pos is in index max
					heapifyDown(max);
			}
		}
	}
	
	/** @return Position for left child of pos, if no left child, null is returned*/
	private Integer leftChild(int pos) {
		int left = 2 * pos + 1;
		return (left < count) ? left : null ;
	}
	
	/** @return Position for left child of pos, if no left child, null is returned*/
	private Integer rightChild(int pos) {
		int right = 2 * pos + 2;
		return (right < count) ? right : null ;
	}
	
	/** @return Position for parent, if this is the root, null is returned */
	private Integer parent(int pos) {
		return (pos == 0) ? null : (pos - 1) / 2;
	}
	 
	 /** @param p - node in the heap
	 * @return index of maximal among p, p's left child, p's right child */
	private int maxOfThree(int p) {
		int max = p;
		// if p is not a leaf, check children (one or two)
		if (!isLeaf(p)) {
			Integer left = leftChild(p);
			Integer right = rightChild(p);
			
			max = left;
			// return maximal child node
			if ((right != null) &&
				(heapArray.get(left) < heapArray.get(right))){
					max = right;
			}
			// compare with parent
			max = (heapArray.get(max) < heapArray.get(p))? p : max;
		}
		return max;
	}
	
	/** @return True if pos a leaf position, false otherwise */
	public boolean isLeaf(int pos) { 
		// return true only if index of left child are larger then last index.
		return (pos < count) && (pos*2 + 1 > count - 1); 
	}
 	
	// Swap the records in indices i and j
	private void swap(int i, int j) {
		Integer temp = heapArray.get(j);
		heapArray.set(j, heapArray.get(i));
		heapArray.set(i, temp);
	}
	
	
	///////////////////////////////////////
	//////////Print heap content //////////
	///////////////////////////////////////

	@Override
	public void printPreOrder() {
		preOrderRecursive(0);
		System.out.println();
		
	}

	@Override
	public void printPostOrder() {
		postOrderRecursive(0);
		System.out.println();
		
	}

	@Override
	public void printInOrder() {
		inOrderRecursive(0);
		System.out.println();
		
	}

	
	// Preorder: root - left - right 
	private void preOrderRecursive(int rt) {
		if ((rt >= 0) && (rt < count)) {
			System.out.print(heapArray.get(rt) + " ");
			if (leftChild(rt) != null)
				preOrderRecursive(leftChild(rt));
			if (rightChild(rt) != null)
				preOrderRecursive(rightChild(rt));
		}
	}

	// Postorder: left - right - root
	private void postOrderRecursive(int rt) {
		if ((rt >= 0) && (rt < count)) {
			if (leftChild(rt) != null)
				postOrderRecursive(leftChild(rt));
			if (rightChild(rt) != null)
				postOrderRecursive(rightChild(rt));
			System.out.print(heapArray.get(rt) + " ");
		}
	}
	
	// Inorder: left - root - right 
	private void inOrderRecursive(int rt) {
		if ((rt >= 0) && (rt < count)) {
			if (leftChild(rt) != null)
				inOrderRecursive(leftChild(rt));
			System.out.print(heapArray.get(rt) + " ");
			if (rightChild(rt) != null)
				inOrderRecursive(rightChild(rt));
		}
	}
	
}


