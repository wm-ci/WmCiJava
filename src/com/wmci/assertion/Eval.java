/**
 * 
 */
package com.wmci.assertion;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wmci.util.Util;

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
	 * Assert if <b>compared</b> value <b>maches</b> to <b>input</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be matched to input
	 * @return
	 */
	public static Result matches(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			Pattern pattern = Pattern.compile(compare);		//Regex
			Matcher matcher = pattern.matcher(input);		//Input
			
			result.setSuccess(matcher.matches());
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] does not matches input[" + input + "]");
			
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

	/**
	 * A clone from <b>SQL Decode</b> function. But in this case, the function Asserts 
	 * if <b>input</b> value <b>compared</b> value are contained into <b>conditions</b> 
	 * array parameter
	 * 
	 * @param input			The input parameter
	 * @param compare		The string to be search into input
	 * @param conditions	The key-pair conditions to be evaluated
	 * @return
	 */
	public static Result decode(String input, String compare, String[] conditions) {
		
		Result result = new Result(null, false);
		
		try {
			boolean match = false;
			int totalComparations = conditions.length/2,
				i = 0;		
			
			while (!match && i < totalComparations) { 
				String value = conditions[i*2+0];
				String returnValue = conditions[i*2+1];
				
				match = ((input == null && value == null) && (compare == null && returnValue == null)) 
						|| 
						(input == null && value == null) && (compare != null && compare.equals(returnValue))
						|| 
						((input != null && input.equals(value)) && (compare != null && compare.equals(returnValue)))
						|| 
						((input != null && input.equals(value)) && (compare == null && returnValue == null))
						;
				i++;
			}
			
			result.setSuccess(match);
			result.setMessage(result.isSuccess() ? null : "Key-pair parameters [" + input + "][" + compare + "] is not present on conditions array");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>input</b> value is <b>great than</b> to <b>compare</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be compared to input parameter
	 * @return
	 */
	public static Result greatThan(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(
					input==null || compare==null 
					? false
					: (new BigDecimal(input)).compareTo(new BigDecimal(compare)) == 1
					);
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is not great than input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>input</b> value is <b>great than or equals</b> to <b>compare</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be compared to input parameter
	 * @return
	 */
	public static Result greatThanEqual(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(
					input==null || compare==null 
					? false
					: (new BigDecimal(input)).compareTo(new BigDecimal(compare)) >= 0
					);
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is not great than or equals to input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>input</b> value is <b>null</b>.
	 * @param input		The input parameter
	 * @return
	 */
	public static Result isNull(String input) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(input==null);
			result.setMessage(result.isSuccess() ? null : "Input parameter [" + input + "] is not null");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>input</b> value is not <b>null</b>.
	 * @param input		The input parameter
	 * @return
	 */
	public static Result isNotNull(String input) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(input!=null);
			result.setMessage(result.isSuccess() ? null : "Input parameter [" + input + "] is null");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>input</b> value is <b>less than</b> to <b>compare</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be compared to input parameter
	 * @return
	 */
	public static Result lessThan(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(
					input==null || compare==null 
					? false
					: (new BigDecimal(input)).compareTo(new BigDecimal(compare)) == -1
					);
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is not less than input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}
	
	/**
	 * Assert if <b>input</b> value is <b>less than or equals</b> to <b>compare</b> parameter.
	 * @param input		The input parameter
	 * @param compare	The string to be compared to input parameter
	 * @return
	 */
	public static Result lessThanEqual(String input, String compare) {
		
		Result result = new Result(null, false);
		
		try {
			result.setSuccess(
					input==null || compare==null 
					? false
					: (new BigDecimal(input)).compareTo(new BigDecimal(compare)) <= 0
					);
			result.setMessage(result.isSuccess() ? null : "Compare parameter [" + compare + "] is not less than or equals to input[" + input + "]");
			
		} catch (Exception e) {
			result.setMessage("Exception evaluating input [" + input + "] and compare [" + compare + "]");
		}
		
		return result;
	}	
}
