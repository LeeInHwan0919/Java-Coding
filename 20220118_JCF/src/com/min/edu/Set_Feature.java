package com.min.edu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_Feature {

	public void set_Array() {
		Set<String> sets = new HashSet<String>();
		String a = "가", b = "나", c = "다";
		String d = new String("다");

		sets.add(a);
		sets.add(b);
		sets.add(c);
		sets.remove(d); // contains와 같이 객체의 hashcode로 삭제한다.
		System.out.println(sets.contains("다"));
		
//		String[] strArray = (String[]) sets.toArray();
		Object[] objArray = sets.toArray();
		System.out.println(Arrays.toString(objArray));
		for (int i = 0; i < objArray.length; i++) {
			System.out.println(objArray[i]);
		}
	}

	// 중복값을 입력 받지 못함
	// 중복값을 입력하면 기존의 값을 유지 함
	// 출력 기준점(index, 키값) 없음. Iterator Design Pattern으로 출력

	public void set() {
		Set<String> sets = new HashSet<String>();
		String a = "가", b = "나", c = "다";
		String d = new String("다");
		System.out.println(System.identityHashCode(b));// 1227229563
		System.out.println(System.identityHashCode(d));// 971848845
		sets.add(a);
		sets.add(b);
		sets.add(c);

		sets.add(d);

		for (String s : sets) {
			System.out.println(s + ":" + System.identityHashCode(s));
		}
		// 비교
		System.out.println(sets.contains("다")); // Set에 포함된 객체는 hashcode로 비교한다.
		System.out.println(sets.contains(d));

		// 출력
		Iterator<String> iter = sets.iterator();
		while (iter.hasNext()) { // Iterator 타입으로 변환한 set객체를 확인 > 안에 객체가 있는지
			System.out.println("@" + iter.next());
		}

		while (iter.hasNext()) { // Iterator 객체는 한번 출력하게 되면 객체는 비워져 버림
			System.out.println(iter.next());
		}
	}

}
