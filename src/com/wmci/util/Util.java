/**
 * 
 */
package com.wmci.util;

/**
 * <b>Java back-end</b> to support <b>Utility JavaServices</b> on <b>WebMethods Integration Server</b>
 *  
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
	 * 
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

	/**
	 * A clone from <b>SQL Decode</b> function.
	 * 
	 * @param input				The input parameter
	 * @param conditions		The key-pair conditions to be evaluated
	 * @param defaultValue		The value to be returned in case that input parameter does not match any key-pair condition
	 * @return
	 */
	public static String decode(String input, String[] conditions, String defaultValue) {
		
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
				//Compare when input is send as null 
				match = null == value ? returnValue : null;
			
			i++;
		}
		
		return	match != null ? 
				match : 
				defaultValue //If there are not match on compared values, then return default value
				;
	}
	
	/**
	 * Evaluates if input parameter can be returned as it, otherwise it will be returned as null. 
	 * 
	 * This back-end will easy the work doing mappings on <b>Integration Server</b>, when you want to 
	 * map an object only if exist and contains a value different than empty. In that way <b>you will
	 * be able to avoid doing branches</b> to ask for an object and then mapping if it exists.
	 * 
	 * @param input		The input parameter
	 * @return
	 */
	public static String doNotMapNullOrBlanks(String input) {
		
		return input != null && !input.trim().equals("") ? input.trim() : null;
	}

	/**
	 * Build an string array to hold pair conditions like you does on <b>SQL Decode</b> function.
	 * 
	 * @param input		The input parameter
	 * @return
	 */
	public static String[] buildPairConditionsArray(String input) {

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
		
		return  array;
	}
}	
