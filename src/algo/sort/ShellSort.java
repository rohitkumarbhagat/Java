package algo.sort;

import common.Utils;

/**
 * 
 * Shell Sort is insertion sort but with variable gap lengths. Elements compared
 * for equality are in gaps
 * 
 * @author rohitkumar
 * 
 */
public class ShellSort implements CanSort {

	private static int[] gaps = { 20, 10, 5, 3, 1 };

	private static void shellSort(int a[]) {
		int length = a.length;
		for (int g = 0; g < gaps.length; g++) {
			int gap = gaps[g];
			for (int i = gap; i < length; i++) {
				int k = i;
				int elem = a[k];
				int j = i;
				for (; j >= gap && a[j - gap] > elem; j -= gap) {
					a[j] = a[j - gap];
				}
				a[j] = elem;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 5, 1, -3, 56, 43 };
		shellSort(a);
		System.out.println(Utils.getArrayAsString(a, a.length));
	}

	@Override
	public void sort(int[] a) {
		shellSort(a);
	}

}
