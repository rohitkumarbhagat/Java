package simulation.wordcount;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentSentences {

	private ByteBuffer documentByteBuffer;
	private List<Sentence> sentenceList;
	private Map<Sentence, Integer> sentenceMap;
	private int sentenceCount = 0;

	public DocumentSentences(ByteBuffer documentByteBuffer) {
		this.documentByteBuffer = documentByteBuffer;
		sentenceList = new ArrayList<DocumentSentences.Sentence>();
		sentenceMap = new HashMap<DocumentSentences.Sentence, Integer>();
	}

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

	public int getSentenceCount() {
		return sentenceCount;
	}

	public String getNthSentence(int n) {
		if (n < sentenceList.size()) {
			return sentenceList.get(n).toString();
		}
		return null;
	}

	public List<String> getDuplicateSentences() {
		List<String> duplicateSentenceList = new ArrayList<String>();

		for (Sentence sentence : sentenceList) {
			if (sentence.count > 1) {
				duplicateSentenceList.add("\nSentence = "+sentence.toString()+"\nCount="+sentence.getCount());
			}
		}
		return duplicateSentenceList;
	}

	private class Sentence {

		private final int begIndex;
		private final int endIndex;
		private int count = 1;
		private int hashCode = 0;
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

		public int length() {
			return endIndex - begIndex + 1;
		}

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

		@Override
		public int hashCode() {
			int i=0;
			try {
				if (hashCode == 0) {
					for (i = begIndex; i <= endIndex; i++) {
						hashCode = 31 * hashCode
								+ toLowerCase((char) documentByteBuffer.get(i))
								+ 7;
					}

				}
			} catch (Exception e) {
i=i;
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

		private char toLowerCase(char c) {

			return c > 64 && c < 91 ? (char) (c + 32)
					: c == '\r' || c == '\n' ? ' ' : c;

		}

	}
}
