package com.min.edu;

/*
 * 학생의 정보를 담고 있는 클래스
 */
public class Student {

	private String name;
	private int age;
	private String address;
	
	

	public Student(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}
	
	public void student_print() {
		System.out.println("'학생의 성명 : " + name);
		System.out.println("'학생의 나이 : " + age);
		System.out.println("'학생의 주소 : " + address);
		
	}

}
