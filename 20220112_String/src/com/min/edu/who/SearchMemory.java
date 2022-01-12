package com.min.edu.who;

public class SearchMemory {

	public static void main(String[] args) {

		// String Override된 hashcode
		// String new의 Override 된 hashcode
		// new의 hashcode
		// 추적으로 정확한 SP를 사용함 비교

		String str1 = "Rainbow"; // SP에 생성됨
		System.out.println("SP의 Rainbow hashcode : " + str1.hashCode());
		System.out.println("SP의 Rainbow의 override 되기 전의 hashcode : " + System.identityHashCode(str1));
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");

		String str2 = new String("Rainbow");
		System.out.println("SP의 Rainbow hashcode : " + str2.hashCode());
		System.out.println("SP의 Rainbow의 override 되기 전의 hashcode : " + System.identityHashCode(str2));

		String str3 = "Rainbow";
		System.out.println(str1.toString() == str2.toString());
		System.out.println(str2.toString() == str3.toString());

		// 값을 비교할 때 SP에서 비교를 한다면

		// str2 new로 만들어 heap에 있는 객체
		// str1 SP에 있는 객체
		System.out.println(System.identityHashCode(str1.intern()));
		System.out.println(System.identityHashCode(str2.intern()));
		System.out.println(str1.intern() == str2.intern());
	}

}
