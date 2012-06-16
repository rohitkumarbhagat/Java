package algo.string;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	static void permutation(String s, int k, List<String> permutations,
			char[] temp) {

		if (k == 0) {
			permutations.add(new String(temp));
		} else {
			for (int i = 0; i < s.length(); i++) {
				temp[k - 1] = s.charAt(i);
				// temp=temp+s.charAt(i);
				permutation(s.substring(0, i) + s.substring(i + 1), k - 1,
						permutations, temp);
			}
		}
	}

	static void combination(String s, int k, List<String> combinations,
			char[] temp) {
		if (k == 0) {
			combinations.add(new String(temp));
//			for(int i=0;i<s.length();i++){
//				temp[k-1]=s.charAt(i);
//				combinations.add(new String(temp));
			}
		else {
			while(s.length() >k-1){
			temp[k-1]=s.charAt(0);
			combination(s.substring(1), k-1, combinations, temp);
			s=s.substring(1);
			}
					
		}
	}

	public static void main(String[] args) {
		List<String> per = new ArrayList<String>();
		List<String> com = new ArrayList<String>();
		String s = "abcde";
		int k = 2;
		char[] temp = new char[k];
		permutation(s, k, per, temp);
		for (String i : per) {
			System.err.println(i);
		}
		System.err.println("count= " + per.size());
		
		System.err.println("Combinations are:");
		combination(s, k, com, temp);
		for (String i : com) {
			System.err.println(i);
		}
		System.err.println("com count="+com.size());
		

	}

}
