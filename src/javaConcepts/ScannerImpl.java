package javaConcepts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class ScannerImpl {
	public static void main(String[] args) throws IOException {
		String text = "123 4 dh i 4 nn";
		Scanner sc = new Scanner(text);
		System.out.println(sc.nextInt());
		System.out.println(sc.nextInt());
		sc.close();
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String abc = "ssdscscds";
		System.out.println(r.readLine());
	}
}
