package design;

interface LRU_EntryInterface<K, V> {

	public V getValue();

	public void setValue(V value);

	public K getKey();

	public LRU_EntryInterface<K, V> getPrev();

	public void setPrev(LRU_EntryInterface<K, V> prev);

	public LRU_EntryInterface<K, V> getNext();

	public void setNext(LRU_EntryInterface<K, V> next);

}
