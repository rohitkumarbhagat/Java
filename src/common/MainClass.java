package common;

import java.util.Calendar;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("Hash Value: " + hashValue(1290126162373l));
		System.out.println(hashValue(new Long(Calendar.getInstance()
				.getTimeInMillis())));

	}

	public static Integer hashValue(Long a) {
		//System.out.println("Current Time: " + a);
		String str = new StringBuilder((String.format("%64s", Long.toBinaryString(a)).replace(
				' ', '0')).substring(48)).reverse().toString();
		//str = new StringBuilder(str).reverse().toString();

		Integer tree[] = new Integer[31];

		int k = 2;
		for (int j = 0; j <= 30; j++) {
			if (j >= 15) {
				k = -2;
			}
			tree[j] = Integer.parseInt(str.charAt((j * 2) % 16) + "")
					+ (k * Integer
							.parseInt(str.charAt(((j * 2) + 1) % 16) + ""));
			// tree[j]
		}
		int j=k=0;
		while(j<=30){
			if(j>=15){
				k=-2;
			}
			tree[j] = Integer.parseInt(str.charAt((j * 2) % 16) + "")
					+ (k * Integer
							.parseInt(str.charAt(((j * 2) + 1) % 16) + ""));
		}

		for ( j = 14; j >= 0; j--) {
			if (tree[j] == 0) {
				tree[j] = tree[2 * j + 1] + 2 * tree[2 * j + 2];
			} else if (tree[j] == 1) {
				tree[j] = tree[2 * j + 1] * 2 + tree[2 * j + 2];
			} else if (tree[j] == 2) {
				tree[j] = tree[2 * j + 1] + tree[2 * j + 2];
			} else {
				tree[j] = tree[j * 2 + 1] * tree[j * 2 + 2];
			}
		}
		return tree[0];
	}
}
