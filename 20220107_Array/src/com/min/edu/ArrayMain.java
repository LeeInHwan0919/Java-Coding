package com.min.edu;

import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) {
		Shallow_Deep sd = new Shallow_Deep();
		sd.shallow();
		
		sd.deep();

//		int[] arr = new int[3]; // [0, 0, 0]
//		int[] arr = {3, 2, 1};
		int[] arr = new int[] { 1, 2, 3 };

		System.out.println(arr);
		for (int i = 0; i < arr.length; i++) { // 0, 1, 2 => arr.length 3
			System.out.println(arr[i]);
		}

		for (int i = 1; i < arr.length; i++) { // 0, 1, 2 => arr.length 3
			System.out.println(arr[i]);
		}
		System.out.println("---------------------------------------");
		// enhanced for (향상된 for문) Array의 index를 통해서 호출이 아닌 Array전체를 처음부터 끝까지 출력
		for (int a : arr) {
			System.out.println(a);
		}
		// 출력을 쉽게 확인하기 위해서 등
		// Array는 클래스로 생성되는 객체가 아니기때문에 기능을 가질 수가 없음
		// 그래서 Array의 기능을 부여 할 수 있는 java.util.Array가 기능을 동작하는 메소드들의 집합입니다.

		String arrPrint = Arrays.toString(arr);
		System.out.println(arrPrint);

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		Arrays.fill(arr, -99);
		System.out.println(Arrays.toString(arr));

		Object[] obj = new Object[] { 1, 2, 3, "a" };
		System.out.println(Arrays.toString(obj));
		for (Object o : obj) {
			System.out.println(o);
		}
	}

}
