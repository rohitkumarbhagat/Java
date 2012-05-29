package algo.dp;

import java.util.Arrays;

public class LargestUniqueString {
	private static int[]  present = new int[128];

	private static void clearPresent() {
		Arrays.fill(present, -1);
	}

	public static String getLargestUniqueString(String str) {
		String output = "";
		clearPresent();
		int lastStartPosition = 0;
		int maxStartPosition = 0;
		int maxEndPosition = 0;
		// store presence of a particular character in substring
		// start with 1 position 1
		int iterator = 1;
		present[str.charAt(0)] = 0;
		while (iterator < str.length()) {
			// if this character present in last longest substring
			int presentIndex = present[str.charAt(iterator)];
			if (presentIndex == -1 || presentIndex < lastStartPosition) {
				// not present
				present[str.charAt(iterator)] = iterator;

			} else {
				// present
				lastStartPosition = presentIndex + 1;
			}
			if (iterator - lastStartPosition > maxEndPosition
					- maxStartPosition) {
				maxEndPosition = iterator;
				maxStartPosition = lastStartPosition;
			}
			iterator++;
		}
		output = str.substring(maxStartPosition, maxEndPosition + 1);
		return output;

	}
	
	
	public static void main(String[] args) {
		System.out.println(getLargestUniqueString("abbcxrtdefgghju"));
	}
}
