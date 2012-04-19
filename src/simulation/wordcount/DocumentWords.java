package simulation.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentWords {

	// map stores word as key and frequency as value
	private final Map<String, Integer> wordMap;

	public DocumentWords() {
		wordMap = new HashMap<String, Integer>();
	}

	/**
	 * adds the word to wordmap if not present, else increment its count
	 * @param word = word to be added
	 */
	public void addWord(String word) {
		Integer wordCount = wordMap.get(word);
		if (wordCount == null) {
			wordMap.put(word, 1);
		} else {
			wordMap.put(word, wordCount + 1);
		}

	}
	
	public Map<String, Integer> getWordMap() {
		return wordMap;
	}

	/**
	 * returns atleast n words which have highest frequency in document
	 * 
	 * @param n
	 *            = number of words with highest frequency
	 * @return list of string with format : Word = <word> \n Frequency =
	 *         <frequency>,
	 *         empty if atleast that many words does not exist
	 */
	public List<String> getNWordsByfrequency(int n) {
		List<String> words = new ArrayList<String>(n);
		if (n <= wordMap.size()) {
			List<Integer> valuesList = new ArrayList<Integer>(wordMap.values());
			// sort on frequency
			Collections.sort(valuesList);
			// find frequency of nth word
			int limit = valuesList.get(valuesList.size() - n);
			// scan and locate words with atleast that frequency
			for (String word : wordMap.keySet()) {
				if (wordMap.get(word) >= limit) {
					words.add("\nWord = " + word + "\nFrequency = "
							+ wordMap.get(word));
				}
			}
		}
		return words;

	}

}
