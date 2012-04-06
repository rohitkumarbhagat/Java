package algo.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MinWindowProblem {
	public static void main(String[] args) {
		int[] array = { 2, 4, 1, 7, 4, 9, 23, 12 };
		List<Integer> output = Arrays.asList(findMinInWindow(array, 0));
		System.out.println(output);
	}

	private static Integer[] findMinInWindow(int[] array, int k) {
		int length = array.length;
		// if emplty array or window greater than array size , return null
		if (k < 1 || k > length || length == 0) {
			return null;
		}
		// output
		Integer[] outputArray = new Integer[length - k + 1];
		Deque<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!queue.isEmpty() && array[queue.peekLast()] > array[i]) {
				queue.removeLast();
			}
			queue.addLast(i);
		}
		outputArray[0] = array[queue.peekFirst()];

		for (int i = k; i < length; i++) {
			while (!queue.isEmpty() && array[queue.peekLast()] > array[i]) {
				queue.removeLast();
			}
			queue.addLast(i);
			while (queue.peekFirst() < i - k + 1) {
				// remove element
				queue.removeFirst();
			}
			outputArray[i - k + 1] = array[queue.getFirst()];
		}

		return outputArray;

	}

}
