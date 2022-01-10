package com.min.edu;

public class Child extends Parent {
	
	public int n = 100;
	
	public void childMethod() {
		
	}
	
	public void parentMake() {
		super.parentMake();
		System.out.println("난 부모를 재정의 했다.");
	}
	
	public void callParent() {
		super.parentMake();
	}
}
