package simulation.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentWords {

	private final Map<String, Integer> wordMap;

	public DocumentWords() {
		wordMap = new HashMap<String, Integer>();
	}

	public void addWord(String word) {
		Integer wordCount = wordMap.get(word);
		if (wordCount == null) {
			wordMap.put(word, 1);
		} else {
			wordMap.put(word, wordCount + 1);
		}

	}

	public List<String> getNWordsByfrequency(int n) {
		List<String> words = new ArrayList<String>(n);
		if (n < wordMap.size()) {
			List<Integer> valuesList = new ArrayList<Integer>(wordMap.values());
			Collections.sort(valuesList);
			int limit = valuesList.get(valuesList.size() - n);
			for (String word : wordMap.keySet()) {
				if (wordMap.get(word) >= limit) {
					// String[] wordData = new String[2];
					// wordData[0] = word;
					// wordData[1] = wordMap.get(word) + "";
					words.add("\nWord = "+word+"\nFrequency = "+wordMap.get(word));
				}
			}
		}
		return words;

	}

}
