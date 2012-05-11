package challenges.codechef;

import org.junit.Assert;
import org.junit.Test;

public class Test_islands {

	@Test
	public void testDfs() {
		int[][] a = { { 1, 1, 0, 0, 1 }, { 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 0 },
				{ 1, 1, 0, 0, 0 } };
		Islands islands = new Islands(a, 4, 5);
		int[] result = islands.dfs();
		int[] expected = { 3, 8 };
		Assert.assertArrayEquals(expected, result);

	}

}
