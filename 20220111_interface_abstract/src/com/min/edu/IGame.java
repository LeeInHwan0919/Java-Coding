package com.min.edu;

public interface IGame {

	public int age = 100;// 기울어진거 static final쓰는거, 상수는 자동으로 public
//		private int num = 200;  // implements는 강제로 다른 자식클래스의 구현체가 되어야한다. => private접근 제한자는 사용이 불가하다.
	String name = "또치";
//		protected String address = "서울시";  // 당연히 자식클래스만 사용하기 때문에 굳이 protected 사용하지 않는다.

	// 추상메소드의 집합체
	// 추상메소드 란? 메소드 중에서 {} (<- 구현) 이 없는 메소드, 선언되어 있는 메소드
	public String makeA();

	String makeB();

	default void print(String a) { //디폴트 메서드 인터페이스 안에서만 존재
		System.out.println("interface 메소드 : " + a);
	}

	public void printConf();

}
