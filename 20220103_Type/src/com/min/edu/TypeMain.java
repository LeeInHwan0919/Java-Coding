package com.min.edu;

public class TypeMain {

	public static void main(String[] args) {
		TypeProcess t1 = new TypeProcess();
		TypeProcess t2 = new TypeProcess();
		TypeProcess t3 = t2;
		System.out.println(t1==t2);
		System.out.println(t1==t3);
		
		System.out.println(t1.b);
		System.out.println(t1.s);
		System.out.println(t1.i);
		System.out.println(t1.l);//정수
		System.out.println(t1.f);
		System.out.println(t1.d);//실수
		System.out.println(t1.bool);//논리형
		System.out.println(t1.arr);
		

	}

}
