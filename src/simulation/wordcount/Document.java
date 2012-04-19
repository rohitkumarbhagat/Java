package simulation.wordcount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class Document {

	private File file;
	private ByteBuffer documentByteBuffer;
	private DocumentSentences documentsentences;
	private DocumentWords documentWords;
	private char[] wordDelimeters = { ' ', ',', '-', ';', '\'', '"', '\r', '\n' };
	private char[] sentenceDelimeters = { '!', '?', ']', '.' };

	public Document(String filePath) {
		file = new File(filePath);

	}

	public void setWordDelimeters(char... cd) {
		wordDelimeters = cd;
	}

	public void setSentenceDelimeters(char... sd) {
		sentenceDelimeters = sd;
	}

	public final void processFile() throws IOException, FileNotFoundException {
		FileChannel fc = null;
		int beg = 0;

		// try {
		fc = (new FileInputStream(file)).getChannel();
		documentByteBuffer = fc
				.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

		documentsentences = new DocumentSentences(documentByteBuffer);
		documentWords = new DocumentWords();

		StringBuilder word = new StringBuilder();

		char abc;
		while (documentByteBuffer.hasRemaining()) {
			abc = (char) documentByteBuffer.get();

			abc = abc > 64 && abc < 91 ? (char) (abc + 32) : abc;

			if (isCharWordDelimeter(abc)) {
				if (processWord(word)) {
					word = new StringBuilder();
				}
			} else if (isCharSentenceDelimeter(abc)) {

				documentsentences.addSentence(beg,
						documentByteBuffer.position() - 1);
				// sentenceEnd = false;
				beg = documentByteBuffer.position();
			} else {
				word.append(abc);
			}

			// switch (abc) {
			// case '!':
			// case '?':
			// case ']':
			// case '.':
			// sentenceEnd = true;
			// case ' ':
			// case ',':
			// case '-':
			// case ';':
			// case '\'':
			// case '"':
			// case '\r':
			// case '\n': // word is complete
			//
			// int wordIndex = processWord(word);
			// if (wordIndex != -1) {
			// word = new StringBuilder();
			// }
			// if (sentenceEnd) {
			//
			// documentsentences.addSentence(beg,
			// documentByteBuffer.position() - 1);
			// sentenceEnd = false;
			// beg = documentByteBuffer.position();
			// }
			// break;
			// default:
			// word.append(abc);
			//
			// }
		}

		fc.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	private boolean processWord(StringBuilder word) {
		if (word.length() > 0) {
			documentWords.addWord(word.toString());
			return true;
		}
		return false;
	}

	public final int sentenceCount() {
		return documentsentences.getSentenceCount();
	}

	public final String getNthSentence(int n) {
		return documentsentences.getNthSentence(n);
	}

	public List<String> getDuplicateSentences() {
		return documentsentences.getDuplicateSentences();
	}

	public List<String> getNWordsByfrequency(int n) {
		return documentWords.getNWordsByfrequency(n);
	}

	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
		Document d = new Document("/Users/rohitkumar/Downloads/book.txt");
		try {
			d.processFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d.documentsentences.getSentenceCount());
		System.out.println(d.documentsentences.getNthSentence(24));
		System.out.println(d.documentsentences.getDuplicateSentences());
		System.out.println(d.documentWords.getNWordsByfrequency(100));
		System.out.println("Time Taken :"
				+ (System.currentTimeMillis() - currentTime));
	}

	private boolean isCharWordDelimeter(char c) {
		for (char wordDelimeter : wordDelimeters) {
			if (c == wordDelimeter) {
				return true;
			}
		}
		return false;
	}

	private boolean isCharSentenceDelimeter(char c) {
		for (char sentenceDelimeter : wordDelimeters) {
			if (c == sentenceDelimeter) {
				return true;
			}
		}
		return false;
	}

}