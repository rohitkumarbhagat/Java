package common;

public class Pair<K, V> {
	public K key;
	public V value;

	@Override
	public String toString() {
		return key + " : " + value;
	}
}
