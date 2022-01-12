package com.min.edu.dto;

public class InfoMain {
	public static void main(String[] args) {
		InfoDto info1 = new InfoDto("한국", 100, "서울");
		InfoDto info2 = new InfoDto("한국", 100, "서울");
		// info1과 info2는 같은 값을 가지고 있는 서로 다른 객체가 됨

		boolean name = info1.getName() == info2.getName();
		boolean age = info1.getAge() == info2.getAge();
		boolean address = info1.getAddress() == info2.getAddress();

		System.out.println(name & age & address);

		System.out.println("info1 hashcode : " + info1.hashCode());
		System.out.println("info2 hashcode : " + info2.hashCode());

		System.out.println(" 같은 값을 가지고 있는 객체도 판단이 가능함 : " + info1.equals(info2));
		// == 비교 하면 참조타입은 reference 객체를 비교 할때는 쓰지 말아라
		// 객체는 java.lang.Object.equals(object)맞기도 하고 다르기도 하고
		// hashcode 명화갛게는 자신의 객체 비교

	}
}
