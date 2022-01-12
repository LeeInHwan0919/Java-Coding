package com.min.edu;

public class Concat_Main {
	public static void main(String[] args) {
		//  concatenation은 연쇄 문자열이 + 연산을 통해서 문자열로 합쳐지는 과정
		//  사용 을 많이 하면 안된다. >> StringBuffer 클래스를 사용해라
		
		int a = 10;
		char c = '0';
		boolean b = true;
		String str = "";
		
		System.out.println(a+c);
//		System.out.println(a+b);  연산의 대상이 되지 않는다.
		String tmp1 = 10+c+(b+str); // concatenation이 발생될 수 없는 문법>> 괄호로 우선순위 변경
		String tmp2 = str + b + c + a;
		System.out.println(tmp2);
		System.out.println(tmp1);
	}
}
