package com.min.edu;

public class StaticIncludeClass {

	public static void makeA() {
	//makeA에서 makeB를 쓸 수가 없다. makeA()는 static으로 인해 메모리가 올라가있는 상태이기 떄문이다.
	//makeB(); // static영역이 아니며, 언제 메모리에 할당될지 모르기때문에 사용이 불가능하다.
	}
	
	public void makeB() {
		makeA();
	}

	
//잘못된 코드이다. 내부에서 생성만 되어있고 외부에서 쓸 수가 없다. 메모리만 잡아먹는 쓰레기메소드
	private static void makeEtc() {
		//마찬가지 스태틱
	}
	
}
