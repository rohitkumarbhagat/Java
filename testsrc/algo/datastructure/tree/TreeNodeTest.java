package algo.datastructure.tree;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeNodeTest  {
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside setup");
	}

	@After
	public void tearDown() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside teardown");
	}

	@BeforeClass
	public static void beforeAllTest() {
		System.out.println("inside before all Test case");
	}

	@AfterClass
	public static void afterAllTest() {
		System.out.println("inside after all Test case");
	}

	@Test
	public void testEqualsObject() {
		TreeNode abc=new TreeNode();
		abc.setData(5);
		assertTrue(abc.equals(new TreeNode(5,null,null)));
		assertEquals(abc, new TreeNode(5,null,null));
		assertEquals(abc,null);
		assertSame(abc, new TreeNode(5,null,null));
		//assertEquals(abc.same(), null); 
		
	}

	@Test
	public void testEObject() {
		assertTrue(true);
	}

}
