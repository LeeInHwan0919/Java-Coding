package com.stone.bucks;

public class CoffeeMain {

	public static void main(String[] args) {
		Machine 금천구1번출구 = new Machine();
		
			커피 cup = 금천구1번출구.주문();
			System.out.println(cup.name);
			System.out.println(cup.sugar);
	}

}
