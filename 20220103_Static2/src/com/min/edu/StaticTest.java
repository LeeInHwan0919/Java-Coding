package com.min.edu;

//TODO 002
/*
 * @author 이인환
 * static 으로 선언된 메소드와 <br>
 * 멤버필드를 작성한 클래스
 */
public class StaticTest {
	public void generalMethod() {
		
		//TODO 003 non-static 에서 static 호출 : O 된다.
		//			non-static에서는 non-static 호출 : O 된다.
		staticMethod();
		nonStaticMethod();
	}
	
	public void nonStaticMethod() {
		
	}
	
	public static void staticMethod() {
		//TODO 004 static 에서 non-static 호출 : X 안된다.
//		generalMethod();
	}
}
