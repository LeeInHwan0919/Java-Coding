package com.min.coffee.print;

import com.min.coffee.machine.Coffee;

/**
 * 최종적으로 사용자에게 보여줄 출력
 * @author LeeInHwan
 *
 */
public class CoffeePrint {

	/**
	 * 완성된 커피 클래스를 입력 받아 출력해주는 메소드
	 * @param coffee 완성된 커피정보
	 */
	public static void print(Coffee coffee) {
		System.out.println("------------------");
		System.out.println(coffee.getCoffeeName());
		System.out.println("가격: "+coffee.getPrice());
		System.out.println("-------------------");
		System.out.printf("잔돈:%d / 커피:%d잔%n",coffee.getPay(), coffee.getCup());
	}
	
}//class
