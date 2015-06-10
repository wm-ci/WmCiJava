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
	 * @param defaultValue		The value to be returned in case that input parameter is considered null
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

	public static String doNotMapNullOrBlanks(String input) {

		/*if(input != null && !input.trim().equals(""))
			return input.trim();
		else 
			return null;*/

		resturn input != null && !input.trim().equals("") ? input.trim() : null;
	}

	public static String decode(String input, String conditions, String defaultValue) {

			//Main logic 
		String match = null;
		int totalComparations = conditions.length/2,
			i = 0;		
		
		while (match == null && i < totalComparations) {
			String value = conditions[i*2+0];
			String returnValue = conditions[i*2+1];
			
			if(input != null) {
				//System.out.printf("value[%s] - compare[%s] - [%s]\n", value, returnValue, (input.equals(value)));
								
				match = input.equals(value) ? returnValue : null;
			}
			else
				match = input == value ? returnValue : null;
			
			i++;
		}
		
		//Return value
		return	match != null ? 
				match : 
				defaultValue //If there are not match on compared values, then return elseValue
				;
	}

	public static String buildPairConditionsArray(String input) {

		//Main logic 
		String[] array = {},
				 tmp = input == null || input.trim().equals("") ?
					   new String[]{} :
					   input.split(",")
				;
		array = new String[tmp.length];
		
		for (int i = 0; i < tmp.length; i++) {
			String item = tmp[i];
			array[i] = item.equals("{null}") ? null : item;
		}
		
		//Return value
		return  array;
	}
}	
