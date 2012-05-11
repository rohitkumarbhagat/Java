package algo.sort;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSort {

	protected static CanSort sortingAlgorithm;

	@BeforeClass
	public static void beforeClass() {
		sortingAlgorithm = new InsertionSort();
	}

	@AfterClass
	public static void afterClass() {
		sortingAlgorithm = null;
	}

	@Before
	public void setUp() {

	}

	@After
	public void tesrDown() {

	}

	@Test
	public void testMergeSort() {
		int[] a = { -5, -4, -3, -2, -4, 7, 8 };
		int[] c = { -5, -4, -4, -3, -2, 7, 8 };
		sortingAlgorithm.sort(a);
		Assert.assertArrayEquals(c, a);
	}

	@Test
	public void testMergeSort1() {
		int[] a = { -5, 100, -3, -2, 0, 7, 2 };
		int[] c = { -5, -3, -2, 0, 2, 7, 100 };
		sortingAlgorithm.sort(a);
		Assert.assertArrayEquals(c, a);
	}

	@Test
	public void testMergeSort2() {
		int[] a = {};
		int[] c = {};
		sortingAlgorithm.sort(a);
		Assert.assertArrayEquals(c, a);
	}

	@Test
	public void testMergeSort3() {
		int[] a = { 1 };
		int[] c = { 1 };
		MergeSort.mergeSort(a);
		Assert.assertArrayEquals(c, a);
	}

	@Test
	public void testMergeSort4() {
		int[] a = { -2, 1 };
		int[] c = { -2, 1 };
		sortingAlgorithm.sort(a);
		Assert.assertArrayEquals(c, a);
	}

}
