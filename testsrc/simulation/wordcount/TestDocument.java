package simulation.wordcount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDocument {

	static Document document;

	@BeforeClass
	public static void init() throws FileNotFoundException, IOException {
		try {
			document = new Document("test.txt");
			document.processFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSentenceCount() {
		assertEquals(document.sentenceCount(), 6);
	}

	@Test
	public void testGetNthSentence() {
		assertEquals("hi umesh.", document.getNthSentence(0));
		assertEquals(" some are bad\" some better?", document.getNthSentence(2));

	}

	@Test
	public void testGetDuplicateSentences() {
		assertEquals(1, document.getDuplicateSentences().size());
		assertEquals("\nSentence = hi umesh.\nCount=2", document
				.getDuplicateSentences().get(0));
	}

	@Test
	public void testGetNWordsByfrequency() {
		assertEquals(1, document.getNWordsByfrequency(1).size());
		assertEquals("\nWord = are\nFrequency = 4", document
				.getNWordsByfrequency(1).get(0));

		assertEquals(4, document.getNWordsByfrequency(2).size());
		assertTrue(document.getNWordsByfrequency(2).contains(
				"\nWord = hi\nFrequency = 3"));
	}

}
