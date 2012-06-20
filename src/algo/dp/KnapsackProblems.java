package algo.dp;

public class KnapsackProblems {

	/**
	 * @param sizes
	 *            : sizes of different stuff
	 * @param weights
	 *            : weights of different stuff
	 * @param capacity
	 *            : capacity of container
	 * @return
	 */
	int unboundedKnapsack(int[] sizes, int[] weights, int capacity) {
		// stores optimal sizes of different capacity
		int[] optimalList = new int[capacity + 1];
		int[] parentArray = new int[capacity + 1];

		for (int i = 0; i <= capacity; i++) {
			optimalList[i] = 0;
			parentArray[i] = 0;
			for (int j = 0; j < sizes.length; j++) {
				if (i >= sizes[j]
						&& optimalList[i] < weights[j]
								+ optimalList[i - sizes[j]]) {
					optimalList[i] = weights[j] + optimalList[i - sizes[j]];
					parentArray[i] = sizes[j];
				}
			}
		}
		printSelectedSizes(parentArray, capacity);
		return optimalList[capacity];

	}

	void printSelectedSizes(int[] parentArray, int capacity) {
		while (capacity > 0 && parentArray[capacity] > 0) {
			System.out.print(parentArray[capacity]);
			capacity -= parentArray[capacity];
		}
		System.out.println();
	}

	int zeroOneKnapSack(int[] sizes, int[] weights, int capacity) {
		int[] lastRow = new int[capacity + 1];
		int[] currentRow = new int[capacity + 1];
		for (int i = 0; i < sizes.length; i++) {
			for (int tempCap = 0; tempCap <= capacity; tempCap++) {
				if (tempCap >= sizes[i]) {
					currentRow[tempCap] = Math.max(currentRow[tempCap
							- sizes[i]], lastRow[tempCap]);
					
				}

			}
			lastRow=currentRow;
		}
		return currentRow[capacity];

	}
}
