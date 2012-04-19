package simulation.wordcount;

import junit.framework.TestCase;

public class TestDocumentSentences extends TestCase{

	DocumentSentences testDocumentSentences ;
	Document testDocument ;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		testDocument = new Document("test.txt");
		testDocument.processFile();
		
	
	
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		testDocument = null;
		testDocumentSentences = null ;
	}
	
	public void testgetDocumentSentences()
	{
		testDocumentSentences = testDocument.getDocumentsentences();
		assertTrue(testDocumentSentences.getDuplicateSentences().get(0).contains("which i am advancing, gives me a foretaste of those icy climes"));
		assertEquals("which i am advancing, gives me a foretaste of those icy climes.",testDocumentSentences.getNthSentence(0));
		assertEquals(5,testDocumentSentences.getSentenceCount());
		
		
	}
	
}
