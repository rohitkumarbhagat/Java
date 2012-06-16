package algo.string;

import org.junit.Assert;
import org.junit.Test;

public class TestMatrixStringSearch {
	private char[][] matrix = { { 'a', 'c', 'p', 'r', 'c' },

	{ 'x', 's', 'o', 'p', 'c' }, { 'v', 'o', 'v', 'n', 'i' },
			{ 'w', 'g', 'f', 'm', 'n' }, { 'q', 'a', 't', 'i', 't' } };
	private MatrixStringSearch search = new MatrixStringSearch();

	@Test
	public void testCase1() {
		Assert.assertTrue(search.isPresent(matrix, "microsoft", 5, 5));
	}
	
	@Test
	public void testCase2() {
		Assert.assertFalse(search.isPresent(matrix, "microsoft1", 5, 5));
	}
	
	@Test
	public void testCase3() {
		Assert.assertTrue(search.isPresent(matrix, "axof", 5, 5));
	}
	
	@Test
	public void testCase4() {
		Assert.assertTrue(search.isPresent(matrix, "vofmt", 5, 5));
	}
	
	@Test
	public void testCase5() {
		Assert.assertTrue(search.isPresent(matrix, "xsac", 5, 5));
	}
	@Test
	public void testCase6() {
		Assert.assertFalse(search.isPresent(matrix, "xsacx", 5, 5));
	}



}
