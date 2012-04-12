package algo.search;

import java.util.Deque;
import java.util.LinkedList;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

//	You are in a room with a circle of 100 chairs.  The chairs are numbered sequentially from 1 to 100.
//	At some point in time, the person in chair #1 will be asked to leave.  The person in chair #2 will be skipped,
//  and the person in chair #3 will be asked to leave. This pattern of skipping one person and asking the next to 
//  leave will keep
//	going around the circle until there is one person left… the survivor.

public class LastRemainingCircular {
	public static void main(String[] args) {
		System.out.println(findRemainingMan());
		System.out.println(findRemainingMan_new());

		// int NoOfChair = 100;
		// int i = 0;
		// while ((2 << i) * 2 < NoOfChair)
		// i++;
		// System.out.println("Element will be " + (2 << i));
	}

	private static int findRemainingMan() {
		Deque<Integer> crclrQueue = new LinkedList<Integer>();
		for (int i = 1; i <= 300; i++) {
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

	private static int findRemainingMan_new() {
		int n = 100;
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
}
