package challenges.spoj;


/**
 * @author rohitkumar 
 * 			Used Segment Tree with lazy propagation
 * 
 *         There are N numbers a[0],a[1]..a[N - 1]. Initially all are 0. You
 *         have to perform two types of operations :
 * 
 *         1) Increase the numbers between indices A and B (inclusive) by 1.
 *         This is represented by the command "0 A B" 2) Answer how many numbers
 *         between indices A and B (inclusive) are divisible by 3. This is
 *         represented by the command "1 A B".
 * 
 *         Input : The first line contains two integers, N and Q. Each of the
 *         next Q lines are either of the form "0 A B" or "1 A B" as mentioned
 *         above.
 * 
 *         Output : Output 1 line for each of the queries of the form "1 A B"
 *         containing the required answer for the corresponding query.
 * 
 *         Sample Input : 4 7 1 0 3 0 1 2 0 1 3 1 0 0 0 0 3 1 3 3 1 0 3
 * 
 *         Sample Output : 4 1 0 2
 * 
 *         Constraints : 1 <= N <= 100000 1 <= Q <= 100000 0 <= A <= B <= N - 1
 * 
 * 
 * 
 */
public class MultiplesOf3 {

	private final int MAX_VALUE = 1000000;
	private int[][] tree = new int[MAX_VALUE][2];
	// stores number of updates required for each interval
	private int[] update = new int[MAX_VALUE];
	// original array storing incremented values
	private int[] a = new int[MAX_VALUE];
	private boolean enableLazyPropagation = true;

	/**
	 * Updates range [i , j] with increased values. without lazy propagation
	 * 
	 * @param nodeNo
	 * @param beg
	 * @param end
	 * @param i
	 * @param j
	 */

	private void update(int nodeNo, int beg, int end, int i, int j) {
		if (beg > j || end < i) {
			// return if dont overlap
			return;
		}
		// when lazy propagation is off dont need to use update status
		if (enableLazyPropagation) {
			if (beg >= i && end <= j) {
				update[nodeNo]++;
				return;
			}
			if (update[nodeNo] > 0) {
				update[2 * nodeNo] += update[nodeNo];
				update[2 * nodeNo + 1] += update[nodeNo];
				update[nodeNo] = 0;

			}
		} else {
			if (beg == end) {
				// reached the leaf, increment its value
				a[beg]++;
				tree[nodeNo][0] = a[beg] % 3 == 0 ? 1 : 0;
				tree[nodeNo][1] = a[beg] % 3 == 1 ? 1 : 0;
				return;
			}
		}
		// update children
		int halfOfDiff = (end - beg) / 2;
		update(2 * nodeNo, beg, beg + halfOfDiff, i, j);
		update(2 * nodeNo + 1, beg + halfOfDiff + 1, end, i, j);
		refresh(nodeNo, beg, end);

	}

	private void refresh(int parentNodeNo, int beg, int end) {
		int halfOfDiff = (end - beg) / 2;
		int[] remainderList1 = getUpdatedValues(parentNodeNo * 2, beg, beg
				+ halfOfDiff);
		int[] remainderList2 = getUpdatedValues(parentNodeNo * 2 + 1, beg
				+ halfOfDiff + 1, end);

		tree[parentNodeNo][0] = remainderList1[0] + remainderList2[0];
		tree[parentNodeNo][1] = remainderList1[1] + remainderList2[1];

	}

	private int[] getUpdatedValues(int nodeNo, int beg, int end) {
		int[] remainderList = new int[3];
		if (update[nodeNo] > 0) {
			int normalizedUpdateCount = update[nodeNo] % 3;
			int divisible = tree[nodeNo][0];
			int remainderOne = tree[nodeNo][1];
			int remaindertwo = end - beg + 1 - divisible - remainderOne;
			remainderList[normalizedUpdateCount++] = divisible;
			remainderList[normalizedUpdateCount % 3] = remainderOne;
			remainderList[(normalizedUpdateCount + 1) % 3] = remaindertwo;

		} else {
			remainderList[0] = tree[nodeNo][0];
			remainderList[1] = tree[nodeNo][1];
			remainderList[2] = end - beg + 1
					- (remainderList[0] + remainderList[1]);
		}

		return remainderList;
	}

	/**
	 * returns count of numbers divisible by three in this range [i , j] without
	 * late propagation
	 * 
	 * @param nodeNo
	 * @param beg
	 * @param end
	 * @param i
	 * @param j
	 * @return
	 */
	private int query(int nodeNo, int beg, int end, int i, int j) {
		if (beg > j || end < i) {
			// non overlapping intervals
			return 0;
		}
		if (beg >= i && end <= j) {
			// if interval [beg, end] under inspection is subset of [i,j]
			if (enableLazyPropagation) {
				return getUpdatedValues(nodeNo, beg, end)[0];
			} else {
				return tree[nodeNo][0];
			}
		}
		if (update[nodeNo] > 0) {
			update[2 * nodeNo] += update[nodeNo];
			update[2 * nodeNo + 1] += update[nodeNo];
			update[nodeNo] = 0;
		}
		// update children
		int halfOfDiff = (end - beg) / 2;
		refresh(nodeNo, beg, end);
		return (query(2 * nodeNo, beg, beg + halfOfDiff, i, j) + query(
				2 * nodeNo + 1, beg + halfOfDiff + 1, end, i, j));
	}

	public MultiplesOf3() {
		// for (int i = 0; i < MAX_VALUE; i++) {
		init(1, 0, 4);
		// }
	}

	private void init(int node, int beg, int end) {
		if (beg == end) {
			tree[node][0] = 1;
			tree[node][1] = 0;
			return;
		}
		init(node * 2, beg, beg + (end - beg) / 2);
		init(node * 2 + 1, beg + 1 + (end - beg) / 2, end);
		tree[node][0] = tree[node * 2][0] + tree[node * 2 + 1][0];
		tree[node][1] = tree[node * 2][1] + tree[node * 2 + 1][1];

	}

	public static void main(String[] args) {
		MultiplesOf3 withoutLatePropo = new MultiplesOf3();
//		Arrays.fill(withoutLatePropo.a, -1);
//		withoutLatePropo.update(1, 0, 4, 0, 4);
		System.out.println(withoutLatePropo.query(1, 0, 4, 0, 3));
		withoutLatePropo.update(1, 0, 4, 1, 2);
		withoutLatePropo.update(1, 0, 4, 1, 3);
		System.out.println(withoutLatePropo.query(1, 0, 4, 0, 0));
		withoutLatePropo.update(1, 0, 4, 0, 3);
		System.out.println(withoutLatePropo.query(1, 0, 4, 3, 3));
		System.out.println(withoutLatePropo.query(1, 0, 4, 0, 3));

	}

}
