package com.min.edu;

/**
 * 값을 가지고 있는 객체<br>
 * 은닉화로 작성되어 있으며, 맴버필드에 값을 저장할 수 있는 객체
 * 
 * @author HIK
 *
 */
public class User {
	private String name;

	public String getName() {
		return name;
	}

	public User(String name) {
		super();
		this.name = name;
	}
}
