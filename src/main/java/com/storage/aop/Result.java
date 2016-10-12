package com.storage.aop;

/**
 * Use this Class to wrap the return data
 * 
 * @author terry.yao
 *
 */
public class Result {
	private String errorMessage;

	private int errorCode;

	private Object response;

	public Result() {

	}

	public Result(int errorCode, String errorMessage, Object response) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.response = response;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
