package simulation.wordcount;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentSentences {
	// buffer which stores document in byte form
	private ByteBuffer documentByteBuffer;
	// List of sentences in document
	private List<Sentence> sentenceList;
	// map of sentence as key and its index in sentenceList as value
	private Map<Sentence, Integer> sentenceMap;
	// total number of sentences
	private int sentenceCount = 0;

	/**
	 * Constructor :Accepts byte buffer representation of document
	 * 
	 * @param documentByteBuffer
	 */
	public DocumentSentences(ByteBuffer documentByteBuffer) {
		this.documentByteBuffer = documentByteBuffer;
		sentenceList = new ArrayList<DocumentSentences.Sentence>();
		sentenceMap = new HashMap<DocumentSentences.Sentence, Integer>();
	}

	/**
	 * Creates a new sentence with its beginning and end point reference in
	 * documentByteBuffer. If sentence is duplicate, increase its count
	 * 
	 * @param begIndex
	 * @param endIndex
	 */
	public void addSentence(int begIndex, int endIndex) {
		Sentence newSentence = new Sentence(begIndex, endIndex, 1);
		Integer sentenceNumber = sentenceMap.get(newSentence);

		if (sentenceNumber == null) {
			// unique sentence : add to list
			sentenceList.add(newSentence);
			sentenceMap.put(newSentence, sentenceList.size() - 1);

		} else {
			// duplicate sentence
			sentenceList.get(sentenceNumber).incerementCount();
		}
		sentenceCount++;

	}

	/**
	 * Returns number of sentences in Document
	 * 
	 */
	public int getSentenceCount() {
		return sentenceCount;
	}

	/**
	 * 
	 * @return nth sentence from Document
	 */
	public String getNthSentence(int n) {
		if (n < sentenceList.size()) {
			return sentenceList.get(n).toString();
		}
		return null;
	}

	/**
	 * @return duplicate sentences in Document with their count in following
	 *         format Sentence =<sentence> \n Count = <frequency of sentence>
	 */
	public List<String> getDuplicateSentences() {
		List<String> duplicateSentenceList = new ArrayList<String>();

		for (Sentence sentence : sentenceList) {
			if (sentence.count > 1) {
				duplicateSentenceList.add("\nSentence = " + sentence.toString()
						+ "\nCount=" + sentence.getCount());
			}
		}
		return duplicateSentenceList;
	}

	// immutable inner class for every sentence
	private class Sentence {
		// beginning index of sentence in document byte buffer
		private final int begIndex;
		// end index of sentence in document byte buffer
		private final int endIndex;
		// frequency of occurence of sentence
		private int count = 1;
		// stores hashcode only if needed
		private int hashCode = 0;
		// stores string representation only if needed
		private String asString;

		public Sentence(int begIndex, int endIndex, int count) {
			this.begIndex = begIndex;
			this.endIndex = endIndex;
			this.count = count;
		}

		public void incerementCount() {
			count++;
		}

		public int getCount() {
			return count;
		}

		/**
		 * @return length of sentence
		 */
		public int length() {
			return endIndex - begIndex + 1;
		}

		/*
		 * returns true if each character of two sentences are same else false
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				// same object
				return true;
			}
			if (obj != null) {
				Sentence othrSentence = (Sentence) obj;
				if (othrSentence.length() == this.length()) {
					for (int thisIndex = begIndex, othrIndex = othrSentence.begIndex, i = 0; i < this
							.length(); i++) {
						if (toLowerCase((char) documentByteBuffer
								.get(thisIndex)) != toLowerCase((char) documentByteBuffer
								.get(othrIndex))) {
							return false;
						}

					}
					return true;
				}
			}
			return false;

		}

		/*
		 * hashcode on the basis of characters stored in sentence.
		 */
		@Override
		public int hashCode() {
			int i = 0;

			if (hashCode == 0) {
				for (i = begIndex; i <= endIndex; i++) {
					hashCode = 31 * hashCode
							+ toLowerCase((char) documentByteBuffer.get(i)) + 7;
				}

			}

			return hashCode;
		}

		@Override
		public String toString() {
			if (asString == null) {
				StringBuilder strBuilder = new StringBuilder();
				for (int i = begIndex; i <= endIndex; i++) {
					strBuilder.append(toLowerCase((char) documentByteBuffer
							.get(i)));
				}
				asString = strBuilder.toString();
			}
			return asString;
		}

		/**
		 * @param c
		 * @return lower case if c is alphabet if c is '\r' or '\n' return ' '
		 */
		private char toLowerCase(char c) {

			return c > 64 && c < 91 ? (char) (c + 32)
					: c == '\r' || c == '\n' ? ' ' : c;

		}

	}
}
