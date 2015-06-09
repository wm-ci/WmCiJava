/**
 * 
 */
package com.wmci.assertion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cecheverria
 *
 */
public class Eval {

	/**
	 * 
	 */
	public Eval() {
		
	}
	
	/**
	 * Assert if <b>compared</b> value is <b>equal</b> to <b>input</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be compared to input
	 * @return
	 */
	public static Result equal(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(
					  input == null && compare == null
					? true
					: input == null || compare == null
					? false
					: input.equals(compare)
					);
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is not equal to input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>compared</b> value is <b>not equal</b> to <b>input</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be compared to input
	 * @return
	 */
	public static Result notEqual(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(
					  input == null && compare == null
					? true
					: input == null || compare == null
					? false
					: input.equals(compare)
					);
			result.setSuccess(!result.isSuccess());
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is equal to input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>compared</b> value is <b>contained</b> into <b>input</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be search into input
	 * @return
	 */
	public static Result contains(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			Pattern pattern = Pattern.compile(compare);		//Regex
			Matcher matcher = pattern.matcher(input);		//Input
			
			result.setSuccess(matcher.find());
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is not containde on input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>compared</b> value is <b>not contained</b> into <b>input</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be search into input
	 * @return
	 */
	public static Result notContains(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			Pattern pattern = Pattern.compile(compare);		//Regex
			Matcher matcher = pattern.matcher(input);		//Input
			
			result.setSuccess(!matcher.find());
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is containde on input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}




}
