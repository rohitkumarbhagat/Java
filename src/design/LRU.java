package design;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> implements LRUMapInterface<K, V> {
	// holds key and value
	private Map<K, LRU_EntryInterface<K, V>> map;
	// holds head of dequeue
	private LRU_EntryInterface<K, V> head;
	// holds tail 0f dequeue
	private LRU_EntryInterface<K, V> tail;
	private final int capacity;

	public LRU(int capacity) {
		this.capacity = capacity;
		map = new HashMap<K, LRU_EntryInterface<K, V>>(capacity);
		head = null;
		tail = null;

	}

	private class LRU_Entry<K, V> implements LRU_EntryInterface<K, V> {
		K key;
		V value;
		LRU_EntryInterface<K, V> prev;
		LRU_EntryInterface<K, V> next;

		public LRU_Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public V getValue() {

			return value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public LRU_EntryInterface<K, V> getPrev() {
			return prev;
		}

		@Override
		public LRU_EntryInterface<K, V> getNext() {
			return next;
		}

		@Override
		public void setValue(V value) {
			// TODO Auto-generated method stub
			this.value = value;
		}

		@Override
		public void setPrev(LRU_EntryInterface<K, V> prev) {
			this.prev = prev;
		}

		@Override
		public void setNext(LRU_EntryInterface<K, V> next) {
			this.next = next;
		}

	}

	@Override
	public void put(K key, V value) {
		LRU_EntryInterface<K, V> entry = map.get(key);
		if (entry != null) {
			// entry exists.. update it just
			entry.setValue(value);
			refresh(entry);
		} else {
			// remove if size exceeds
			if (map.size() == capacity) {
				// remove from map
				map.remove(head.getKey());
				// remove from link list
				remove(head);
			}
			// add a fresh entry
			entry = new LRU_Entry<>(key, value);
			map.put(key, entry);
			insert(entry);
		}
	}

	@Override
	public V invalidate(K key) {
		LRU_EntryInterface<K, V> entry = map.get(key);
		if (entry != null) {
			// entry exists
			remove(entry);
			map.remove(key);
			return entry.getValue();
		}
		return null;
	}

	@Override
	public V get(K key) {
		LRU_EntryInterface<K, V> entry = map.get(key);
		if (entry != null) {
			refresh(entry);
			return entry.getValue();
		}
		return null;
	}

	private void refresh(LRU_EntryInterface<K, V> entry) {
		if (entry != tail) {
			if (entry == head) {
				head = entry.getNext();
				head.setPrev(null);
			} else {
				entry.getPrev().setNext(entry.getNext());
				entry.getNext().setPrev(entry.getPrev());
			}
			// add entry to end of the tail
			if (entry != tail) {
				tail.setNext(entry);
				entry.setPrev(tail);
				entry.setNext(null);
				tail = entry;
			}

		}

	}

	private void insert(LRU_EntryInterface<K, V> entry) {
		// if list is empty
		if (head == null) {
			head = tail = entry;
			entry.setNext(null);
			entry.setPrev(null);
		} else {
			// add entry to end of the tail
			tail.setNext(entry);
			entry.setPrev(tail);
			entry.setNext(null);
			tail = entry;
		}

	}

	private void remove(LRU_EntryInterface<K, V> entry) {
		if (entry != head && entry != tail) {
			// entry is middle element
			entry.getPrev().setNext(entry.getNext());
			entry.getNext().setPrev(entry.getPrev());
		}
		if (entry == head) {
			head = entry.getNext();
			if (head != null) {
				head.setPrev(null);
			}
		}
		if (entry == tail) {
			tail = tail.getPrev();
			if (tail != null) {
				tail.setNext(null);
			}
		}
	}

	public static void main(String[] args) {
		LRU<String, String> cache = new LRU<>(5);
		cache.put("a", "av");
		cache.get("a");
		cache.invalidate("a");
		cache.put("c", "cv");
		System.out.println(cache.get("a"));
		cache.put("d", "dv");
		cache.put("c", "dv2");
		cache.put("e", "ev");
		cache.get("c");
		cache.get("d");
		cache.invalidate("c");
		cache.invalidate("d");
		cache.put("f", "fv");
		cache.put("g", "gv");
		cache.put("a", "av2");
	}
}
