package com.min.test;

import com.min.edu.MyClass;

//TODO 008. 다른패키지에서 extends되면
//			패키지가 다르면 사용할 수 없는 default는 접근이 되지 않고, public , protected만 가능하다.

public class ChildClass extends MyClass{

	public void test() {
		publicMethod();
//		defaultMethod();
		protectedMethod();
//		privateMethod();
	}
}
