package common;

public class Utils
{

	public static String getArrayAsString(int[] array, int k)
	{
		String result = "";
		if (array == null)
		{
			return "null";
		}
		for (int i = 0; i < k; i++)
		{
			result += array[i] + "  ";
		}
		return result;
	}

	public static String getArrayAsString(int[][] array, int row, int colmn)
	{
		String result = "";
		if (array == null)
		{
			return "null";
		}
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < colmn; j++)
			{
				result = result + array[i][j] + "  ";
			}
			result += "\n";
		}
		return result;
	}

}
