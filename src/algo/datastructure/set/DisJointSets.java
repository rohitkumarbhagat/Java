package algo.datastructure.set;

import java.util.HashMap;

import common.Utils;

public class DisJointSets<T> {
	private int[] disjointSets;
	private HashMap<T, Integer> nodeMap;
	private int size = 0;
	private int noOfElements = 0;

	public DisJointSets(int size) {

		this.size = size;
		disjointSets = new int[size];
		nodeMap = new HashMap<T, Integer>();
	}

	public boolean makeSet(T element) {
		if (element != null && noOfElements < size) {
			if (nodeMap.get(element) == null) {
				// new element
				disjointSets[noOfElements] = -1;
				nodeMap.put(element, noOfElements);
				noOfElements++;
			}
			return true;
		} else {
			return false;
		}
	}

	private int findSet(int index) {
		if (index < 0 || index >= noOfElements) {
			return -1;
		}
		int parentIndex = disjointSets[index];
		if (parentIndex < 0) {
			return index;
		}
		return disjointSets[index] = findSet(parentIndex);
	}

	public int findSet(T element) {

		if (element == null || nodeMap.get(element) == null) {
			return -1;
		}
		int elementIndex = nodeMap.get(element);

		return findSet(elementIndex);

	}

	public int union(T element1, T element2) {

		if (element1 == null || element2 == null
				|| nodeMap.get(element2) == null
				|| nodeMap.get(element1) == null) {
			return -1;
		}
		return union(nodeMap.get(element1), nodeMap.get(element2));

	}

	private int union(int index1, int index2) {
		if (index1 < 0 || index2 < 0 || index1 >= noOfElements
				|| index2 >= noOfElements) {
			return -1;
		}
		int set1 = findSet(index1);
		int set2 = findSet(index2);
		if (set1 == set2) {
			return set1;
		}
		// merge set with hsmaller height to higher height.

		// Merge top elements of sets now

		if (disjointSets[set1] == disjointSets[set2]) {
			// equal heights
			disjointSets[set1] = set2;
			disjointSets[set2]--;
			return set2;
		}
		int smallerSetIndex = set1;
		int biggerSetIndex = set2;
		if (disjointSets[set1] < disjointSets[set2]) {
			smallerSetIndex = set2;
			biggerSetIndex = set1;
		}

		disjointSets[smallerSetIndex] = biggerSetIndex;

		return biggerSetIndex;

	}

	@Override
	public String toString() {
		String result = "";
		result = "Disjoint set = "
				+ Utils.getArrayAsString(disjointSets, noOfElements) + "\n"
				+ "Hash map =" + nodeMap;
		return result;
	}
}
