package com.min.edu;

public class ExamMain {

	public static void main(String[] args) {
		Exam e = new Exam();
		
//		ExamMain e = new ExamMain(); // non static
//		e.print();						얘도
		print(); // static 할 때
		//e.charmumTointNum1();
		//e.charnumTointNum2();
		//e.charTointToChar();
		//e.charToInt();
		e.intToChar();
		
		//우리가 만든 문자형 숫자를 정수(int)로 만들어 주는 메소드
		char c = '3';
		int a = MakeGetNumericValue.getNumericValue(c);
		String result = (a==777)? "숫자아님":String.valueOf(a) ;
		//System.out.println(result);
	}
	
	public static void print() {
		//System.out.println("출력");
	}

}
