package com.min.edu;

public class StudentVO implements Cloneable {

	private String name;
	private String gender;
	private int age;

	public StudentVO(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentVo [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

	// --------------------부모의 Clone을 사용하여 내가 가지고 있는 clone this.clone()
	public Object createClone() {
		Object obj = null;

		try {
			obj = this.clone();
		} catch (CloneNotSupportedException e) { // this 객체가 복제가 가능한 특성(implements clone)을 가지고 있지 않으면 발생
			e.printStackTrace();
		}

		return obj;
	}

}
