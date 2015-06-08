/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wmci.assertion.Eval;
import com.wmci.util.Util;

/**
 * @author cecheverria
 *
 */
public class UtilTest {
	
	private boolean treatEmptyAsNullYes = true;
	private boolean treatEmptyAsNullNo = false;
	
	public UtilTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.wmci.util.Util#nvl(java.lang.String, java.lang.String, boolean)}.
	 */
	@Test
	public final void testNvl() {
		String input = "Hello, how are you today friend..?";
		String empty = "";
		String manySpaces = "   ";
		String inputIsNull = "Input parameter is null";
		String inputIsEmpty = "Input parameter is empty";
		
		//Null value test case
		assertEquals("Case 001: Input is null, return value must be (defaultValue = " + inputIsNull + ")", Util.nvl(null, inputIsNull, treatEmptyAsNullNo), inputIsNull);
		assertEquals("Case 002: Input is empty, treatEmptyAsNull=false", Util.nvl(empty, inputIsEmpty, treatEmptyAsNullNo), empty);
		assertEquals("Case 003: Input is empty, treatEmptyAsNull=true", Util.nvl(empty, inputIsEmpty, treatEmptyAsNullYes), inputIsEmpty);
		assertEquals("Case 004: Input is manySpaces, treatEmptyAsNull=false", Util.nvl(manySpaces, inputIsEmpty, treatEmptyAsNullNo), manySpaces);
		assertEquals("Case 005: Input is manySpaces, treatEmptyAsNull=true", Util.nvl(manySpaces, inputIsEmpty, treatEmptyAsNullYes), inputIsEmpty);
		
	}
}
