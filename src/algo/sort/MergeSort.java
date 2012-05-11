package algo.sort;

public class MergeSort implements CanSort {
	/**
	 * returns sorted array c constructed by merging sorted arrays a and b
	 * 
	 * @param a
	 * @param b
	 */
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int a_scanner = 0, b_scanner = 0, c_scanner = 0;
		while (c_scanner < c.length) {
			if (a_scanner < a.length && b_scanner < b.length) {
				if (a[a_scanner] < b[b_scanner]) {
					c[c_scanner++] = a[a_scanner++];
				} else {
					c[c_scanner++] = b[b_scanner++];
				}
			} else {
				// copy b to c
				while (b_scanner < b.length) {
					c[c_scanner++] = b[b_scanner++];
				}
				while (a_scanner < a.length) {
					c[c_scanner++] = a[a_scanner++];
				}
			}
		}
		return c;
	}

	/**
	 * merge sorted parts of array a using array temp. Sorted parts range from
	 * beg to end with partition at mid
	 * 
	 * @param a
	 * @param temp
	 * @param beg
	 * @param end
	 * @param mid
	 */
	public static void inplaceMerge(int[] a, int[] temp, int beg, int end,
			int mid) {
		if (!(beg <= mid && mid < end) || a.length != temp.length) {
			return;
		}
		int f_scanner = beg;
		int l_scanner = mid + 1;
		int temp_scanner = beg;

		while (temp_scanner <= end) {
			if (f_scanner < mid + 1 && l_scanner < end + 1) {
				if (a[f_scanner] < a[l_scanner]) {
					temp[temp_scanner++] = a[f_scanner++];
				} else {
					temp[temp_scanner++] = a[l_scanner++];
				}
			} else {
				while (f_scanner < mid + 1) {
					temp[temp_scanner++] = a[f_scanner++];
				}
				while (l_scanner < end + 1) {
					temp[temp_scanner++] = a[l_scanner++];
				}
			}
		}
		// copy temp to a
		for (int i = beg; i <= end; i++) {
			a[i] = temp[i];
		}
	}

	/**
	 * sort array a
	 * 
	 * @param a
	 */
	public static void mergeSort(int[] a) {
		if (a.length > 0) {
			mergeSort(a, new int[a.length], 0, a.length - 1);
		}
	}

	/**
	 * sort part of array a between beg and end inclusive using temporary array
	 * temp
	 * 
	 * @param a
	 * @param temp
	 * @param beg
	 * @param end
	 */
	private static void mergeSort(int[] a, int[] temp, int beg, int end) {
		if (beg < end) {
			int mid = beg + (end - beg) / 2;
			mergeSort(a, temp, beg, mid);
			mergeSort(a, temp, mid + 1, end);
			inplaceMerge(a, temp, beg, end, mid);
		}
	}

	@Override
	public void sort(int[] a) {
		mergeSort(a);
	}

}
