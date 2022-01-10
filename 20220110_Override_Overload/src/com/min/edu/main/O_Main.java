package com.min.edu.main;

import com.min.edu.Child;
import com.min.edu.Parent;

public class O_Main {

	public static void main(String[] args) {
//		Child c = new Child();
//		c.parentMethod(); // 생성된 자식이 부모를 먼저 생성하기 때문에, 생성된 타입 Child
//		c.childMethod(); // 당연히 생성된 객체가 Child 클래스 이기 때문에
//		System.out.println(c.n); // 자식의 멤버필드
//		
//		Parent p = c;
//		p.parentMethod(); // 타입이 변경되어서 parents 타입이 되었음
//		System.out.println(p.n);

		Child c = new Child();
		c.parentMethod(); // 부모에게 물려 받은 메소드
		c.parentMake(); // 부모에게 물려받아 오버라이드한 메소드
		c.childMethod(); // 생성된 객체의 메소드
		System.out.println(c.n); // 생성된 객체의 멤버필드
		c.callParent();
		
		
		
		Parent p = c; // 생성된 객체는 Child 타입이지만 부모의 타입으로 변경 => 부모의 멤버만 보임
		System.out.println(p.n);
		p.parentMethod(); 
		p.parentMake(); // 부모의 원래 메소드를 실행시키기 위해서는 자식의 클래스에서만 가능하다.
		
		
		
		
	}

}
