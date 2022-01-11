package com.min.edu;

/*
 *  상속 강요 : abstract 
 *  상속 금지 : final
 */
public /* final */ class FinalClass {

	public static int[] arr = { 1, 2, 3, 10, 20 };
	public final static int age = 100;

	public void c() {
		arr = new int[3];
	}

	public void change() {
		arr[0] = 100;

		final int a;
		a = 10;
		System.out.println(a);
	}

	public /* final */ String callMethod() {
		return "반환";
	}

}
