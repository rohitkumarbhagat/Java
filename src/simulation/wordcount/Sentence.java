package simulation.wordcount;

import java.nio.ByteBuffer;

public class Sentence {

	private int begIndex = 0;
	private int endIndex = 0;
	private int count = 1;
	private ByteBuffer document;

	public Sentence(int begIndex, int endIndex, int count, ByteBuffer document) {
		this.begIndex = begIndex;
		this.endIndex = endIndex;
		this.count = count;
		this.document = document;
	}

	public int getBegIndex() {
		return begIndex;
	}

	public void setBegIndex(int begIndex) {
		this.begIndex = begIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void incrementCount() {
		count++;
	}

	public int length() {
		return endIndex - begIndex + 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sentence) {
			Sentence newSentence = (Sentence) obj;
			if (length() == newSentence.length()) {

//				for(int firstSenScanner=begIndex,int scndSenScanner=newSentence.getBegIndex(),int i = 0;i<newSentence.length();i++)
//				{
//					
//				}
//				
			}

			for (int i = begIndex; i <= endIndex; i++) {
				if (true) {

				}
			}
		} else {
			return false;
		}
		return true;
	}
}
