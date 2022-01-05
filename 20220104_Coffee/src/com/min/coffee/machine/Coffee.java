package com.min.coffee.machine;

/**
 * 커피종류, 가격, 잔돈을 가지고 있는 클래스
 * 
 * @author LeeInHwan
 *
 */
public class Coffee {

	// TODO 001. 커피종류, 가격, 잔돈을 가지고 있는 DTO/VO

	/**
	 * 주문 커피명
	 */
	private String coffeeName;
	
	/**
	 * 커피 가격
	 */
	private int price;
	
	/**
	 * 주문 후 잔돈
	 */
	private int pay;
	
	/**
	 * 주문 후 커피 갯수
	 */
	private int cup;
	
	
	/**
	 * 커피 객체를 생성하기 위한 생성잦
	 * @param coffeeName 커피명
	 * @param price 가격
	 * @param pay 잔돈
	 */
	public Coffee(String coffeeName, int price, int pay, int cup) {
		super();
		this.coffeeName = coffeeName;
		this.price = price;
		this.pay = pay;
		this.cup = cup;
		
	}
	
	/**
	 * 외부에서 커피명을 가져 갈 수 있는 get메소드
	 * @return String 커피명
	 */
	public String getCoffeeName() {
		return coffeeName;
	}
	
	/**
	 * 외부에서 커피 가격을 가져 갈 수 있는 get메소드
	 * @return int 커피가격
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 외부에서 잔돈 을 가져 갈 수 있는 get메소드
	 * @return int 잔돈
	 */
	public int getPay() {
		return pay;
	}
	
	/**
	 * 외부에서 주문개수를 가져 갈 수 있는 get메소드
	 * @return int 커피개수
	 */
	public int getCup() {
		return cup;
	}

}
