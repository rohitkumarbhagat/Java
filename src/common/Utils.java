package common;

public class Utils {

	public static String getArrayAsString(int[] array,int k) {
		String result = "";
		if (array == null) {
			return "null";
		}
		for (int i = 0; i < k; i++) {
			result += array[i] + "  ";
		}
		return result;
	}

}
