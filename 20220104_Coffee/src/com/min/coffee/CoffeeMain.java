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
		
	}

}
