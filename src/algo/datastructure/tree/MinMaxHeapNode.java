/**
 * 
 */
package algo.datastructure.tree;

/**
 * @author erotkur
 * 
 */
public class MinMaxHeapNode<T extends Comparable<T>>
{
	public T dataItem;

	public int minHeapIndex;

	public int maxHeapIndex;

	/**
	 * 
	 */
	public MinMaxHeapNode(T dataItem, int minHeapIndex, int maxHeapIndex)
	{
		this.dataItem = dataItem;
		this.minHeapIndex = minHeapIndex;
		this.maxHeapIndex = maxHeapIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append(dataItem + " , " + minHeapIndex + " , " + maxHeapIndex);

		return result.toString();

	}
}
