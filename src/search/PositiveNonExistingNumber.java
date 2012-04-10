package search;

import java.util.Random;

import common.Utils;

public class PositiveNonExistingNumber {
	private static Random randomgenerator = new Random();

	public static void main(String[] args) {
		// int[] array = { 1,3, 6, 0, 9, 100, 23, 12, 65 };
		int[] array = { 4, 3, 21, 1, 0 };
		// System.out.println(findSortedPosition(array, 7, 0, 7));
		// System.out.println(modifiedFindSoirtedPos(array, 1, 0, 7));
		System.out.println(minimumMissing(array));
		System.out.println(Utils.getArrayAsString(array, array.length));
	}

	public static int minimumMissing(int[] array) {
		int result;
		if ((result = minimumMissing(array, 0, array.length - 1)) == -1) {
			result = array.length;
		}
		return result;
	}

	private static int minimumMissing(int[] array, int beg, int end) {
		if (array == null || beg > end || beg < 0 || end >= array.length) {
			return -1;
		}
		// random number between beg and end as pivotal number
		int pivotalIndex = beg + randomgenerator.nextInt(end - beg + 1);
		// find location of that element and divide them accordingly
		int indexFound = findSortedPosition(array, pivotalIndex, beg, end);
		//
		if (indexFound < array[indexFound]) {
			// some elements lesser than array[indexFound] are missing
			// look for them in left array
			int elementMissingleft = minimumMissing(array, beg, indexFound - 1);
			if (elementMissingleft == -1) {
				return indexFound;
			} else {
				return elementMissingleft;
			}
		}
		// missing in right half
		return minimumMissing(array, indexFound + 1, end);

	}

	private static int findSortedPosition(int[] array, int pivotIndex, int beg,
			int end) {
		if (!(beg <= pivotIndex && pivotIndex <= end)) {
			return -1;
		}
		// swap pivotal and last element of the array
		int first = beg;
		int last = end;
		int pivotElement = array[pivotIndex];
		// swap
		array[pivotIndex] = array[last];
		array[last] = pivotElement;
		last--;
		//
		while (first < last) {
			// scan for element greater than pivot
			while (pivotElement > array[first] && first < last) {
				first++;
			}
			while (pivotElement <= array[last] && last > first) {
				last--;
			}
			// swap them
			int temp = array[last];
			array[last] = array[first];
			array[first] = temp;
		}
		if (array[first] < pivotElement) {
			first = end;
		}
		array[end] = array[first];
		array[first] = pivotElement;

		return first;

	}

	private static int modifiedFindSoirtedPos(int[] array, int pivotal,
			int beg, int end) {
		if (!(beg <= pivotal && pivotal <= end)) {
			return -1;
		}

		// swap first and pivotal element
		int temp = array[pivotal];
		array[pivotal] = array[beg];
		array[beg] = temp;
		//

		int k = beg;
		for (int i = beg + 1; i <= end; i++) {
			if (array[i] < array[beg]) {
				k++;
				temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
		// swap
		temp = array[k];
		array[k] = array[beg];
		array[beg] = temp;

		return k;
	}
}
