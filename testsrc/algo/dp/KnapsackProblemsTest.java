package algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapsackProblemsTest {

	private KnapsackProblems knapsack = new KnapsackProblems();

	@Test
	public void test() {
		int[] sizes={2,4,7,9};
		int[] weights={1,6,2,9};
		
		assertEquals(13, knapsack.unboundedKnapsack(sizes, weights, 10));
		assertEquals(0, knapsack.unboundedKnapsack(sizes, weights, 0));
		assertEquals(0, knapsack.unboundedKnapsack(sizes, weights, 1));
		assertEquals(6, knapsack.unboundedKnapsack(sizes, weights, 5));
		assertEquals(36, knapsack.unboundedKnapsack(sizes, weights, 25));
	}
	
	@Test
	public void test1() {
		int[] sizes={2,5,12,23};
		int[] weights={1,6,7,9};
		
		assertEquals(12, knapsack.unboundedKnapsack(sizes, weights, 10));
		assertEquals(0, knapsack.unboundedKnapsack(sizes, weights, 0));
		assertEquals(0, knapsack.unboundedKnapsack(sizes, weights, 1));
		assertEquals(6, knapsack.unboundedKnapsack(sizes, weights, 5));
		assertEquals(30, knapsack.unboundedKnapsack(sizes, weights, 25));
	}
	
	@Test
	public void test2() {
		int[] sizes={2,5,12,23};
		int[] weights={1,6,7,9};
		
		assertEquals(7, knapsack.zeroOneKnapSack(sizes, weights, 10));
		assertEquals(0, knapsack.zeroOneKnapSack(sizes, weights, 0));
		assertEquals(0, knapsack.zeroOneKnapSack(sizes, weights, 1));
		assertEquals(6, knapsack.zeroOneKnapSack(sizes, weights, 5));
		assertEquals(14, knapsack.zeroOneKnapSack(sizes, weights, 25));
		assertEquals(14, knapsack.zeroOneKnapSack(sizes, weights, 23));
		assertEquals(8, knapsack.zeroOneKnapSack(sizes, weights, 15));
	}

}
