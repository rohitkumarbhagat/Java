package algo.sort;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMergeSort extends TestSort {
	@BeforeClass
	public static void beforeClass() {
		sortingAlgorithm = new MergeSort();
	}

	@Test
	public void testMerge1() {
		int[] a = { 1, 6, 9, 23 };
		int[] b = { 0, 7, 34, 67, 100 };
		int[] c = { 0, 1, 6, 7, 9, 23, 34, 67, 100 };
		Assert.assertArrayEquals(c, MergeSort.merge(a, b));

	}

	@Test
	public void testMerge2() {
		int[] a = { 1, 6, 9, 23 };
		int[] b = {};
		int[] c = { 1, 6, 9, 23 };
		Assert.assertArrayEquals(c, MergeSort.merge(a, b));
	}

	@Test
	public void testMerge3() {
		int[] b = { 1, 6, 9, 23 };
		int[] a = {};
		int[] c = { 1, 6, 9, 23 };
		Assert.assertArrayEquals(c, MergeSort.merge(a, b));
	}

	@Test
	public void testMerge4() {
		int[] b = {};
		int[] a = {};
		int[] c = {};
		Assert.assertArrayEquals(c, MergeSort.merge(a, b));
	}

	@Test
	public void testMerge5() {
		int[] b = { 1, 2, 3 };
		int[] a = { -4, -2, 1 };
		int[] c = { -4, -2, 1, 1, 2, 3 };
		Assert.assertArrayEquals(c, MergeSort.merge(a, b));
	}

	@Test
	public void testInplaceMerge() {
		int[] a = { -4, -2, 1, 4, 2, 7, 8 };
		int[] c = { -4, -2, 1, 2, 4, 7, 8 };
		int[] temp = new int[a.length];
		MergeSort.inplaceMerge(a, temp, 0, a.length - 1, 3);
		Assert.assertArrayEquals(c, a);
	}

	@Test
	public void testInplaceMerge1() {
		int[] a = { -5, -2, -4, -3, 2, 7, 8 };
		int[] c = { -5, -4, -3, -2, 2, 7, 8 };
		int[] temp = new int[a.length];
		MergeSort.inplaceMerge(a, temp, 0, 3, 1);
		Assert.assertArrayEquals(c, a);
	}

	@Test
	public void testInplaceMerge2() {
		int[] a = { -5, -4, -3, -2, -4, 7, 8 };
		int[] c = { -5, -4, -4, -3, -2, 7, 8 };
		int[] temp = new int[a.length];
		MergeSort.inplaceMerge(a, temp, 0, 4, 3);
		Assert.assertArrayEquals(c, a);
	}

}
