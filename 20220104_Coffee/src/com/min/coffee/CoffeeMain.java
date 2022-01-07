package com.min.coffee;

import com.min.coffee.machine.Coffee;
import com.min.coffee.machine.CoffeeMachine;
import com.min.coffee.print.CoffeePrint;

/**
 * 커피자판기를 실행
 * 
 * @author LeeInHwan
 * @since 2022.01.04
 * @version 1.0b
 */
public class CoffeeMain {

	/**
	 * 커피(아메리카노)를 주문하는 main 메소드
	 * 
	 * @param args 초기 입력 값
	 */
	public static void main(String[] args) {

		// 1)Test Coffee
		Coffee co = new Coffee("아메리카노", 200, 300, 2);
		System.out.printf("%s %d %d %d %n", co.getCoffeeName(), co.getPrice(), co.getPay(), co.getCup());
		
		// 2) Test Coffee
		CoffeePrint.print(co);
		
		// 3) Test 실행
		CoffeeMachine machine = new CoffeeMachine();
		machine.coffeeProcess(1100);
		/*
		 * 돈을 넣어주세요... 돈을 입력받도록 출력 (money)//scanner
돈을 입력하면 입력한 돈의 금액이 출력 (얼마들어갔습니다.,)
커피객체(커피이름, 커피가격)들을 (배열사용해서) 선택을 합니다.//잔 개수를 입력받습니다.
커피객체(잔개수)가 출력됨으로써 잔돈을 출력하게 만듭니다.
if case?? 판단문을 이용하여 커피를 더 구매할것인지, 잔돈을 반환할것인지 메소드
재료로직

		 */
	}

}
