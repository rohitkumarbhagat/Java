package algo.mathematical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfErasthones {

	/**
	 * 
	 * Returns primes between numbers beg and end including beg and end and
	 * primes.
	 * 
	 * @param beg
	 * @param end
	 * @return
	 */
	public static List<Integer> primesBetweenNumbers(int beg, int end) {
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[end - beg + 1];
		Arrays.fill(isPrime, true);
		for (int i = 1; i > 0 && beg <= i; i--) {
			isPrime[i - beg] = false;
		}
		int sqrt_end = (int) Math.sqrt((double) end);
		for (int i = 2; i <= sqrt_end; i++) {
			for (int j = multipleGreater(i, beg) - beg; j < isPrime.length; j += i) {
				if (j + beg > i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primes.add(beg + i);
			}
		}

		return primes;

	}

	private static int multipleGreater(int n, int startPoint) {
		int m = startPoint > n ? startPoint : n;
		if (m == startPoint && n > 0) {
			m = startPoint % n == 0 ? startPoint : startPoint
					- (startPoint % n) + n;
		}

		return m;
	}

}
