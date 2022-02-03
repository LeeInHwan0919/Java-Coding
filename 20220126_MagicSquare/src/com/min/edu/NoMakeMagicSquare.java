package com.min.edu;

public class NoMakeMagicSquare extends Exception {
	private static final long serialVersionUID= -479437574;
	
	public NoMakeMagicSquare() {
		this("입력한 숫자는 마방진이 될 수 없습니다.");
	}
	
	public NoMakeMagicSquare(String message) {
		super(message);
	}
}
