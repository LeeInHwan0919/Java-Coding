package com.min.edu;
public class StaticMain {
	
	public static void main(String[] args) {
//TODO 001. static으로 선언된 메소드는 객체를 생성(new)를 하지 않아도 사용이 가능하다.
//			속해 있는 클래스명.메소드() 로 사용한다.
		StaticIncludeClass.makeA();

//TODO 002. non-static 메소드는 new를 통해 속해 있는 클래스의 객체를 생성 후 사용한다.
//			A a = new A();
//			a.메소드();
		StaticIncludeClass sc = new StaticIncludeClass();
		sc.makeB();
	}
	
}
