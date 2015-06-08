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
	
	
	
	
	
	
	
	
	
	
	
}
