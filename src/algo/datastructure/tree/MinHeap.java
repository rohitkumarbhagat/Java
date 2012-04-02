package algo.datastructure.tree;

import java.lang.reflect.Array;

/**
 * @author rohitkumar
 * 
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>>
{

	private T[] dataArray;

	private int length;

	private int capacity;

	public MinHeap(Class<T> clazz, int capacity)
	{
		// dataArray = (T[]) new Object[capacity];
		// this.dataArray = new T[capacity];

		dataArray = (T[]) Array.newInstance(clazz, capacity);
		length = 0;
		this.capacity = capacity;

	}

	public boolean add(T data)
	{
		// if list full then no entry
		if (data == null || isFull())
		{
			return false;
		}
		// Add to end of the list
		dataArray[length++] = data;
		// heapify above
		heapify(length - 1);
		return true;

	}

	@Override
	public String toString()
	{
		StringBuilder heapStrBldr = new StringBuilder();

		for (int i = 0; i < length; i++)
		{
			heapStrBldr.append(dataArray[i].toString()).append("    ");
		}
		return heapStrBldr.toString();
	}

	public boolean isFull()
	{
		if (length >= capacity)
		{
			return true;
		}
		return false;
	}

	private boolean heapify(int index)
	{
		boolean result;
		// Ensure Heap property
		if (index > -1 && index < length)
		{

			result = true;
			// iterate upto root
			while (index > 0)
			{
				int parentIndex = getParent(index);

				if (dataArray[parentIndex].compareTo(dataArray[index]) == 1)
				{
					// if parent > child, swap child and parent and heapify
					// further
					T temp = dataArray[parentIndex];
					dataArray[parentIndex] = dataArray[index];
					dataArray[index] = temp;
					index = parentIndex;
				}
				else
				{
					// heap property maintained as parent > child
					break;
				}
			}

		}
		else
		{
			result = false;
		}
		return result;

	}

	private boolean percolate(int index)
	{
		boolean result;
		if (index > -1 && index < length)
		{
			int smallest = index;
			// get left and right child if exists

			if (getLeftChild(index) != -1 && dataArray[smallest].compareTo(dataArray[getLeftChild(index)]) == 1)
			{
				// if smallest is > left child
				smallest = getLeftChild(index);
			}
			if (getRightChild(index) != -1 && dataArray[smallest].compareTo(dataArray[getRightChild(index)]) == 1)
			{
				// if smallest is > right child
				smallest = getRightChild(index);
			}
			if (smallest != index)
			{
				// swap index and small
				T temp = dataArray[smallest];
				dataArray[smallest] = dataArray[index];
				dataArray[index] = temp;
				// recursivly percolate the swapped element
				percolate(smallest);
			}
			return true;

		}
		else
		{
			result = false;
		}
		return result;
	}

	/**
	 * @param childIndex
	 * @return index of Parent. If root then 0 , if oout of bound then -1
	 * 
	 */
	private int getParent(int childIndex)
	{
		if (childIndex < length && childIndex > -1)
		{
			if (childIndex == 0)
			{
				return 0;
			}
			return (childIndex - 1) / 2;
		}
		else
		{
			return -1;
		}
	}

	/**
	 * @param parentIndex
	 * @return -1 if left child does not exist or returns index of left child
	 */
	private int getLeftChild(int parentIndex)
	{
		if (parentIndex > -1 && parentIndex < length)
		{
			int leftChildIndex = 2 * parentIndex + 1;
			if (leftChildIndex < length)
			{
				return leftChildIndex;
			}
			else
			{
				return -1;
			}
		}
		{
			return -1;
		}
	}

	private int getLeftChild(int parentIndex, int length)
	{
		if (parentIndex > -1 && parentIndex < length)
		{
			int leftChildIndex = 2 * parentIndex + 1;
			if (leftChildIndex < length)
			{
				return leftChildIndex;
			}
			else
			{
				return -1;
			}
		}
		{
			return -1;
		}
	}

	private int getRightChild(int parentIndex)
	{
		if (parentIndex > -1 && parentIndex < length)
		{
			int rightChildindex = 2 * parentIndex + 2;
			if (rightChildindex < length)
			{
				return rightChildindex;
			}
			else
			{
				// Right child out of index

				return -1;
			}
		}
		else
		{
			// out of range parent
			return -1;
		}
	}

	private int getRightChild(int parentIndex, int length)
	{
		if (parentIndex > -1 && parentIndex < length)
		{
			int rightChildindex = 2 * parentIndex + 2;
			if (rightChildindex < length)
			{
				return rightChildindex;
			}
			else
			{
				// Right child out of index

				return -1;
			}
		}
		else
		{
			// out of range parent
			return -1;
		}
	}

	public void sort()
	{
		int tempLength = length;
		while (length > 1)
		{
			// swap first and last element
			T temp = dataArray[0];
			dataArray[0] = dataArray[length - 1];
			dataArray[length - 1] = temp;

			length--;
			percolate(0);
			System.out.println("----------------------------------");
			System.out.println(this);
		}
		length = tempLength;
	}
}
