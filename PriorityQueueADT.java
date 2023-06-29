package heaps114.priorityQueue;

/** Interface for the priority queue ADT */
public interface PriorityQueueADT<E> {

	/** Returns the number of items in the priority queue. */
	public int size();
	/** Returns whether the priority queue is empty. */
	public boolean isEmpty();
	/** Inserts a Record. */
	public void insert(E r);
	/** Removes and returns the entry with top priority key. */
	public E removeTop();
	/** Returns the entry with top priority key, priority queue does not change */
	public E TopValue();
}
