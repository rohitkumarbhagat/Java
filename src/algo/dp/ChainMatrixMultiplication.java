package algo.dp;


public class ChainMatrixMultiplication {

	/**
	 * @param p
	 *            : list of matrix sizes where sizeof(matrix[i])= p[i]*p[i+1]
	 * @param n
	 *            : number of matrix. size of p should be n+1
	 * @return minimum multiplication required
	 */
	private static int minimumMultiplicationOperation(int[] p) {
		int n = p.length - 1;

		// optimalCompMatrix[i][j] represents minimum operation to multiply
		// matrix from m[i] to m[j]
		int[][] optimalCompMatrix = new int[n][n];

		int[][] parentCompMatrix = new int[n][n];
		// initialize it with p data.
		for (int i = 0; i < n - 1; i++) {
			optimalCompMatrix[i][i] = 0;
			optimalCompMatrix[i][i + 1] = p[i] * p[i + 1] * p[i + 2];
		}
		optimalCompMatrix[n - 1][n - 1] = 0;

		// update optimalCompMatrix with formula

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 2; j < n; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int tmp = optimalCompMatrix[i][k]
							+ optimalCompMatrix[k + 1][j] + p[i] * p[k + 1]
							* p[j + 1];
					if (tmp < min) {
						min = tmp;
						parentCompMatrix[i][j] = k;

					}
					optimalCompMatrix[i][j] = min;
				}
			}
		}
		printOptimalMulOrder(parentCompMatrix, 0, n - 1);
		System.out.println("");
		return optimalCompMatrix[0][n - 1];

	}

	private static void printOptimalMulOrder(int[][] parentmatrix, int beg,
			int end) {
		if (beg > end) {
			return;
		}
		if (beg == end) {
			System.out.print(beg);
			return;
		}
		if (end == beg + 1) {
			System.out.print("(" + beg + "*" + end + ")");
			return;
		}

		System.out.print("(");
		printOptimalMulOrder(parentmatrix, beg, parentmatrix[beg][end]);
		System.out.print("*");

		printOptimalMulOrder(parentmatrix, parentmatrix[beg][end] + 1, end);
		System.out.print(")");

	}

	public static void main(String[] args) {
		int[] p = { 2, 4, 7, 7, 6, 5, 2 };
		System.out.println(minimumMultiplicationOperation(p));
		int[] p1 = { 10, 30, 5, 60 };
		System.out.println(minimumMultiplicationOperation(p1));
		int[] p3 = { 40, 20, 30, 10, 30 };
		System.out.println(minimumMultiplicationOperation(p3));
		int[] p2 = { 10, 20, 30, 40, 30 };
		System.out.println(minimumMultiplicationOperation(p2));
	}

}
