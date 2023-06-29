package BST114.Dictionary;

/** The Dictionary abstract class. we may assume all keys are unique */
public interface DictionaryADT<E> {
	
	/** Reinitialize dictionary */
	public void clear();
	
	/** Insert a record by key value. If key exists 
	@param r The record being inserted. */
	public void insert(E r);
	
	/** Remove and return a record.
	@param k The key of the record to be removed.
	@return The record removed, null if no such record with key "k" exists. */
	public E remove(Integer k);
	
	/** @return A record matching "k" (null if none exists).
	@param k The key of the record to find */
	public E find(Integer k);
	
	/** @return The number of records in the dictionary. */
	public int size();
}
