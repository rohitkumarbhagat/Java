package algo.string;

/**
 * @author rohitkumar
 * 
 */
public class MatrixStringSearch {

	public boolean isPresent(char[][] matrix, String str, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (isPresent(matrix, str, 0, i, j, new boolean[row][col], row,
						col) == true) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param matrix
	 * @param str
	 * @param matchedStrIndex
	 *            : position to be matched
	 * @param tmpMatrix
	 *            : element covered
	 * @return
	 */
	private boolean isPresent(char[][] matrix, String str, int matchedStrIndex,
			int x_index, int y_index, boolean[][] tmpMatrix, int row, int col) {
		if (x_index >= 0 && x_index < row && y_index >= 0 && y_index < col
				&& tmpMatrix[x_index][y_index] == false) {
			if (matchedStrIndex == str.length()) {
				return true;
			}
			char currentChar = str.charAt(matchedStrIndex);

			if (currentChar == matrix[x_index][y_index]) {
				// mark index as visited
				tmpMatrix[x_index][y_index] = true;
				// search for next chararcter in neighbours
				// return
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (isPresent(matrix, str, matchedStrIndex + 1, x_index
								+ i, y_index + j, tmpMatrix, row, col) == true) {
							return true;
						}
					}
				}

			}
			tmpMatrix[x_index][y_index] = false;
		}
		return false;
	}
}
