package com.min.edu;

public class StaticMain {
	//TODO 001
	
	public static void main(String[] args) {
		//TODO 005 외부에서 static과 non-static 호출방법
		// non-static은 new를 통해 객체를 생성후 객체명을 통해서 호출
		StaticTest st = new StaticTest();
		st.generalMethod();
		st.nonStaticMethod();
		st.staticMethod();
		
		// static은 미리 메모리에 할당되어 주소를 갖고 있기 때문에 포함된 클래스명을 통해서 호출
		StaticTest.staticMethod();
		
		System.out.println(StaticMemberField.age2);
		
		StaticMemberField sm1 = 
				new StaticMemberField();
		sm1.age = 100;
		sm1.name = "둘리";
		StaticMemberField.age2 = 777;
		System.out.println(sm1.age);
		System.out.println(sm1.name);
		System.out.println(StaticMemberField.age2);
		
		StaticMemberField sm2 = 
				new StaticMemberField();
		sm2.age = 70;
		sm2.name = "희동이";
		StaticMemberField.age2 = 888;
		System.out.println(sm2.age);
		System.out.println(sm2.name);
		System.out.println(StaticMemberField.age2);
		
		//static으로 선언된 멤버필드값
		//수학함수를 가지고 있는 java.lang.Math.PI
		System.out.println(Math.PI);
		String str = String.valueOf(sm2);
		System.out.println(str);
	}

}
