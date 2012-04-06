/**
 * 
 */
package algo.datastructure.tree;

import java.lang.reflect.Array;

/**
 * @author erotkur
 * 
 */
/**
 * @author erotkur
 * 
 * @param <T>
 */
public class MinMaxHeap<T extends Comparable<T>> {
	// heap no : 1
	MinMaxHeapNode<T>[] minHeapArray;

	// Heap no: 2
	MinMaxHeapNode<T>[] maxHeapArray;

	int length;

	int capacity;

	/**
	 * 
	 */
	public MinMaxHeap(Class<T> claz, int capacity) {
		this.capacity = capacity;
		length = 0;
		minHeapArray = (MinMaxHeapNode<T>[]) Array.newInstance(
				MinMaxHeapNode.class, capacity);
		maxHeapArray = (MinMaxHeapNode<T>[]) Array.newInstance(
				MinMaxHeapNode.class, capacity);
	}

	public boolean add(T data) {
		if (!isFull()) {
			MinMaxHeapNode<T> newNode = new MinMaxHeapNode<T>(data, length,
					length);
			minHeapArray[length] = newNode;
			maxHeapArray[length] = newNode;
			length++;
			// Heapify both the heaps

			heapify(1, length - 1, length);
			heapify(2, length - 1, length);
			return true;
		} else {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Min heap = ");
		for (int i = 0; i < length; i++) {
			result.append(minHeapArray[i]).append("  # ");
		}
		result.append("\nMax heap =");
		for (int i = 0; i < length; i++) {
			result.append(maxHeapArray[i]).append("  # ");
		}
		return result.toString();
	}

	private boolean isFull() {
		if (length >= capacity) {

			return true;
		}
		return false;
	}

	//
	private boolean heapify(int heapNo, int index, int length) {
		boolean result = true;
		if (length <= this.length && length > -1 && index > -1
				&& index < length) {
			// Range correct
			MinMaxHeapNode<T>[] currentheap = heapNo == 1 ? minHeapArray
					: maxHeapArray;
			while (index > 0) {
				int parentIndex = getParent(index, length);
				if (compare(heapNo, currentheap[index],
						currentheap[parentIndex]) == -1) {
					// wrong order , swap entries
					swap(heapNo, index, parentIndex);
					index = parentIndex;
				} else {
					// order is maintained
					break;
				}
			}

		} else {
			result = false;
			// either length or index is beyond range

		}
		return result;
	}

	private void swap(int heapNo, int index1, int index2) {

		MinMaxHeapNode<T>[] currentheap = heapNo == 1 ? minHeapArray
				: maxHeapArray;
		// swap items
		MinMaxHeapNode<T> temp = currentheap[index1];
		currentheap[index1] = currentheap[index2];
		currentheap[index2] = temp;
		// swap indexes
		if (heapNo == 1) {
			// update minheapIndex
			currentheap[index1].minHeapIndex = index1;
			currentheap[index2].minHeapIndex = index2;

		} else {
			// update max heap Index
			currentheap[index1].maxHeapIndex = index1;
			currentheap[index2].maxHeapIndex = index2;
		}

	}

	private int compare(int heapNo, MinMaxHeapNode<T> node1,
			MinMaxHeapNode<T> node2) {
		int result = 0;
		if (heapNo == 1) {
			// min heap

			result = node1.dataItem.compareTo(node2.dataItem);
		} else {
			// max heap
			result = node2.dataItem.compareTo(node1.dataItem);

		}
		return result;

	}

	private int getParent(int childIndex, int length) {
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

	private boolean percolate(int heapNo, int index, int length) {
		boolean result;
		if (index > -1 && index < length) {
			int smallest = index;
			// get left and right child if exists
			MinMaxHeapNode<T>[] currentHeap = heapNo == 1 ? minHeapArray
					: maxHeapArray;
			if (getLeftChild(index, length) != -1
					&& compare(heapNo, currentHeap[smallest],
							currentHeap[getLeftChild(index, length)]) == 1) {
				// if smallest is > left child
				smallest = getLeftChild(index, length);
			}
			if (getRightChild(index, length) != -1
					&& compare(heapNo, currentHeap[smallest],
							currentHeap[getRightChild(index, length)]) == 1) {
				// if smallest is > right child
				smallest = getRightChild(index, length);
			}
			if (smallest != index) {
				// swap index and small
				swap(heapNo, smallest, index);
				percolate(heapNo, smallest, length);

				// T temp = dataArray[smallest];
				// dataArray[smallest] = dataArray[index];
				// dataArray[index] = temp;
				// recursivly percolate the swapped element
			}
			return true;

		} else {
			result = false;
		}
		return result;
	}

	public MinMaxHeapNode<T> deleteMin() {
		if (length <= 0) {
			return null;
		}
		MinMaxHeapNode<T> deletedNode = deleteIndex(1, 0, length);
		deletedNode = deleteIndex(2, deletedNode.maxHeapIndex, length);
		length--;
		return deletedNode;
	}

	public MinMaxHeapNode<T> deleteMax() {
		if (length <= 0) {
			return null;
		}
		MinMaxHeapNode<T> deletedNode = deleteIndex(2, 0, length);
		deletedNode = deleteIndex(1, deletedNode.minHeapIndex, length);
		length--;
		return deletedNode;
	}

	private MinMaxHeapNode<T> deleteIndex(int heapNo, int index, int length) {
		MinMaxHeapNode<T> deletedNode = null;
		if (index > -1 && index < length) {
			// index within range
			MinMaxHeapNode<T>[] currentHeap = heapNo == 1 ? minHeapArray
					: maxHeapArray;
			deletedNode = currentHeap[index];
			swap(heapNo, index, length - 1);
			currentHeap[length - 1] = null;
			// swap with last element
			// deletedNode = dataArray[index];
			// dataArray[index] = dataArray[length - 1];
			// // make sure reference is freed for garbage collection
			// dataArray[length - 1] = null;
			// length--;
			// element can go up or down

			heapify(heapNo, index, length - 1);
			percolate(heapNo, index, length - 1);

		}
		return deletedNode;

	}

}
