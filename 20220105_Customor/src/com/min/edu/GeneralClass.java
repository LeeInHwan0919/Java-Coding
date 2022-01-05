package com.min.edu;

public class GeneralClass /*extends ParentsClass*/{
//TODO 001.생성자는 클래스명과 같고 반환타입없는 메소드다.
	//		클래스는 만들면 자동으로 생성되어 있다.(default 생성자)
//TODO 002. 명시적으로 default 생성자를 작성할 수 있다.
	public GeneralClass() {//default 생성자
		super();
		System.out.println(this.toString()+"입니다.");
	}
//나중에하겠습니다.0105 TODO 003. 생성자가 overloading 되면 default 생성자는 (명시적으로 선언할 때 까지) 삭제된다.
	
	{
		System.out.println("난 연산자 블럭이다.");
	}
	
	static {
		System.out.println("난 static 생성자다.");
	}
	
}
