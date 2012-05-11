package common;

import java.util.Random;

public class Utils {

	public static String getArrayAsString(int[] array, int k) {
		String result = "";
		if (array == null) {
			return "null";
		}
		for (int i = 0; i < k; i++) {
			result += array[i] + "  ";
		}
		return result;
	}

	public static String getArrayAsString(int[][] array, int row, int colmn) {
		String result = "";
		if (array == null) {
			return "null";
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colmn; j++) {
				result = result + array[i][j] + "  ";
			}
			result += "\n";
		}
		return result;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static Random randomGenerator;

	public static int generateRandomNumber(int a, int b) {
		if (randomGenerator == null) {
			randomGenerator = new Random();
		}
		return (a + randomGenerator.nextInt(b - a + 1));
	}

}
