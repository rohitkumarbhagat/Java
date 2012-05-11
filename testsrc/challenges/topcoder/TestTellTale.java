package challenges.topcoder;

import org.junit.Assert;
import org.junit.Test;

public class TestTellTale {
	@Test
	public void testCase1() {
		Assert.assertEquals(
				3,
				TellTale.doNotTellTheTruth(4, new int[] {}, new String[] {
						"1 2", "3", "2 3 4" }));

	}

	@Test
	public void testCase2() {

		Assert.assertEquals(0, TellTale.doNotTellTheTruth(4, new int[] { 1 },
				new String[] { "1 2 3 4" }));

	}

	@Test
	public void testCase3() {

		Assert.assertEquals(1, TellTale.doNotTellTheTruth(4, new int[] {},
				new String[] { "1 2 3 4" }));

	}

	@Test
	public void testCase4() {

		Assert.assertEquals(
				2,
				TellTale.doNotTellTheTruth(4, new int[] { 1 }, new String[] {
						"1", "2", "3", "4", "4 1" }));

		Assert.assertEquals(
				0,
				TellTale.doNotTellTheTruth(20, new int[] { 4, 5, 7, 15, 16, 17,
						20 }, new String[] { "1 2 5 7 8 9 10 11 16",
						"1 2 5 10 11 14 17", "2 5 6 7 8 16 18 19 20",
						"1 4 5 6 7 8 16 20", "1 2 4 5 6 10 15 17 18 19",
						"1 3 10 11 19", "1 2 3 4 7 10 11 13 14 15 16 18 19 20",
						"4 10 11 14 15", "1 2 5 7 8 9 12 13 14 16 18",
						"4 8 9 11 15 16 18 20", "3 5 16 17 18 20",
						"4 13 14 16 17 18", "2 3 4 9 10 12 13 14 17 19 20",
						"3 5 6 11 12 15 16 17 18 19",
						"2 3 4 7 9 10 11 12 13 15 16 18 19 20",
						"2 7 10 14 16 19", "1 2 3 5 6 7 8 13 14 16 18 19 20",
						"1 3 4 7 11 12 15 20", "1 3 4 5 14 15 16 18 19",
						"3 7 10 12 13 15 17 19",
						"1 2 4 5 6 7 8 9 10 12 13 15 16 18", "13 19",
						"3 10 11 16", "1 4 5 6 8 10 12 13 15 16 17 19 20",
						"1 3 17 20", "2 3 4 6 8 9 10 12 14",
						"3 5 6 7 8 11 14 16 20", "2 5 16" }));

		Assert.assertEquals(
				5,
				TellTale.doNotTellTheTruth(20, new int[] { 2, 5, 11, 8, 3, 15,
						10, 19, 12 }, new String[] { "6", "4", "14 4", "3",
						"14 13", "15", "16", "15 8", "8 3", "9", "20", "10 1",
						"12", "18", "8", "13 8" }));

		Assert.assertEquals(41, TellTale.doNotTellTheTruth(47, new int[] { 4,
				15, 28, 39, 41 }, new String[] { "1 9", "9 27", "12 1",
				"37 31", "36 47", "6 40", "38 42", "47 6", "46 12", "31 36",
				"42 10", "40 46", "20 38", "22 16", "10 25", "43 37", "16 20",
				"17 43", "33 14", "25 17", "35 19", "23 33", "8 2", "44 34",
				"3 22", "30 35", "2 26", "21 11", "19 45", "34 7", "32 21",
				"18 29", "7 23", "45 44", "13 24", "14 8", "29 5", "5 32",
				"11 13", "26 3", "24 30" }));

		Assert.assertEquals(6, TellTale.doNotTellTheTruth(47,
				new int[] { 5, 24 }, new String[] { "33 12", "33 12", "12 33",
						"12 33", "12 33", "28 31", "18 39", "33 12", "21 19",
						"45 1", "42 15", "5 36", "1 5", "31 21", "23 18",
						"15 11", "11 23", "46 17", "17 3", "10 25", "4 22",
						"47 20", "44 27", "39 28", "38 29", "26 38", "3 2",
						"22 42", "20 46", "45 44", "40 4", "2 40", "9 26",
						"30 41", "16 6", "27 47", "37 32", "41 9", "13 7",
						"43 37", "32 8", "25 30", "6 14", "24 35", "34 16",
						"7 43", "14 24", "45 13", "8 34", "35 10" }));

	}

}
