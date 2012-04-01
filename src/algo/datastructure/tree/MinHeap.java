package algo.datastructure.tree;

import sun.security.krb5.internal.PAEncTSEnc;

/**
 * @author rohitkumar
 * 
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> {

	private T[] dataArray;
	private int length;
	private int capacity;

	public MinHeap(int capacity) {
		dataArray = (T[]) new Object[capacity];
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

	public boolean isFull() {
		if (length >= capacity) {
			return true;
		}
		return false;
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
	
	private 

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
}
