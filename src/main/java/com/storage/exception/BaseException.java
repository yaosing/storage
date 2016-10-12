package com.storage.exception;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int errorCode = -1;

	private String errorMessage = "Unknown error.";

	private String data;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AwesException [errorCode=" + errorCode + ", "
				+ (errorMessage != null ? "errorMessage=" + errorMessage + ", " : "")
				+ (data != null ? "data=" + data : "") + "]";
	}
}
