package com.min.edu;

//TODO 007. Extends를 통해 특정 글래스를 확장 할 수 있다. 특징을 그대로 물려받는다.
//			메소드는 private를 제외한 모든 메소드를 접근 할 수 있다.
//			같은 패키지의 extends된 부모의 메소드를 public default protected를 사용할 수 있다.
public class ExternalChildClass extends MyClass{
	
	public void test() {
		publicMethod();
		defaultMethod();
		protectedMethod();
//		privateMethod();
	}
	
}
