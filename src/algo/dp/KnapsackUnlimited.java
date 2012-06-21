package algo.dp;

public class KnapsackUnlimited {

	public int exactKnapsack(int[] sizes, int[] weights, int capacity) {
		int[] capacityList = new int[capacity + 1];
		for (int i = 1; i < capacityList.length; i++) {
			capacityList[i] = Integer.MIN_VALUE;
			for (int j = 0; j < sizes.length; j++) {
				int tmp = i - sizes[j];
				if (tmp >= 0 && capacityList[tmp] != Integer.MIN_VALUE) {
					if (capacityList[i] < capacityList[tmp] + weights[j]) {
						capacityList[i] = capacityList[tmp] + weights[j];
					}
				}
			}
		}
		return capacityList[capacity];

	}
	
	public static void main(String[] args) {
		
	}
}
