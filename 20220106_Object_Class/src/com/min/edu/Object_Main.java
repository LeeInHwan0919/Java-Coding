package com.min.edu;

public class Object_Main {

	public static void main(String[] args) {
		// 객체의 생성(instance화)
		// 같은 멤버필드의 값을 가지고 있는 서로 다른 객체가됨.
		UserDefineClass u1 = new UserDefineClass();
		UserDefineClass u2 = new UserDefineClass();

		// getClass 를 통해서 구성된 설계도의 위치를 확인하자
		System.out.println(u1.getClass());
		System.out.println(u2.getClass());

		// 각자의 메모리에 있는 고유값을 확인해 보자
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());

		// 객체를 표출
		System.out.println(u1);
		String info = u2.toString();
		System.out.println(info);

		// a.equals(b);
		// 1) a와 b가 같은 타입으로 되어 있어야 함
		// 2) b는 null 이 아니어야 하고
		// 3) b는 a의 타입으로 변경이 되어야 함.
		// 객체의 다름/ 비교
		// boolean isc1 = (u1 == u2);
		int a = 10;
		int b = a;
		System.out.println(a == b);

		UserDefineClass u3 = new UserDefineClass();
		UserDefineClass u4 = u3;
		System.out.println(u3 == u4);
		System.out.println(u3.equals(u4));

		boolean isc1 = (u1 == u2);// 같은 값을 가지고 있음. new 통해서 다른객체
		System.out.println(isc1);
		boolean isc2 = (u1.equals(u2));
		System.out.println(isc2);

		String str1 = "커피";
		String str2 = new String("커피");
		String str3 = str1;

		String str4 = "커피";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());

		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str4);
	}

}
