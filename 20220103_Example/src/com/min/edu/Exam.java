package com.min.edu;

public class Exam {
	
	public void charmumTointNum1() {// char 숫자를 int숫자로 변경해주십쇼
		//char는 3개의 리터럴 값을 가지고 있다
		//char는 int 값은 Unicode표의 index값이다.
		char c = '9'; //값은 9지만 찾기 위해서는 16진수의 unicode index값을 알고 있어야된다.
		int nine = c;//char에 int변환값의 크기는 int이다.
		System.out.println("char9는 "+nine+"이다");
	
		//원래 보이는 char모양 그대로 숫자로 변경하고 싶다
		//우리는 계산하지 않는다. 만들어 놓은거 쓴다
		//문자형을 바꾸는거다 => Character 사용
		int n = Character.getNumericValue(c);
		System.out.println(n);
		System.out.println((int)'0');
		System.out.println((int)'9');
	}

	public void charnumTointNum2() {
		// '9'-'0'
		int n = '9';
		int m = '0';
		
		int result = n-m;//59-48
		System.out.println(result);
		System.out.println((char)result);
		int result2 = m-n;//48-59
		System.out.println(Math.abs(result2));
		int result3 = (result2<0)?result2:result2*-1;
		System.out.println(result3);
	}

	public void charTointToChar() {
		// (char)('A'+2)->'C'
		char A = 'A';
		System.out.println((int)A);
		char C = 'C';
		System.out.println((int)C);
		
		int n = 65 + 2;
		char nc = (char)n;
		System.out.println(nc);
		
		for (int i = 0; i < 100; i++) {
			System.out.println(i + "값 / " + (char)i);
		}
		
		
	}

	public void charToInt() {
		// 'A' -> 65
		char c = 'A';
		int i = c;
		int result = c+0;
		System.out.println(result);
	}

	public void intToChar() {
		// int->char 캐스팅사용
		int a = 100;
		//char는 리터럴 값은 변경없이 사용 할 수 있지만
		//담겨 있는 값( 선언된 값) 반드시 캐스팅을 해야 한다.
		char c = 100;
		char ca = (char)a;
		System.out.println(c);
		System.out.println(ca);
		
	}

}
