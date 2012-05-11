package algo.sort;

import common.Utils;

public class InsertionSort implements CanSort {

	private static void insertionSort(int[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			int elem = array[i];
			int j;
			for (j = i - 1; j >= 0 && array[j] > elem; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = elem;
		}
	}

	/**
	 * Each iteration find the minimum one and replace with the starting index
	 * 
	 * @param array
	 */
	private static void selectionSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			Utils.swap(array, min, i);
		}

	}

	public static void main(String[] args) {
		int[] array = { 1, 21, 3, -20, 5 };
		insertionSort(array);
		// selectionSort(array);
		System.out.println(Utils.getArrayAsString(array, array.length));
	}

	@Override
	public void sort(int[] a) {
		insertionSort(a);

	}

}
