package algo.mathematical;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSieveOfErasthones {
	@Test
	public void test() {
		List<Integer> result = Arrays.asList(2, 3, 5);

		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(1, 5));
		
		result=Arrays.asList(2);

		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(1, 2));
		
		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(2, 2));
		
		result=Arrays.asList();
		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(3, 2));
		
		
		result=Arrays.asList(5,7,11,13,17,19,23);
		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(5, 25));
		
		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(4, 28));
		
		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(4, 23));
		
		
		result=Arrays.asList(17,19,23,29);
		Assert.assertEquals(result,
				SieveOfErasthones.primesBetweenNumbers(17, 30));
		
		
	}
}
