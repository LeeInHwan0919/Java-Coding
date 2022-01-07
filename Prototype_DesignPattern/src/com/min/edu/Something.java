package com.min.edu;

public class Something implements Cloneable{

	private String name;
	private String hobby;

	public Something(String name, String hobby) {
		super();
		this.name = name;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Something [name=" + name + ", hobby=" + hobby + "]";
	}

	public Object createClone() {
		Object obj = null;

		try {
			obj = this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return obj;
	}
}
