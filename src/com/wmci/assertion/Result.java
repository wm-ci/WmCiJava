/**
 * 
 */
package com.wmci.assertion;

/**
 * @author cecheverria
 *
 */
public class Result {
	
	private String message;
	private boolean success;
	
	/**
	 * 
	 */
	public Result() {
		
	}
	
	/**
	 * @param message
	 * @param success
	 */
	public Result(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
