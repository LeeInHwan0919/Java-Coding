package com.min.edu;

public class Child extends Parent{
	
	public int num;
	
	public Child() {
		this(3);//부모의 생성을 위임하게 됨.
	}
	
	public Child(int num) {	//	parameter
		//	메소드는 local variable 이 우선
		this.num = num;
		this.print();
		System.out.println("local variable num :" + num);
		System.out.println("자신의 멤버 : "+ this.num);
		System.out.println("부모의 멤버 : "+ super.num);
	}
	@Override
	public void print() {
		System.out.println("자식의 프린트");
	}
}
