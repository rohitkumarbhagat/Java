package algo.mathematical;

import java.util.ArrayList;
import java.util.List;

import common.Pair;

public class Factorization {

	/**
	 * returns prime factorization of n in as list of pairs Each pair contains a
	 * prime number as key and its power as value
	 * 
	 * @param n
	 * @return
	 */
	public static List<Pair<Integer, Integer>> factorize(int n) {
		List<Pair<Integer, Integer>> factors = new ArrayList<Pair<Integer, Integer>>();
		// find prime numbers 1 and sqrt(n)

		for (int prime : SieveOfErasthones.primesBetweenNumbers(2, n)) {
			Pair<Integer, Integer> pair = new Pair<Integer, Integer>();
			pair.key = prime;
			pair.value = 0;
			while (n % prime == 0 && n > 1) {
				n = n / prime;
				pair.value++;
			}
			if (pair.value > 0) {
				factors.add(pair);
			}
			if (n == 1) {
				break;
			}
		}

		// for each prime number, divide as long as n is divisible by it or is
		// 1, record count

		return factors;
	}

	public static void main(String[] args) {
		System.out.println(factorize(4));
		System.out.println(factorize(6));
		System.out.println(factorize(12));
		System.out.println(factorize(96));
		System.out.println(factorize(31));
		System.out.println(factorize(128));
		System.out.println(factorize(224));
	}
}
