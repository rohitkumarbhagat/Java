package design;

interface LRUMapInterface<K, V> {

	public V get(K key);

	public void put(K key, V value);

	public V invalidate(K key);

}
