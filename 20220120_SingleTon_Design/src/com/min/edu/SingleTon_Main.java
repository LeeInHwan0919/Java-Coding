package com.min.edu;

public class SingleTon_Main {

	public static void main(String[] args) {

		// SingleFactory의 기능을 사용하기 위해서 객체를 생성
//		SingleFactory s1 = new SingleFactory();
//		SingleFactory s2 = new SingleFactory();

		// 1) SingleFactory의 default 생성자를 외부에서 접근하지 못하도록 private선언한다.

		SingleFactory s1 = SingleFactory.getInstance();
		SingleFactory s2 = SingleFactory.getInstance();
		System.out.println("s1의 해쉬코드 :" + s1.hashCode());
		System.out.println("s2의 해쉬코드 :" + s2.hashCode());
	}

}
