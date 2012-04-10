package algo.datastructure.tree;

public class MedianHeap {

	private int capacity;
	// stores right side of numbers
	private MinHeap<Integer> minHeap;
	// store and retrieve data from max heap in negative form
	private MinHeap<Integer> maxHeap;

	public MedianHeap(int capacity) {
		this.capacity = capacity;
		minHeap = new MinHeap<Integer>(Integer.class, capacity / 2);
		maxHeap = new MinHeap<Integer>(Integer.class, capacity
				- (int) (capacity / 2));
	}

	public boolean isFull() {
		return minHeap.isFull() && maxHeap.isFull();
	}

	public int length() {
		return minHeap.length() + maxHeap.length();
	}

	public boolean add(int n) {
		if (!isFull()) {
			if (length() == 0) {
				// add first element to min heap
				minHeap.add(n);
			} else if (n < minHeap.getMin()) {
				if (maxHeap.length() == minHeap.length()) {
					// Insert in max heap as max heap is short in length
					minHeap.add(-1 * maxHeap.deleteIndex(0));
				}
				maxHeap.add(-1 * n);

			} else {
				// Insert in minheap if equal length
				if (maxHeap.length() < minHeap.length()) {

					maxHeap.add(minHeap.deleteIndex(0) * -1);
				}
				minHeap.add(n);
			}

			return true;
		}
		return false;
	}

	public Float getMedian() {
		if (length() == 0) {
			return null;
		}
		float minHeapTop = minHeap.getMin() == null ? 0 : minHeap.getMin();
		float maxHeapTop = maxHeap.getMin() == null ? 0 : maxHeap.getMin() * -1;
		if (length() % 2 == 0) {
			// if even
			return (float) ((minHeapTop + maxHeapTop) / 2);
		} else {
			return (float) minHeapTop;
		}

	}

	@Override
	public String toString() {
		StringBuilder strBldr = new StringBuilder();
		strBldr.append("Max Heap = ").append(maxHeap.toString())
				.append(" \nMin Heap =  ").append(minHeap.toString());
		return strBldr.toString();

	}
}
