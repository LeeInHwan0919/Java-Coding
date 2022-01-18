package com.min.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class List_Feature {

	public void list_remove() {
		//int 값은 index로 인식을 함 > remove(int) index
		// Integer 값은 Object > remove(Object) 객체
		
		//객체의 index번호는 자동으로 부여됨
		// 1:0>2:1>3:2 2를지우면 1:0>3:1
		
		List<String> lists = new ArrayList<String>();
		lists.add("A");
		lists.add("B");
		lists.add("C");
		
		lists.remove(1); // 정수값 혹은 int변수를 넣으면 index로 인식
		System.out.println(lists.get(0));
		System.out.println(lists.get(1));
 	}
	
	public void list_contains() {
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(10);
		lists.add(100);
		lists.add(1000);
		
		boolean isc = lists.contains(100);
		System.out.println(isc);
		System.out.println("Clear 전" + lists.indexOf(100));//10이 들어있으면 0출력
		System.out.println(lists.size());
		lists.clear();
		System.out.println(lists.size());
		System.out.println("Clear 후" + lists.indexOf(10));//10이 들어있으면 -1출력
		
		//Array
		String[] strs = {"java", "html", "db"};
		ArrayList<String> strsList = new ArrayList<String>(Arrays.asList(strs));
		System.out.println(strsList);
	}

	public void list_iterator() {
		List<String> lists = new ArrayList<String>();
		lists.add("A");
		lists.add("B");
		lists.add("C");
		lists.add("D");

		Iterator<String> iter = lists.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());

		}
	}

	/*
	 * < > Generic 입력되는 객체를 선정하여 사용하는 방식 Generic이 선언이 되어 있다면 선언된 객체의 타입만을 입력 받고 출력됨
	 * 
	 */
	public void list_check() {
		List<Integer> lists = new ArrayList<Integer>();
		int n1 = 20, n2 = 30, n3 = 40;// n들은 기본타입 점찍었을때 안나옴
//		int a, b, c = 10; 아래와 같다.
		int a;
		int b;
		int c = 10;

		Integer i = new Integer(10);// i는 참조타입 점찍었을때 많이나옴 // 1.8에서 wrapperClass 1.9이상 부터는 자동변환 >>AutoBoxing,
									// AutoUnBoxing
		System.out.println(i.intValue());

		System.out.println(i);
//		System.out.println(a);  출력하거나 사용 X
		System.out.println(c);

		lists.add(n1); // Generic Integer으로 되어 있음, 하지만 입력하는 값은 int기본타입 int-> Integer
		lists.add(n2);
		lists.add(n3);

		System.out.println("=====================================");

//		System.out.println(lists.get(0));
//		System.out.println(lists.get(1));
//		System.out.println(lists.get(2));

		n3 = 100;
		int n4 = 30; // 기본타입 선언
		Integer n5 = n4; // 기본타입 > 참조타입 AutoBoxing
		// remove
//		System.out.println(lists.remove(n4)); //기본타입 int는 index로 인식함
		System.out.println(lists.remove(n5));

		for (int n : lists) { // Integer > int
//			System.out.println(lists.get(i));
			System.out.println(n);
		}
	}

}
