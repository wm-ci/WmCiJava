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
	 * Test method for {@link com.wmci.assertion.Eval#matches(String, String)}.
	 */
	@Test
	public final void testMatches() {
		String input = "Hello, how are you today friend..?";
		
		//Null value test case
		result = Eval.matches(input, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null value test case
		result = Eval.matches(null, input);
		assertFalse(result.getMessage(), result.isSuccess());
		
		//Null values test case
		result = Eval.matches(null, null);
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.matches(input, ".*Hello.*");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.matches(input, "Hell*how");
		assertFalse(result.getMessage(), result.isSuccess());
		
		result = Eval.matches(input, ".*today.*");
		assertTrue(result.getMessage(), result.isSuccess());
		
		result = Eval.matches(input, "todayX");
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
		String[] keyPairConditions = Util.buildPairConditionsArray(""
															+ "1,one,"
															+ "2,two,"
															+ "3,three,"
															+ ",empty,"
															+ "{null},null value,"
															+ "null value,{null},"
															+ "{null},{null}"
															+ "");
		
		result = Eval.decode("1", "one", keyPairConditions);
		assertTrue("Case decode-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("2", "two", keyPairConditions);
		assertTrue("Case decode-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("3", "three", keyPairConditions);
		assertTrue("Case decode-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("", "empty", keyPairConditions);
		assertTrue("Case decode-004: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode(null, "empty", keyPairConditions);
		assertFalse("Case decode-005: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("", null, keyPairConditions);
		assertFalse("Case decode-006: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode(null, "", keyPairConditions);
		assertFalse("Case decode-007: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode("null value", null, keyPairConditions);
		assertTrue("Case decode-009: " + result.getMessage(), result.isSuccess());
		
		result = Eval.decode(null, null, keyPairConditions);
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
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#isNull(String)}.
	 */	@Test
	public final void testIsNull() {
		
		result = Eval.isNull("1");
		assertFalse("Case isNull-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.isNull("");
		assertFalse("Case isNull-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.isNull(null);
		assertTrue("Case isNull-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.isNull(" ");
		assertFalse("Case isNull-004: " + result.getMessage(), result.isSuccess());
	 }
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#isNotNull(String)}.
	 */	@Test
	public final void testIsNotNull() {
		
		result = Eval.isNotNull("1");
		assertTrue("Case isNotNull-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.isNotNull("");
		assertTrue("Case isNotNull-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.isNotNull(null);
		assertFalse("Case isNotNull-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.isNotNull(" ");
		assertTrue("Case isNotNull-004: " + result.getMessage(), result.isSuccess());
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#lessThan(String, String)}.
	 */	@Test
	public final void testLessThan() {
		
		result = Eval.lessThan("1", "2");
		assertTrue("Case lessThan-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThan("2", "2");
		assertFalse("Case lessThan-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThan("3", "2");
		assertFalse("Case lessThan-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThan("1000.01", "1000.02");
		assertTrue("Case lessThan-004: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThan("1000.02", "1000.02");
		assertFalse("Case lessThan-005: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThan("1000.03", "1000.02");
		assertFalse("Case lessThan-006: " + result.getMessage(), result.isSuccess());
	}
	
	/**
	 * Test method for {@link com.wmci.assertion.Eval#lessThanEqual(String, String)}.
	 */	@Test
	public final void testLessThanEqual() {
		
		result = Eval.lessThanEqual("1", "2");
		assertTrue("Case lessThanEqual-001: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThanEqual("2", "2");
		assertTrue("Case lessThanEqual-002: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThanEqual("3", "2");
		assertFalse("Case lessThanEqual-003: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThanEqual("1000.01", "1000.02");
		assertTrue("Case lessThanEqual-004: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThanEqual("1000.02", "1000.02");
		assertTrue("Case lessThanEqual-005: " + result.getMessage(), result.isSuccess());
		
		result = Eval.lessThanEqual("1000.03", "1000.02");
		assertFalse("Case lessThanEqual-006: " + result.getMessage(), result.isSuccess());
	}
}
