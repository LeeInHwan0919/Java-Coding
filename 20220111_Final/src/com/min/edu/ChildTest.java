package com.min.edu;

public class ChildTest extends FinalClass {// final은 extends가 금지 된다~~

	@Override
	public String callMethod() { // 부모것은 무조건 오버라이드가 된다!!~

		return "오버라이드 반환";
	}
	
//	private  int calMethod() { // 만들어지지 않는다 오버라이드도 아니고 오버로딩도 아니고 
//		return 0;
//	}
	
	private  int calMethod(int n) { // 오버로드 이다.
		return 0;
	}

}