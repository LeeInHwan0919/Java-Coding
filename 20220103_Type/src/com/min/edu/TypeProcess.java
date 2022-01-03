package com.min.edu;

import java.util.Arrays;

public class TypeProcess {
  // 멤버필드선언, 클래스의 특징, heap, 접근제한자, 자동으로 초기화
  // instance variable : 객체를 new해서 접근하여 사용할 수 있는 변수
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	boolean bool;
	char c;

  //
	public Arrays arr;  // 멤버필드가 없는 기능만 가진 클래스.
	
	
	//TODO 001.java 의 기본타입의 연산 특징
	/*			정수의 기본연산은 int 참여하는 타입에 따라서 결과 값이 변화될 수 있다.
	 * 
	 */
	public void calculation() {
		byte b1 = 127;
		byte b2 = 1;
		/*byte*/int bSum = b1+b2;
		System.out.println(bSum);
		byte bSum_2 = (byte)(b1+b2);//강제캐스팅 왜 -128 되었는지.
		System.out.println(bSum_2);
		
		int bSum_3 = (byte)(b1+b2);
		System.out.println(bSum_3);
		
		float f = 10.0f;
		System.out.println(f);
		
		double d = 3.00;
		/* double*/ double dDiv = d/2;
		System.out.println(dDiv);
		
		int i1 = 10;
		int i2 = 4;
		float f_iDiv = i1/i2;
		System.out.println(f_iDiv);
		
		
		float fCal = (float)(10/3);
		System.out.println(fCal);
		
		
	}
	
	public void 실수Fn() {
		float f1 = 3.14f; //리터럴은 double크기를
		float f2 = (float)3.14; // Casting
		
		//Promotion
		double d = f1;//작은크기에서 큰 크기로 변경
	}
	
}
