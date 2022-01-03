package com.min.edu;
/*
 * 개인 정보를 입력할 수 있는 객체
 */
public class Info {
	
	public String name;
	public int age;
	public String address;
	
	public void infoPrint() {
		System.out.println("이름은 : " + name);
		System.out.println("나이는 : " + age);
		System.out.println("주소는 : " + address);
		
	}
	
}
