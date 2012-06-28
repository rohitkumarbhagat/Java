package algo.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSeq {

	List<Integer> longestIncreasingSubsequence(int[] numbers) {
		List<Integer> longestSeq = new ArrayList<Integer>(numbers.length);
		int[] optimalList = new int[numbers.length];
		int[] parentList = new int[numbers.length];
		// index of number where longest subsequence ends
		int maxIndex = 0;

		for (int i = 0; i < numbers.length; i++) {
			optimalList[i] = 1;
			parentList[i] = i;
			for (int j = i - 1; j > -1; j--) {
				if (numbers[j] <= numbers[i]
						&& (optimalList[i] < optimalList[j] + 1)) {
					optimalList[i] = optimalList[j] + 1;
					parentList[i] = j;
				}
			}
			if (optimalList[maxIndex] < optimalList[i]) {
				maxIndex = i;
			}
		}

		int tmpIndex = maxIndex;

		while (true) {
			System.out.print(numbers[tmpIndex] + "  ");
			longestSeq.add(numbers[tmpIndex]);
			if (parentList[tmpIndex] == tmpIndex) {
				break;
			}
			tmpIndex = parentList[tmpIndex];
		}
System.out.println();
		return longestSeq;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubSeq longestIncreasingSubSeq = new LongestIncreasingSubSeq();
		longestIncreasingSubSeq.longestIncreasingSubsequence(new int[]{1});
		longestIncreasingSubSeq.longestIncreasingSubsequence(new int[]{1,5,2,7,1,4,9,56});
		longestIncreasingSubSeq.longestIncreasingSubsequence(new int[]{90,5,1,2,7,4,9,56});
		longestIncreasingSubSeq.longestIncreasingSubsequence(new int[]{90,5,1,2,7,4,9,3,56,6});
		longestIncreasingSubSeq.longestIncreasingSubsequence(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
	}

}
