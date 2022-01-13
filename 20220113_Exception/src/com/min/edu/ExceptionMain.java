package com.min.edu;

public class ExceptionMain {

	public static void main(String[] args) {
		ExceptionMethod ex = new ExceptionMethod();
		try {
			ex.calculation();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
