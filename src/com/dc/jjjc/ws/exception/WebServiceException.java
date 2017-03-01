package com.dc.jjjc.ws.exception;

public class WebServiceException extends Exception {

	private static final long serialVersionUID = 5760140170168221171L;

	private String code;

	public WebServiceException() {
	}

	public WebServiceException(String message) {
		super(message);
	}

	public WebServiceException(String code, String message) {
		this(message);
		this.code = code;
	}

	public WebServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getCode() {
		return code != null ? code : "";
	}

	public void setCode(String code) {
		this.code = code;
	}

}
