package com.min.edu;

public class MN_Main {

	public static void main(String[] args) {
		ValueMN mn1 = new ValueMN(10, 5);
		ValueMN mn2 = new ValueMN(2, 3);
		
		ValueMN addResult = Object_Calculation.add(mn1,mn2);
		System.out.println(addResult.getM());
		System.out.println(addResult.getN());
		
		ValueMN minusResult = Object_Calculation.minus(mn1, mn2);
		System.out.println(minusResult.getM());
		System.out.println(minusResult.getN());
	}

}
