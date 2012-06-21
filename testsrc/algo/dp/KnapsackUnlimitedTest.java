package algo.dp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnapsackUnlimitedTest {
	private KnapsackUnlimited knapsack;

	@Before
	public  void setup() {
		knapsack = new KnapsackUnlimited();
	}

	@Test
	public void test() {
		int[] sizes={2,3,6,8};
		int[] weights={2,6,3,1};
		assertEquals(16, knapsack.exactKnapsack(sizes, weights, 10));
		assertEquals(8, knapsack.exactKnapsack(sizes, weights, 5));
		
	}
	@Test
	public void test2() {
		
		int[] sizes={2,4,6,8};
		int[] weights={2,6,3,1};
		assertEquals(Integer.MIN_VALUE, knapsack.exactKnapsack(sizes, weights, 7));
		assertEquals(18, knapsack.exactKnapsack(sizes, weights, 12));
		assertEquals(Integer.MIN_VALUE, knapsack.exactKnapsack(sizes, weights, 13));
	}

}
