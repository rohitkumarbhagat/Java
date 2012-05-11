package algo.sort;

import common.Utils;

public class RandomizedQuickSort extends QuickSort {

	private final int BLOCK_SIZE = 5;

	/*
	 * modifies array a
	 * 
	 * @see algo.sort.QuickSort#getPivot(int[], int, int)
	 */
	@Override
	protected int getPivot(int[] a, int beg, int end) {
		if (beg == end) {
			return beg;
		}
		int pivotIndex = beg;
		if (beg <= end) {
			int[] medianArray = new int[(a.length / BLOCK_SIZE) + 1];
			int index = 0;
			// find median of each block size and create an array
			int begBlock = beg;
			for (; begBlock + BLOCK_SIZE <= end; begBlock += BLOCK_SIZE + 1) {
				medianArray[index++] = getMedian(a, begBlock, begBlock
						+ BLOCK_SIZE);
			}
			// find median of residue
			if (begBlock <=end) {
				medianArray[index++] = getMedian(a, begBlock, end);
			}

			// find median of medians

			pivotIndex = getIndex(a, beg,end,getMedian(medianArray, 0, index - 1));

		}
		return pivotIndex;
	}

	private int getIndex(int[] a, int beg, int end, int n) {
		for (int i = beg; i <= end; i++) {
			if (a[i] == n) {
				return i;
			}
		}
		return -1;
	}

	private int getMedian(int[] a, int beg, int end) {
		if ((end - beg + 1) > (BLOCK_SIZE + 1)) {
			return median(a, beg, end);
		}
		for (int i = beg; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (a[i] > a[j]) {
					Utils.swap(a, i, j);
				}
			}
		}
		return a[beg + ((end - beg + 1) / 2)];
	}

}
