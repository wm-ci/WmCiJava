/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wmci.assertion.Eval;
import com.wmci.assertion.Result;
import com.wmci.util.Util;

/**
 * @author cecheverria
 *
 */
public class EvalUnitTest {
	
	private Result result = null;
	
	public EvalUnitTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		result = new Result();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		result = null;
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#equal(String, String)}.
	 */	@Test
	public final void testEqual() {
		String input = "Hello, how are you today friend..?";
		
		//Null value test case
		result = Eval.equal(input, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null value test case
		result = Eval.equal(null, input);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null values test case
		result = Eval.equal(null, null);
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.equal(input, "Hello");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.equal(input, "Hell ow");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.equal(input, "today");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.equal(input, "todayX");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.equal(input, input);
		assertTrue(result.getMessage(), result.isSuccess());
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#notEqual(String, String)}.
	 */	@Test
	public final void testNotEqual() {
		String input = "Hello, how are you today friend..?";
		
		//Null value test case
		result = Eval.notEqual(input, null);
		assertTrue(result.getMessage(), result.isSuccess());
		
		//Null value test case
		result = Eval.notEqual(null, input);
		assertTrue(result.getMessage(), result.isSuccess());
		
		//Null values test case
		result = Eval.notEqual(null, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.notEqual(input, "Hello");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.notEqual(input, "Hell ow");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.notEqual(input, "today");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.notEqual(input, "todayX");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.notEqual(input, input);
		assertFalse(result.getMessage(), result.isSuccess());
	}

	/**
	 * Test method for {@link com.wmci.assertion.Eval#contains(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testContains() {
		String input = "Hello, how are you today friend..?";
		
		//Null value test case
		result = Eval.contains(input, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null value test case
		result = Eval.contains(null, input);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null values test case
		result = Eval.contains(null, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.contains(input, "Hello");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.contains(input, "Hell ow");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.contains(input, "today");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.contains(input, "todayX");
		assertFalse(result.getMessage(), result.isSuccess());
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#notContains(String, String)}.
	 */	@Test
	public final void testNotContains() {
		String input = "Hello, how are you today friend..?";
		
		//Null value test case
		result = Eval.contains(input, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null value test case
		result = Eval.contains(null, input);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null values test case
		result = Eval.contains(null, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.notContains(input, "Hello");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.notContains(input, "Hell ow");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.notContains(input, "today");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.notContains(input, "todayX");
		assertTrue(result.getMessage(), result.isSuccess());
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#decode(String, String, String[], String)}.
	 */	@Test
	public final void testDecode() {
		String[] conditions = Util.buildPairConditionsArray(""
															+ "1,one,"
															+ "2,two,"
															+ "3,three,"
															+ ",empty,"
															+ "{null},null value,"
															+ "null value,{null},"
															+ "{null},{null}"
															+ "");
		
		result = Eval.decode("1", "one", conditions);
		assertTrue("Case decode-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("2", "two", conditions);
		assertTrue("Case decode-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("3", "three", conditions);
		assertTrue("Case decode-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("", "empty", conditions);
		assertTrue("Case decode-004: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode(null, "empty", conditions);
		assertFalse("Case decode-005: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("", null, conditions);
		assertFalse("Case decode-006: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode(null, "", conditions);
		assertFalse("Case decode-007: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("null value", null, conditions);
		assertTrue("Case decode-009: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode(null, null, conditions);
		assertTrue("Case decode-010: " + result.getMessage(), result.isSuccess());
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#greatThan(String, String)}.
	 */	@Test
	public final void testGreatThan() {
		
		result = Eval.greatThan("1", "2");
		assertFalse("Case greatThan-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThan("2", "2");
		assertFalse("Case greatThan-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThan("3", "2");
		assertTrue("Case greatThan-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThan("1000.01", "1000.02");
		assertFalse("Case greatThan-004: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThan("1000.02", "1000.02");
		assertFalse("Case greatThan-005: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThan("1000.03", "1000.02");
		assertTrue("Case greatThan-006: " + result.getMessage(), result.isSuccess());
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#greatThanEqual(String, String)}.
	 */	@Test
	public final void testGreatThanEqual() {
		
		result = Eval.greatThanEqual("1", "2");
		assertFalse("Case greatThan-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThanEqual("2", "2");
		assertTrue("Case greatThan-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThanEqual("3", "2");
		assertTrue("Case greatThan-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThanEqual("1000.01", "1000.02");
		assertFalse("Case greatThan-004: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThanEqual("1000.02", "1000.02");
		assertTrue("Case greatThan-005: " + result.getMessage(), result.isSuccess());
		
		result = Eval.greatThanEqual("1000.03", "1000.02");
		assertTrue("Case greatThan-006: " + result.getMessage(), result.isSuccess());
	}
	
}
