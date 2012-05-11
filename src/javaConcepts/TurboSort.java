package javaConcepts;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TurboSort {

	private static void writeFile() throws IOException {
		StringBuilder strBldr = new StringBuilder();
		for (int i = 0; i < 1000000; i++) {
			strBldr.append(10000);
			strBldr.append("\n");
		}

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				System.out));

		writer.write(strBldr.toString());
		writer.flush();
	//	writer.close();

	}

	public static void main(String[] args) throws IOException {
		long currentTime = System.currentTimeMillis();
		writeFile();
		System.out.println("******Time taken was :"
				+ (System.currentTimeMillis() - currentTime));
	}
}
