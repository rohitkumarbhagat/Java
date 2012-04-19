package simulation.wordcount;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		String inputFileName = "book.txt";
		String outputFileName = "result.txt";
		long currentTime = System.currentTimeMillis();
		Document document = new Document(inputFileName);
		try {

			document.processFile();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outputFileName)));
			writer.write("Sentence Count = " + document.sentenceCount());
			writer.write("\n****************************************************\n");
			writer.write("Duplicate Sentences \n----------------------");
			for (String sentence : document.getDuplicateSentences()) {
				writer.write(sentence);
			}
			writer.write("\n****************************************************\n");

			writer.write("Top 100 words by frequency are \n---------------------------");
			for (String str : document.getNWordsByfrequency(100)) {
				writer.write(str);
			}
			writer.write("\n****************************************************\n");

			writer.write("\nSentence Number : 23 \n-----------------------------\n"
					+ document.getNthSentence(23));
			writer.write("\nSentence Number : 189 \n-----------------------------\n"
					+ document.getNthSentence(189));
			writer.write("\nSentence Number : 590 \n-----------------------------\n"
					+ document.getNthSentence(590));
			writer.write("\nSentence Number : 690 \n-----------------------------\n"
					+ document.getNthSentence(690));
			writer.write("\nSentence Number : 847 \n-----------------------------\n"
					+ document.getNthSentence(847));

			writer.write("\n****************************************************\n");

			writer.write("Time Taken ="
					+ (System.currentTimeMillis() - currentTime)+"  milliseconds");
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
