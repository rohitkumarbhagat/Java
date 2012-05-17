package algo.sort;

import common.Utils;

public class QuickSort implements CanSort {

	@Override
	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int beg, int end) {
		if (beg < end) {
			int pivotSortedIndex = findPivotSortedInx(a, beg, end,
					getPivot(a,beg, end));
			quickSort(a, beg, pivotSortedIndex - 1);
			quickSort(a, pivotSortedIndex + 1, end);

		}
	}

	protected int getPivot(int[] a,int beg, int end) {
		return Utils.generateRandomNumber(beg, end);
		//return beg;

	}

	protected int findPivotSortedInx(int[] a, int beg, int end, int pivot) {
		if (!(beg <= pivot && pivot <= end)) {
			return -1;
		}
		int pivotIndex = beg;
		int scanner = beg;
		Utils.swap(a, pivot, beg);
		while (scanner <= end) {
			if (a[scanner] <= a[beg]) {
				Utils.swap(a, pivotIndex++, scanner);
			}
			scanner++;
		}
		Utils.swap(a, pivotIndex-1, beg);
		return pivotIndex - 1;

	}

	public int median(int[] a, int beg, int end) {
		if (beg == end) {
			// as median is always between beg and end
			return a[beg];
		}
		if (beg > end) {
			return -1;
		}
		int medianIndex = a.length / 2;
		int pivotSortedIndex = findPivotSortedInx(a, beg, end,
				getPivot(a,beg, end));
		if (pivotSortedIndex == medianIndex) {
			return a[medianIndex];
		}
		if (pivotSortedIndex > medianIndex) {
			return median(a, beg, pivotSortedIndex - 1);
		} else {
			return median(a, pivotSortedIndex + 1, end);
		}

	}
	
	
	
	
	
}
