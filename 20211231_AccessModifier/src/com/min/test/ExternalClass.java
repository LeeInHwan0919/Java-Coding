package com.min.test;

import com.min.edu.MyClass;

//TODO 005. 외부 물리적인 구분인 package에서 MyClass를 생성하고 메소드를 호출
public class ExternalClass {

	//TODO 006. 외부 물리적인 구분(package)가 다른 곳에서 new를 하여 생성하여도 public만 사용이 가능하다.
	public void exTest() {
		MyClass m = new MyClass();
		m.publicMethod();
//		m.defaultMethod();
//		m.protectedMethod();
//		m.privateMethod();
	}
	
}
