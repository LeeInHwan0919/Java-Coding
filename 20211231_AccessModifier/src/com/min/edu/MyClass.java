package com.min.edu;
//TODO 001. 외부에서 접근을 할 수 있는 종류 (public, default, protected, private)을 선언한 클래스
public class MyClass {

	public void publicMethod() {
		System.out.println("public method");
	}
	
	void defaultMethod() {
		System.out.println("default method");
	}
	
	protected void protectedMethod() {
		System.out.println("protected method");
	}
	
	private void privateMethod() {
		System.out.println("private method");
	}
	
	//TODO 002. 같은 클래스 내에서 사용할 수 있는 접근 제한자는?
	//			같은 클래스 이기 떄문에 생성(new) 를 하지 않아도 된다.
	//			같은 클래스에 있는 메소드는 접근제한자와 상관없이 호출이 가능하다.
	public void accessTest() {
		publicMethod();
		defaultMethod();
		protectedMethod();
		privateMethod();
	}
	
	
	
}
