package com.lih.edu;

public class Int_LengthMain {

	public static void main(String[] args) {
		
		Length_Test.mathCasting();	//수학점 함수 사용
		
		int cnt = Length_Test.count_digit(12345);  // 루프문을 사용
		System.out.println("루프를 사용하여 정수의 길이 계산 : " + cnt);

		Length_Test.count_digits(12345);  // toString 함수 사용

	}

}
