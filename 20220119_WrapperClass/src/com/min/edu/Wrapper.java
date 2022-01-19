package com.min.edu;

public class Wrapper {

	/*
	 * 기본타입은 크기와 형태(byte단위 = 8bit)의 변환이다 >> Casting / Promotion >> AritmaticException
	 * 
	 * 참조타입은 부모와 자식간의 관계에 따른 변환이다. >> up/down Casting >> ClassCastException
	 */

	// int > Integer로 바꿈 : AutoBoxing
	public void wrapper_1() {
		int n = 10;
//		Integer i = new Integer(n); // deprecate 예전방식(삭제됨)
		Integer i = n; // AutoBoxing
	}

	public void wrapper_2() {
		Integer i = 10;
		int n = i.intValue(); // Heap에 있는 IntegerClass의 값만을 stack으로 옮겨줍니다.
	}

	
	/**
	 * 이게중요하다
	 */
	//참조타입은 Wrapper Class는 해당 객체의 값으로 Hashcode를 재생성한다
	public void wrapper_3() {
		Integer i =10;
		System.out.println(i);
		System.out.println(i.hashCode());
		System.out.println(System.identityHashCode(i));
		
		Float f =3.14f;
		System.out.println(f.hashCode());
		System.out.println(System.identityHashCode(f));
		
		Character c ='A';
		System.out.println(c.hashCode());
		System.out.println(System.identityHashCode(c));
	}
	
	public void wrapper_4() {
		int n = 10; // 기본타입 선언 대입 (리터럴)
		Integer i = n; // 참조타입 선언 대입 AutoBoxing
		Object obj = i; // upCasting
		
//		int m = obj + 1; // 연산대상이 되지 않는다.
		/**
		 * 이게중요하다
		 */
		int m = (Integer)obj + 1; // Object특성이 아니라 Integer 연산이 발생할 때 AutoBoxing
		
		int o = 100;
		long l = o; // Promotion
		
		Integer p = 200; // 참조타입 선언
		
		//Integer 는 Short 혹은 Long과 같은 객체로는 변할 수 없다. 변할 수 있는 형태는 상위부모인 Object로 변경하는 것 뿐이다.
		//Object로 변경된 upcasting된 객체는 연산을 할 수 없음 => AutoUnboxing 이ㅣ 발생하지 않는다.
		//Integer는 기본타입과 연산하면 자동으로 AutoUnBoxing이 발생하여 결과를 기본타입의 int로 변환
		//결과인 기본타입int를 long객체로 변환하기 위해서는 쌍으로 되어 있는 기본타입 long으로 변경해야함.
		Long q = (long) ((Integer)(Object)p+1); //(Integer)(Object)로 int값변환 (long) 으로 promotion변환
	
		int mm = 10;
		Long ll = (long)mm;//참조타입이기떄문에 들어가지않음 (long)으로 promotion변환을 해주어야 함.
	}
	
	
}
