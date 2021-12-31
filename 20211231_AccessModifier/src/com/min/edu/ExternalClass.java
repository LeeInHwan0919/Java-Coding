package com.min.edu;

//TODO 003. MyClass를 외부에서 접근 테스트
public class ExternalClass {

	//TODO 004. 외부에서 MyClass를 접근하기 위해서 반드시 객체를 생성해야 하고(new MyClass())
	//			접근할 수 있는 외부에서 MyClass의 메소드는 public, default, protected 이다.
	public void exMyClass() {
		MyClass m = new MyClass();
		m.publicMethod();
		m.defaultMethod();
		m.protectedMethod();
//		m.privateMethod();
	}
	
}
