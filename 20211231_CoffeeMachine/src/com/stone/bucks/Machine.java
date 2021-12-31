package com.stone.bucks;

//기능의 집합체
public class Machine {

	public 커피 주문() {
		커피 c = make();
		return c;
	}
	
	
	private 커피 make() {
		커피 프라프치노 = new 커피();
		프라프치노.name = "프라프치노";
		프라프치노.sugar = "8스푼";
		return 프라프치노;
	}
}
