package simulation.wordcount;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Document {

	private File file;
	private ByteBuffer documentByteBuffer;
	private DocumentSentences documentsentences;
	private DocumentWords documentWords;

	public Document(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {

			this.file = file;

			processFile();
		}

	}

	private void processFile() {
		FileChannel fc = null;
		int beg = 0;

		try {
			fc = (new FileInputStream(file)).getChannel();
			documentByteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());

			documentsentences = new DocumentSentences(documentByteBuffer);
			documentWords = new DocumentWords();

			boolean sentenceEnd = false;
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
					sentenceEnd = false;
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean processWord(StringBuilder word) {
		if (word.length() > 0) {
			documentWords.addWord(word.toString());
			return true;
		}
		return false;
	}
	
	public int getSentenceCount(){
		
	}

	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
		Document d = new Document("/home/erotkur/Downloads/book.txt");
		System.out.println(d.documentsentences.getSentenceCount());
		System.out.println(d.documentsentences.getNthSentence(24));
		System.out.println(d.documentsentences.getDuplicateSentences());
		System.out.println(d.documentWords.getNWordsByfrequency(100));
		System.out.println("Time Taken :"
				+ (System.currentTimeMillis() - currentTime));
	}

	protected boolean isCharWordDelimeter(char c) {
		boolean flag = false;
		switch (c) {
		case ' ':
		case ',':
		case '-':
		case ';':
		case '\'':
		case '"':
		case '\r':
		case '\n':
			flag = true;
		} // word
		return flag;
	}

	protected boolean isCharSentenceDelimeter(char c) {
		boolean flag = false;

		switch (c) {
		case '!':
		case '?':
		case ']':
		case '.':
			flag = true;
		}
		return flag;
	}

}
