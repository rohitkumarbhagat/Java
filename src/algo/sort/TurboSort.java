package algo.sort;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @author erotkur Codechef problem Turbo sort : sort large set of numbers
 * 
 */
public class TurboSort {
	private static final int limit = 1000001;
	private static final String inputFileName = "TurboSortInputFile";
	private static final String outPutFile = "TurboSortOutPutFile";

	private static void createInputFile() throws IOException {

		Random randomGenerator = new Random();
		PrintStream filePrintStream = new PrintStream(inputFileName);
		for (int i = 1; i < limit; i++) {
			try {
				filePrintStream.println(randomGenerator.nextInt(limit));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		filePrintStream.close();
	}

	private static void createSortedFile() throws IOException {
		// Read input file and radix sort simultaneously
		int[] sortedList = new int[limit];
		long currentTime = System.currentTimeMillis();
		Scanner fileScanner = new Scanner(new File(inputFileName));
		fileScanner.useDelimiter("\n");
		while (fileScanner.hasNext()) {
			sortedList[fileScanner.nextInt()]++;
		}
		fileScanner.close();
		System.out.println("Time to read file = "
				+ (System.currentTimeMillis() - currentTime));

		currentTime = System.currentTimeMillis();
		PrintStream filePrintStream = new PrintStream(outPutFile);
		for (int i = sortedList.length - 1; i >= 0; i--) {
			try {
				if (sortedList[i] > 0) {
					for (int j = 0; j < sortedList[i]; j++) {
						filePrintStream.println(i);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		filePrintStream.close();
		System.out.println("Time to write file = "
				+ (System.currentTimeMillis() - currentTime));
	}

	public static void main(String[] args) throws IOException {
		// createInputFile();
//		long currentTime = System.currentTimeMillis();
//		// createSortedFile();
//		createInputFile_datastream();
//		System.out.println("time taken= "
//				+ (System.currentTimeMillis() - currentTime));
		
		DataOutputStream out= new DataOutputStream(System.out);
		out.write('a');
	//	out.writeChar('a');
		out.flush();
		out.close();
	}

	private static void createSortedFile_nio() {

	}

	private static void createInputFile_datastream() throws IOException {
		DataOutputStream file;
		try {
			file = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(inputFileName)));

			Random randomGenerator = new Random();
			for (int i = 1; i < limit; i++) {
				try {
					file.writeInt(randomGenerator.nextInt(limit));
					 file.writeChar('\n');

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			file.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}
		DataInputStream file1 = null;
		try {
			file1 = new DataInputStream(new BufferedInputStream(
					new FileInputStream(inputFileName)));
			int abc;
			while (true) {
				abc = file1.readInt();
				System.out.println(abc);
				file1.skip(2);
			}

		} catch (Exception e) {
			file1.close();
		}
	}
}
