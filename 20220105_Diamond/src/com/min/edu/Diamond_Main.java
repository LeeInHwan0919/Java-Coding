package com.min.edu;

import com.goo.dee.GoodeeUtil;

public class Diamond_Main {

	public static void main(String[] args) {
		int n = GoodeeUtil.inputNum();
		System.out.println("입력받은 정수값 : " + n);
		
		
		//Diamond_Div dd = new Diamond_Div();
		//dd.printAll(n);
		
		
		//Diamond_if.dia_if(n);
		
		Diamond_MathAPI ma = new Diamond_MathAPI();
		ma.dia_math_api(n);
		
		//Diamond_Seperate.solomon();
		
	}

}
