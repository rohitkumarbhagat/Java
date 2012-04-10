package algo.datastructure.tree;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * @author rohitkumar
 * 
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> {

	private T[] dataArray;

	private int length;

	private int capacity;
	private Class<T> claz;

	public MinHeap(Class<T> clazz, int capacity) {
		// dataArray = (T[]) new Object[capacity];
		// this.dataArray = new T[capacity];
		this.claz = clazz;
		dataArray = (T[]) Array.newInstance(clazz, capacity);
		length = 0;
		this.capacity = capacity;

	}

	public boolean add(T data) {
		// if list full then no entry
		if (data == null || isFull()) {
			return false;
		}
		// Add to end of the list
		dataArray[length++] = data;
		// heapify above
		heapify(length - 1);
		return true;

	}

	@Override
	public String toString() {
		StringBuilder heapStrBldr = new StringBuilder();

		for (int i = 0; i < length; i++) {
			heapStrBldr.append(dataArray[i].toString()).append("    ");
		}
		return heapStrBldr.toString();
	}

	public boolean isFull() {
		// if (length >= capacity) {
		// return true;
		// }
		// return false;
		return length >= capacity;
	}

	private boolean heapify(int index) {
		boolean result;
		// Ensure Heap property
		if (index > -1 && index < length) {

			result = true;
			// iterate upto root
			while (index > 0) {
				int parentIndex = getParent(index);

				if (dataArray[parentIndex].compareTo(dataArray[index]) == 1) {
					// if parent > child, swap child and parent and heapify
					// further
					T temp = dataArray[parentIndex];
					dataArray[parentIndex] = dataArray[index];
					dataArray[index] = temp;
					index = parentIndex;
				} else {
					// heap property maintained as parent > child
					break;
				}
			}

		} else {
			result = false;
		}
		return result;

	}

	private boolean percolate(int index) {
		boolean result;
		if (index > -1 && index < length) {
			int smallest = index;
			// get left and right child if exists

			if (getLeftChild(index) != -1
					&& dataArray[smallest]
							.compareTo(dataArray[getLeftChild(index)]) == 1) {
				// if smallest is > left child
				smallest = getLeftChild(index);
			}
			if (getRightChild(index) != -1
					&& dataArray[smallest]
							.compareTo(dataArray[getRightChild(index)]) == 1) {
				// if smallest is > right child
				smallest = getRightChild(index);
			}
			if (smallest != index) {
				// swap index and small
				T temp = dataArray[smallest];
				dataArray[smallest] = dataArray[index];
				dataArray[index] = temp;
				// recursivly percolate the swapped element
				percolate(smallest);
			}
			return true;

		} else {
			result = false;
		}
		return result;
	}

	/**
	 * @param childIndex
	 * @return index of Parent. If root then 0 , if oout of bound then -1
	 * 
	 */
	private int getParent(int childIndex) {
		if (childIndex < length && childIndex > -1) {
			if (childIndex == 0) {
				return 0;
			}
			return (childIndex - 1) / 2;
		} else {
			return -1;
		}
	}

	/**
	 * @param parentIndex
	 * @return -1 if left child does not exist or returns index of left child
	 */
	private int getLeftChild(int parentIndex) {
		if (parentIndex > -1 && parentIndex < length) {
			int leftChildIndex = 2 * parentIndex + 1;
			if (leftChildIndex < length) {
				return leftChildIndex;
			} else {
				return -1;
			}
		}
		{
			return -1;
		}
	}

	private int getLeftChild(int parentIndex, int length) {
		if (parentIndex > -1 && parentIndex < length) {
			int leftChildIndex = 2 * parentIndex + 1;
			if (leftChildIndex < length) {
				return leftChildIndex;
			} else {
				return -1;
			}
		}
		{
			return -1;
		}
	}

	private int getRightChild(int parentIndex) {
		if (parentIndex > -1 && parentIndex < length) {
			int rightChildindex = 2 * parentIndex + 2;
			if (rightChildindex < length) {
				return rightChildindex;
			} else {
				// Right child out of index

				return -1;
			}
		} else {
			// out of range parent
			return -1;
		}
	}

	private int getRightChild(int parentIndex, int length) {
		if (parentIndex > -1 && parentIndex < length) {
			int rightChildindex = 2 * parentIndex + 2;
			if (rightChildindex < length) {
				return rightChildindex;
			} else {
				// Right child out of index

				return -1;
			}
		} else {
			// out of range parent
			return -1;
		}
	}

	public void sort() {
		int tempLength = length;
		while (length > 1) {
			// swap first and last element
			T temp = dataArray[0];
			dataArray[0] = dataArray[length - 1];
			dataArray[length - 1] = temp;

			length--;
			percolate(0);
			// System.out.println("----------------------------------");
			// System.out.println(this);
		}
		length = tempLength;
	}

	public T deleteElement(T element) {
		return deleteIndex(indexOf(element));

	}

	public T deleteIndex(int index) {
		T deletedNode = null;
		if (index > -1 && index < length) {
			// index within range

			// swap with last element
			deletedNode = dataArray[index];
			dataArray[index] = dataArray[length - 1];
			// make sure reference is freed for garbage collection
			dataArray[length - 1] = null;
			length--;
			// element can go up or down
			heapify(index);
			percolate(index);

		}
		return deletedNode;

	}

	public int length() {
		return length;
	}

	private int indexOf(T element) {
		for (int i = 0; i < length; i++) {
			if (dataArray[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public T getMin() {
		if (length > 0) {
			return dataArray[0];

		}
		return null;
	}

	public T getKthLargest(int k) {
		T kthLargestElement = null;
		// check for boundary cases
		if (k > 0 && k <= length) {
			int count = 0;
			// stores index of minimum elements and not elements themselves
			MinHeap<T> tempHeap = new MinHeap<T>(this.claz, k + 1);
			tempHeap.add(this.getMin());
			HashMap<T, Integer> map = new HashMap<T, Integer>();
			map.put(this.getMin(), 0);
			while (true) {
				kthLargestElement = tempHeap.getMin();
				tempHeap.deleteIndex(0);
				if (++count == k) {
					return kthLargestElement;
				}
				int leftIndex = getLeftChild(map.get(kthLargestElement));
				int rightIndex = getRightChild(map.get(kthLargestElement));
				T left = leftIndex == -1 ? null : dataArray[leftIndex];
				T right = rightIndex == -1 ? null : dataArray[rightIndex];
				if (left != null) {
					tempHeap.add(left);
					map.put(left, leftIndex);
				}
				if (right != null) {
					tempHeap.add(right);
					map.put(right, rightIndex);

				}

			}

		}
		return kthLargestElement;
	}

}
