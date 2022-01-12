package com.min.edu;

public class ThisSuperMain {
	public static void main(String[] args) {
		Parent p = new Child();

		// 생성된 객체는 자식의 객체이지만
		// 사용되는 타입이 부모의 타입
		// 부모의 멤버필드를 사용할 수 있음
		// 즉, 멤버필드는 오버라이드 되지않음.
		System.out.println(p.num);
		p.print(); // VMI
		
		//	Parent의 타입으로 사용했던 객체 p를
		// 원래 생성자의 타입으로 변경
		Child c = (Child)p;
		System.out.println(c.num);
		c.print();
	}

}
