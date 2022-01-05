package com.min.coffee.machine;

import com.min.coffee.print.CoffeePrint;

/**
 * 커피를 만들기 위해서 필요한 로직 포함
 * 
 * @author LeeInHwan
 *
 */
public class CoffeeMachine {

	/**
	 * 커피 구매 가격을 입력 받아 내부의 잔돈/커피갯수를 실행하여 Coffee객체를 생성
	 * 
	 * @param money
	 */
	public void coffeeProcess(int money) {

		int cup = coffeeMake(money);//자동커피 갯수 연산)
		int pay = coffeePay(money);//자동 커피 잔돈 연산
		
		Coffee order = new Coffee("케냐AA", 300, pay, cup);
		
		CoffeePrint.print(order);
	}

	/**
	 * 입력된 돈 만큼 커피를 계산하여 커피 잔수를 반환함
	 * 
	 * @param money 입력 돈
	 * @return int 계산된 커피 갯수
	 */
	private int coffeeMake(int money) {
		int n = 0;
		n = money / 300;
		return n;
	}

	/**
	 * 입력된 돈에서 커피값을 제외하고 남은 금액(잔돈)
	 * 
	 * @param money
	 * @return int 계산후 남은 금액
	 */
	private int coffeePay(int money) {
		int n = 0;
		n = money % 300;
		return n;
	}
}
