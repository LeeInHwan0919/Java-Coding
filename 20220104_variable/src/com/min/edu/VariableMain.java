package com.min.edu;

public class VariableMain {

	/*
	 * 변수는 static, instance, local
	 */
	public static void main(String[] args) {

		Dto d = new Dto();
		d.name = "도우너";
		d.hobby = "바이올린";
		Dto.etc = "기타";//static
		
		d.make(100);
		
	}//main

}//class
