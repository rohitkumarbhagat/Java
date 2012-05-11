package algo.sort;

import org.junit.BeforeClass;

public class TestRandomizedQuickSort extends TestSort {
	@BeforeClass
	public static void beforeClass() {
		sortingAlgorithm = new RandomizedQuickSort();
	}

}
