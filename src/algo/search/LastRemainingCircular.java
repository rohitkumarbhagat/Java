package algo.search;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Observable;

//	You are in a room with a circle of 100 chairs.  The chairs are numbered sequentially from 1 to 100.
//	At some point in time, the person in chair #1 will be asked to leave.  The person in chair #2 will be skipped,
//  and the person in chair #3 will be asked to leave. This pattern of skipping one person and asking the next to 
//  leave will keep
//	going around the circle until there is one person left… the survivor.

public class LastRemainingCircular {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(findRemainingMan(n));
		System.out.println(findRemainingMan_new(n));
		System.out.println(find(n));
		System.out.println(find_best(n));

		// int NoOfChair = 100;
		// int i = 0;
		// while ((2 << i) * 2 < NoOfChair)
		// i++;
		// System.out.println("Element will be " + (2 << i));
	}

	private static int findRemainingMan(int n) {
		Deque<Integer> crclrQueue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			crclrQueue.add(i);
		}
		boolean remove = true;
		Integer lastRemoved = null;
		while (!crclrQueue.isEmpty()) {
			Integer top = crclrQueue.remove();
			if (remove) {
				lastRemoved = top;
				// System.out.println(lastRemoved);
			} else {
				crclrQueue.addLast(top);
			}
			remove = !remove;
		}

		return lastRemoved;
	}

	private static int findRemainingMan_new(int n) {

		// Sum of all Elements
		int sum = (n * (n + 1)) / 2;
		// counter of number of elements removed
		int count = 0;
		// smallest unremoved element in the set after each iteration
		int lastRemainingElement = 2;
		// numbers to jump after each iteration
		int jumpInterval = 1;
		// maintain removal of alternate element
		boolean remove = true;
		// current visited element
		int current = 1;

		// we are done when n-1 elements are removed
		while (count < n - 1) {
			if (remove) {
				// remove element from the sum
				sum -= current;
				count++;
			}
			current = current + jumpInterval;
			remove = !remove;
			// adjust settings when we have reached last element
			if (current > n) {
				current = lastRemainingElement;
				jumpInterval = jumpInterval * 2;
				// last element will change only when it has to be removed
				if (remove) {
					// if current element has to be removed then next will be
					// remaining
					lastRemainingElement = lastRemainingElement + jumpInterval;
				}

			}

		}
		return lastRemainingElement;
	}

	public static int find(int n) {

		if (n == 1)
			return 1;

		boolean isEven = (n % 2 == 0);

		if (isEven)
			return 2 * find(n / 2);
		else {
			int next = n / 2;
			boolean isPowerOfTwo = (next != 0 && (next & (next - 1)) == 0);
			int a = (isPowerOfTwo ? 0 : 2);

			return a * find(next) + 2;
		}

	}

	public static int find_best(int n) {

		// initialize some variables
		int startElem = 1; // first element in iteration
		int lastElem = n; // last remaining element in each iteration
		int jumpLength = 1; // numbers to consider
		int removalStatus = -1;// -1 indicates remove , 1 indicates save
		while (startElem != lastElem) {
			// each loop indicates one cycle through last element
			int noOfStepsToLast = (lastElem - startElem) / jumpLength;
			// check wheteher last elem will be removed, if yes then update it
			if (removalStatus == -1) {
				startElem = startElem + jumpLength;
			}
			if ((removalStatus * (Math.pow(-1, noOfStepsToLast))) == -1) {
				// remove last element
				lastElem = lastElem - jumpLength;
				removalStatus = 1;
				// first element would be saved
			} else {
				removalStatus = -1;
				// protect last element and remove first element

			}
			jumpLength = 2 * jumpLength;
			// if start elem will be removed update it

			// update the jump length

			// update the removal status of the start element

		}
		return startElem;

	}
}
