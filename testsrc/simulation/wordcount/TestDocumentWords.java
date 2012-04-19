package simulation.wordcount;

import java.util.List;

import junit.framework.TestCase;

public class TestDocumentWords extends TestCase{
	
	DocumentWords testDocumentWords ;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testDocumentWords = new DocumentWords();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		testDocumentWords = null ;
	}

	
	public void testAddWordForWordCount()
	{
		testDocumentWords.addWord("test1");
		testDocumentWords.addWord("test2");
		testDocumentWords.addWord("test1");
		testDocumentWords.addWord(null);
		testDocumentWords.addWord(null);
		
		int test1Count = testDocumentWords.getWordMap().get("test1") ;
		int test2Count = testDocumentWords.getWordMap().get("test2") ;
		int nullCount = testDocumentWords.getWordMap().get(null) ;
		
		assertEquals(2, test1Count);
		assertEquals(1, test2Count);
		assertEquals(2, nullCount);
		
	}
	
	
	public void testNWordForHighestFreqWord()
	{
		String highestFreqWord = "test2";
		testDocumentWords.addWord(highestFreqWord);
		testDocumentWords.addWord(highestFreqWord);
		testDocumentWords.addWord(highestFreqWord);
		testDocumentWords.addWord("test1");
		
		List<String> list = testDocumentWords.getNWordsByfrequency(1);
		
		assertTrue(list.contains("\nWord = "+ highestFreqWord + "\nFrequency = "+ 3));
		
	}
	
	public void testNWordForTopTwoHighestFreqWords()
	{
		String highestFreqWord = "test2";
		String secondHighestFreqWord = "test1";
		testDocumentWords.addWord(highestFreqWord);
		testDocumentWords.addWord(highestFreqWord);
		testDocumentWords.addWord(highestFreqWord);
		testDocumentWords.addWord(secondHighestFreqWord);
		testDocumentWords.addWord(secondHighestFreqWord);
		
		List<String> list = testDocumentWords.getNWordsByfrequency(2);
		System.out.println("hi" + list.size());
		for ( String s : list)
			System.out.println(s);
		assertTrue(list.contains("\nWord = "+ highestFreqWord + "\nFrequency = "+ 3));
		assertTrue(list.contains("\nWord = "+ secondHighestFreqWord + "\nFrequency = "+ 2));
		
	}
}
