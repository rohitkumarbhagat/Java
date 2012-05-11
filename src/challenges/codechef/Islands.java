package challenges.codechef;

import java.util.Arrays;

public class Islands {
	int[] indexDifference = { -1, 1 };
	int[][] a;
	int[][] temp;
	int[][] stack;
	int n;
	int m;

	public Islands(int[][] a, int n, int m) {
		init(a, n, m);
	}

	private void init(int[][] a, int n, int m) {
		this.a = a;
		this.n = n;
		this.m = m;
		temp = new int[n][m];
		stack = new int[n * m][2];
	}

	public int[] dfs() {
		int[] result = new int[2];
		Arrays.fill(result, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0 && a[i][j]==1) {
					result[0]++;
					int size = sizeOfIsland(i, j);
					if (size > result[1]) {
						result[1] = size;
					}
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * Returns size of island which contains point x,y
	 * 
	 * @param a
	 * @param n
	 * @param m
	 * @param x
	 * @param y
	 * @param temp
	 *            temporary array representing visited points
	 * @return
	 */
	private int sizeOfIsland(int x, int y) {
		int size = 0;
		if (isValidCordinate(x, y)) {
			temp[x][y] = 1;
			int stackIndexLast = 0;
			stack[stackIndexLast][0] = x;
			stack[stackIndexLast][1] = y;
			while (stackIndexLast >= 0) {
				size++;
				int current_x = stack[stackIndexLast][0];
				int current_y = stack[stackIndexLast][1];
				stackIndexLast--;
				for (int[] nbr : getNbrs(current_x, current_y)) {
					int nbr_x = nbr[0];
					int nbr_y = nbr[1];
					if (isValidCordinate(nbr_x, nbr_y)
							&& temp[nbr_x][nbr_y] == 0 && a[nbr_x][nbr_y] == 1) {
						stackIndexLast++;
						stack[stackIndexLast][0] = nbr_x;
						stack[stackIndexLast][1] = nbr_y;
						temp[nbr_x][nbr_y]=1;

					}
				}
			}

		}
		return size;
	}

	private int[][] getNbrs(int x, int y) {
		return new int[][] { { x - 1, y }, { x + 1, y }, { x, y - 1 },
				{ x, y + 1 } };
	}

	private boolean isValidCordinate(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < m) {
			return true;
		}
		return false;
	}
}
