package com.min.edu.compare;

public class StringCompare {
	public static void main(String[] args) {
		String str1 = "Happy";
		String str2 = str1;
		String str3 = "Happy";
		String str4 = new String("Happy");

		String str5 = "Hap" + "py"; // 리터럴과 같은 연산	//	연산이 끝날때 값으로 만들어 짐
		String tmp1 = "Hap";
		String tmp2 = "py";
		String str6 = tmp1 + tmp2;// consatenation
		System.out.println(str6);

		System.out.println("생성과 vs 연산이 같은지 확인하고싶다. : " + (str1 == str5));
		System.out.println("생성 vs concate : "+ str1 == str6); 	//concate는 연산이기 때문에 new한것과 같음

		System.out.println("생성 vs new 객체" + (str1 == str4));
		System.out.println("생성 vs 대입" + (str1 == str2)); // immutable 한가?
		System.out.println("생성 vs 생성" + (str1 == str3));

//		System.out.println(str1.hashCode());
//		System.out.println(str2.hashCode());
//		System.out.println(str3.hashCode());
//		System.out.println(str4.hashCode());

//		System.out.println(str1.getClass());
//		System.out.println(str2.getClass());
//		System.out.println(str3.getClass());
//		System.out.println(str4.getClass());
	}
}
