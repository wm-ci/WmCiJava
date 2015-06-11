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
public class UtilUnitTest {
	
	private boolean treatEmptyAsNullYes = true;
	private boolean treatEmptyAsNullNo = false;
	
	private String input = "Hello, how are you today friend..?";
	private String empty = "";
	private String manySpaces = "   ";
	private String inputIsNull = "Input parameter is null";
	private String inputIsEmpty = "Input parameter is empty";
	private String inputIsManySpaces = "Input parameter is many spaces";
	
	public UtilUnitTest() {
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
		assertEquals("Case nvl-001: Input is null, return value must be (defaultValue = " + inputIsNull + ")", Util.nvl(null, inputIsNull, treatEmptyAsNullNo), inputIsNull);
		assertEquals("Case nvl-002: Input is empty, treatEmptyAsNull=false", Util.nvl(empty, inputIsEmpty, treatEmptyAsNullNo), empty);
		assertEquals("Case nvl-003: Input is empty, treatEmptyAsNull=true", Util.nvl(empty, inputIsEmpty, treatEmptyAsNullYes), inputIsEmpty);
		assertEquals("Case nvl-004: Input is manySpaces, treatEmptyAsNull=false", Util.nvl(manySpaces, inputIsEmpty, treatEmptyAsNullNo), manySpaces);
		assertEquals("Case nvl-005: Input is manySpaces, treatEmptyAsNull=true", Util.nvl(manySpaces, inputIsEmpty, treatEmptyAsNullYes), inputIsEmpty);
	}
	
	/**
	 * Test method for {@link com.wmci.util.Util#decode(String, String[], String)}.
	 */
	@Test
	public final void testDecode() {
		String result = null;
		
		result = Util.decode(null, new String[]{"",""}, inputIsNull);
		assertEquals("Case decode-001: Input is null, not matching condition, return value must be (defaultValue = " + inputIsNull + ")", result, inputIsNull);
		
		result = Util.decode(null, new String[]{null,empty}, inputIsNull);
		assertEquals("Case decode-002: Input is null, matching condition, return value must be (returnValue = \"\")", result, empty);
		
		result = Util.decode(null, new String[]{empty,inputIsEmpty, null}, inputIsNull);
		assertEquals("Case decode-003: Input is null, not matching condition, return value must be (defaultValue = " + inputIsNull + ")", result, inputIsNull);
		
		result = Util.decode(null, new String[]{empty,inputIsEmpty, null,inputIsNull}, empty);
		assertEquals("Case decode-004: Input is null, matching condition, return value must be (returnValue = " + inputIsNull + ")", result, inputIsNull);
		
		result = Util.decode(null, new String[]{empty,inputIsEmpty, manySpaces,inputIsManySpaces, null,inputIsNull}, empty);
		assertEquals("Case decode-005: Input is null, matching condition, return value must be (returnValue = " + inputIsNull + ")", result, inputIsNull);
		
		result = Util.decode(empty, new String[]{empty,inputIsEmpty, manySpaces,inputIsManySpaces, null,inputIsNull}, empty);
		assertEquals("Case decode-006: Input is empty, matching condition, return value must be (returnValue = " + inputIsEmpty + ")", result, inputIsEmpty);
	}
	
	/**
	 * Test method for {@link com.wmci.util.Util#ddoNotMapNullOrBlanks(String)}.
	 */
	@Test
	public final void testDdoNotMapNullOrBlanks() {
		String result = null;
		
		result = Util.doNotMapNullOrBlanks(null);
		assertEquals("Case doNotMapNullOrBlank-001: Input is null, it must not be mapped", result, null);
		
		result = Util.doNotMapNullOrBlanks(empty);
		assertEquals("Case doNotMapNullOrBlank-002: Input is empty, it must not be mapped", result, null);
		
		result = Util.doNotMapNullOrBlanks(manySpaces);
		assertEquals("Case doNotMapNullOrBlank-003: Input is manySpaces, it must not be mapped", result, null);
		
		result = Util.doNotMapNullOrBlanks(input);
		assertEquals("Case doNotMapNullOrBlank-004: Input has a correct value, it must be mapped", result, input);
	}
	
	/**
	 * Test method for {@link com.wmci.util.Util#buildPairConditionsArray(String)}.
	 */
	@Test
	public final void testBuildPairConditionsArray() {
		String[] result;
		
		result = Util.buildPairConditionsArray("one,r_one,two,r_two,{null}, is null,");
		
		assertEquals("Case testBuildPairConditionsArray-001: Input is null, it must not be mapped", result[0], "one");
		assertEquals("Case testBuildPairConditionsArray-002: Input is null, it must not be mapped", result[1], "r_one");
		assertEquals("Case testBuildPairConditionsArray-003: Input is null, it must not be mapped", result[4], null);
		assertEquals("Case testBuildPairConditionsArray-003: Input is null, it must not be mapped", result[5], " is null");

	}
}
