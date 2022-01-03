package com.min.edu1;

public class CharTestMain {

	public static void main(String[] args) {
		// char 문자형 => 문자열 String
		// char 정수, 값, 리터럴
		
		char a = 'a';
		System.out.println("a의 값"+a);
		System.out.println("a의 정수 값"+(int)a);
		
		char aCov = 97;
		System.out.println(aCov);
		System.out.println(aCov +1);
		int cal = aCov+1;
		char cCov = (char)cal; 
		System.out.println(cCov);
		
		char numOne = '1';
		//보이는 그대로 정수로 변경하는것.
		System.out.println(numOne);
		
		int oneInt = numOne;
		System.out.println("숫자1의 int값 : " + oneInt);
		System.out.println("char 1을 정수 1로 변경한 값 : " + (oneInt-48));
		
		
		int convert = Character.getNumericValue(oneInt);
		System.out.println(convert);
		System.out.println(Character.getNumericValue('!'));
		
		//리터럴
		int n = 97;
		String str = Integer.toHexString(n);
		System.out.println("hex 값 : " + str);
		char nine_Seven = '\u0061';
		System.out.println(nine_Seven);
		
		//chart 타입의 100번 인덱스까지 출력해 보자
	}

}
