package algo.string;

public class SubStrings {
	public static void main(String[] args) {
		String str = "abc";
		for (int i = 0; i < str.length(); i++) {
			StringBuilder strb = new StringBuilder();
			for (int j = i; j < str.length(); j++) {
				System.out.println(strb.append(str.charAt(j)));
			}
		}
	}
}
