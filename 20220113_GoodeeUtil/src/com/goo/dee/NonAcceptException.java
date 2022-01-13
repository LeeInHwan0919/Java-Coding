package com.goo.dee;

public class NonAcceptException extends Exception {

	private static final long serialVersionUID = 8664916767800609630L;

	/**
	 * default 메시지 전달
	 */
	public NonAcceptException() {
		this("수업에서 허용하지 않는 예외가 발생함");
	}

	/**
	 * 사용자 처리 메시지 전달
	 * @param message 사용자 메시지
	 */
	public NonAcceptException(String message) {
		super(message);
	}
	

}
