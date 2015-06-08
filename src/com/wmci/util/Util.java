/**
 * 
 */
package com.wmci.util;

/**
 * @author cecheverria
 *
 */
public class Util {

	/**
	 * 
	 */
	public Util() {
	}
	
	/**
	 * A clone from <b>SQL Nvl</b> function.
	 * @param input				The input parameter
	 * @param defaultValue		The value to be returned in case that input parameters is considered null
	 * @param treatEmptyAsNull	Set as true if you want to treat the Empty values as a null values.
	 * @return
	 */
	public static String nvl(String input, String defaultValue, boolean treatEmptyAsNull) {
		
		return	input == null ?
				defaultValue :
				treatEmptyAsNull && input.trim().equals("") ?
				defaultValue : 
				input
				;
	}
}	
