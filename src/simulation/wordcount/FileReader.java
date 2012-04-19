package simulation.wordcount;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReader {
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	private Map<List<Integer>, Integer> sentenceMap = new HashMap<List<Integer>, Integer>();
	private List<List<Integer>> sentenceList = new ArrayList<List<Integer>>();
	List<String> words = new ArrayList<String>(1000);
	List<Integer> wordCount = new ArrayList<Integer>(1000);
	List<String> sentences = new ArrayList<String>();

	private int sentenceCount = 0;

	private int processWord(StringBuilder word) {
		int index = -1;
		if (word.length() > 0) {
			Integer indx = wordMap.get(word.toString());
			if (indx != null) {
				index = indx;
				wordCount.set(index, (wordCount.get(index) + 1));
			} else {
				index = words.size();
				words.add(word.toString());
				wordMap.put(word.toString(), index);
				wordCount.add(1);

			}

		}
		return index;
	}

	private int process(List<Integer> sentence) {
		if (sentence.size() > 0) {
			sentenceCount++;
			Integer count = sentenceMap.get(sentence);
			if (count != null) {
				sentenceMap.put(sentence, count + 1);

			} else {
				sentenceMap.put(sentence, 1);
				sentenceList.add(sentence);

			}
			return 1;
		} else {
			return -1;
		}
	}

	private void readFile() {
		FileChannel fc;
		int beg = 0;
		int end = 0;
		char lastchar = '\0';
		try {
			fc = (new FileInputStream("/Users/rohitkumar/Downloads/book.txt"))
					.getChannel();
			ByteBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

			char abc;
			boolean sentenceEnd = false;
			StringBuilder word = new StringBuilder();
			List<Integer> sentence = new ArrayList<Integer>();
			while (ib.hasRemaining()) {
				abc = (char) ib.get();

				abc = abc > 64 && abc < 91 ? (char) (abc + 32) : abc;
				switch (abc) {
				case '!':
				case '?':
				case ']':
				case '.':
					sentenceEnd = true;
				case ' ':
				case ',':
				case '-':
				case ';':
				case '\'':
				case '"':
				case '\r':
				case '\n': // word is complete
					lastchar = abc;
					int wordIndex = processWord(word);
					if (wordIndex != -1) {
						sentence.add(wordIndex);
						sentence.add((int)lastchar);
						word = new StringBuilder();
					}
					if (sentenceEnd) {

						if (process(sentence) == 1) {
							lastchar = '\0';
							sentence = new ArrayList<Integer>();
						}
						sentenceEnd = false;
					}
					break;
				default:
					word.append(abc);

				}
			}

			System.out.println(sentenceMap.size());
			for (List<Integer> sentence1 : sentenceList) {
				if (sentenceMap.get(sentence1) > 1) {
					for (int i : sentence1) {
						System.out.print(words.get(i) + " ");
					}
					System.out.println("\ncount = "
							+ sentenceMap.get(sentence1));
				}
			}

			// for(){
			//
			// }
			System.out.println(sentenceCount);
			System.out.println("word count :" + wordMap.size());
			System.out.println("word count :" + words.size());

			fc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
		new FileReader().readFile();
		System.out.println("time taken = "
				+ (System.currentTimeMillis() - currentTime));
	}
}
