package com.min.edu;

//DTO는 : Data Transfer Object 데이터를 묶음으로 가지고 다닐 수 있는 객체
// 반환은 반드시 한개만 가능하다. 입력은 여러개 가능하다.
public class Dto {

	//멤버필드 영역
	//(접근제한자를 가지고있다
	//자동으로 객체가 생성되면 초기화 단 값이 선언된 후에 대입이 되어 있다면 초기화 안된다.)
	//외부에서 instance 변수가 됨//heap
	public String name;
	public String hobby;
	
	//static 변수 //method area
	public static String etc; // 호출 방식 클래스명.변수, static생성자
	
	//n은 make내부에서만 사용할 수 있는 변수(초기화) loacl variable
	//외부에서 실행 시킬 때 필요한 값을(arguments) 전달 받는다.=>parameter
	//local variable은 외부에서 볼 수 없음.. 
	//stack 
	public void make(int n) {
		int i = 0;
		for (; i < 5; i++) {
			System.out.println("for문내부" + i);
		}
		System.out.println("for문외부" + (i + n));
		
		//밑에 세개는 멤버필드 영역에서 가져옴 this. 사용
		System.out.println(this.name);
		System.out.println(this.hobby);
		System.out.println(etc);
	}
	
	
	
	
	
	
}
