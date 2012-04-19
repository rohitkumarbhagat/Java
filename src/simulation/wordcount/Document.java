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
	// byte buffer representation document
	private ByteBuffer documentByteBuffer;
	private DocumentSentences documentsentences;
	private DocumentWords documentWords;
	private char[] wordDelimeters = { ' ', ',', '-', ';', '\'', '"', '\r', '\n' };
	private char[] sentenceDelimeters = { '!', '?', ']', '.' };

	/**
	 * Constructor :Accepts File Path of a File to Process
	 * 
	 * @param filePath
	 */
	public Document(String filePath) {
		file = new File(filePath);

	}

	/**
	 * Override the Words Delimeters
	 * 
	 * @param cd
	 */
	public void setWordDelimeters(char... cd) {
		wordDelimeters = cd;
	}

	/**
	 * Override the Sentences Delimeters
	 * 
	 * @param sd
	 */

	public void setSentenceDelimeters(char... sd) {
		sentenceDelimeters = sd;
	}

	/**
	 * Scan the File Character by Character
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void processFile() throws IOException, FileNotFoundException {
		FileChannel fc = null;
		int beg = 0;

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

			if (isCharWordDelimeter(abc) || isCharSentenceDelimeter(abc)) {
				if (processWord(word)) {
					word = new StringBuilder();
				}
				if (isCharSentenceDelimeter(abc)) {

					documentsentences.addSentence(beg,
							documentByteBuffer.position() - 1);
					beg = documentByteBuffer.position();
				}
			} else {
				word.append(abc);
			}

		}

		fc.close();

	}

	/**
	 * If word is complete then add the word in documentWords List
	 * 
	 * @param word
	 * @return
	 */
	private boolean processWord(StringBuilder word) {
		if (word.length() > 0) {
			documentWords.addWord(word.toString());
			return true;
		}
		return false;
	}

	/**
	 * Get the Sentence Count
	 * 
	 * @return
	 */
	public int sentenceCount() {
		return documentsentences.getSentenceCount();
	}

	/**
	 * Get the Nth sentence of document
	 * 
	 * @param n
	 * @return
	 */
	public String getNthSentence(int n) {
		return documentsentences.getNthSentence(n);
	}

	/**
	 * @return duplicate sentences in Document with their count in following
	 *         format Sentence =<sentence> \n Count = <frequency of sentence>
	 */

	public List<String> getDuplicateSentences() {
		return documentsentences.getDuplicateSentences();
	}

	/**
	 * returns atleast n words which have highest frequency in document
	 * 
	 * @param n
	 *            = number of words with highest frequency
	 * @return list of string with format : Word = <word> \n Frequency =
	 *         <frequency>, empty if atleast that many words does not exist
	 */
	public List<String> getNWordsByfrequency(int n) {
		return documentWords.getNWordsByfrequency(n);
	}

	/**
	 * Checks whether the character id ending character for word or not
	 * 
	 * @param c
	 * @return
	 */
	private boolean isCharWordDelimeter(char c) {
		for (char wordDelimeter : wordDelimeters) {
			if (c == wordDelimeter) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the character id ending character for sentence or not
	 * 
	 * @param c
	 * @return
	 */
	private boolean isCharSentenceDelimeter(char c) {
		for (char sentenceDelimeter : sentenceDelimeters) {
			if (c == sentenceDelimeter) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return get all sentences made available for unit testing purpose
	 */
	public DocumentSentences getDocumentsentences() {
		return documentsentences;
	}

}
