package algo.sort;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestQuickSort extends TestSort {
	private static QuickSort quckSort;

	@BeforeClass
	public static void beforeClass() {
		sortingAlgorithm = new QuickSort();
		quckSort = (QuickSort) sortingAlgorithm;
	}

	@Test
	public void testMedian() {
		int[] a = { 1, 4, 2, 9, 0, 6 };
		Assert.assertEquals(4, quckSort.median(a, 0, a.length - 1));
	}
	
	
	@Test
	public void testMedian1() {
		int[] a = { 1, 4, 2, 9, 0 };
		Assert.assertEquals(2, quckSort.median(a, 0, a.length - 1));
	}
	@Test
	public void testMedian3() {
		int[] a = { 2, 9, 1, 0, 4 };
		Assert.assertEquals(2, quckSort.median(a, 0, a.length - 1));
	}
}
