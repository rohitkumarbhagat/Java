package challenges.topcoder;

import java.util.HashSet;

public class TellTale {
	/**
	 * @param n
	 * @param notToTell
	 * @param parties
	 * @return
	 */
	public static int doNotTellTheTruth(int n, int[] notToTell, String[] parties) {
		int maxExaz = parties.length;
		// scan parties and form graph
		int[][] partyGraph = new int[n][n];
		HashSet<Integer> cannotBeLied = new HashSet<Integer>();

		for (String party : parties) {
			String[] peopleStrList = party.split(" ");
			int[] peopleList = new int[peopleStrList.length];
			int index = 0;
			for (String people : peopleStrList) {
				peopleList[index++] = Integer.parseInt(people)-1;
			}
			for (int i : peopleList) {
				for (int j : peopleList) {
					partyGraph[i][j] = 1;
				}
			}

		}
		// mark all people who cannot be lied
		int[] stack = new int[n];

		for (int i : notToTell) {
			int stackTop = -1;
			cannotBeLied.add(i-1);
			stack[++stackTop] = i-1;
			while (stackTop > -1) {
				int top = stack[stackTop--];
				// all neighbors of top
				for (int nbr = 0; nbr < n; nbr++) {

					if (partyGraph[top][nbr] == 1
							&& !cannotBeLied.contains(nbr)) {
						cannotBeLied.add(nbr);
						stack[++stackTop] = nbr;
					}
				}
			}
		}

		// search party for existence of members from cannotbeLied

		for (String party : parties) {
			String[] peopleStrList = party.split(" ");
			int[] peopleList = new int[peopleStrList.length];
			int index = 0;
			for (String people : peopleStrList) {
				peopleList[index++] = Integer.parseInt(people)-1;
			}
			for (int i : peopleList) {
				if (cannotBeLied.contains(i)) {
					maxExaz--;
					break;
				}
			}

		}

		return maxExaz;
	}
}
