package algo.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author erotkur
 * 
 *         A positive integer is called a palindrome if its representation in
 *         the decimal system is the same when read from left to right and from
 *         right to left. For a given positive integer K of not more than
 *         1000000 digits, write the value of the smallest palindrome larger
 *         than K to output. Numbers are always displayed without leading zeros.
 *         Input
 * 
 *         The first line contains integer t, the number of test cases. Followed
 *         by t lines containing integers K. Output
 * 
 *         For each K, output the smallest palindrome larger than K. Example
 * 
 *         Input:
 * 
 *         2
 * 
 *         808
 * 
 *         2133 Output:
 * 
 *         818
 * 
 *         2222
 * 
 */
class PALIN {
	public static void main(String args[]) throws IOException {
		// Scanner in=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner in=new Scanner(f);
		int t = Integer.parseInt(br.readLine()), test;
		int i, l;
		int left, right;
		String s, s1;
		for (test = 0; test < t; test++) {
			s = br.readLine();
			l = s.length();
			char a[] = s.toCharArray();
			s1 = "";
			boolean allnine = true;
			for (i = 0; i < l; i++) {
				if (i >= (l + 1) / 2)
					a[i] = a[l - 1 - i];
				if (a[i] != '9')
					allnine = false;
			}
			// System.out.println(a+ " "+s1);
			if (compare(a, s.toCharArray()) == 1)
				out.println(a);
			else {
				if (allnine) {
					out.print(1);
					for (i = 1; i < l; i++)
						out.print(0);
					out.print(1);
					out.println();
				} else {
					if (l % 2 == 0) {
						left = (l - 1) / 2;
						right = (l + 1) / 2;
					} else
						left = right = l / 2;
					while (left >= 0) {
						if (a[left] < '9') {
							a[left] = a[right] = (char) (a[left] + 1);
							break;
						} else {
							a[left] = a[right] = '0';
						}
						left--;
						right++;
					}
					out.println(a);
				}
			}
		}
		out.flush();
	}

	public static int compare(char a[], char b[]) {
		if (a.length < b.length)
			return -1;
		else if (b.length < a.length)
			return 1;
		else {
			for (int i = 1; i < a.length; i++) {
				if (a[i] < b[i])
					return -1;
				else if (b[i] < a[i])
					return 1;
			}
			return 0;
		}
	}
}
