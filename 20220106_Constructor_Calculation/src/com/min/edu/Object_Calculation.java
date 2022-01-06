package com.min.edu;

public class Object_Calculation {

	public static ValueMN add(ValueMN mn1, ValueMN mn2) {
		return new ValueMN(mn1.getM() + mn2.getM(), mn1.getN() + mn2.getN());
	}
	public static ValueMN minus(ValueMN mn1, ValueMN mn2) {
		return new ValueMN(mn1.getM() - mn2.getM(), mn1.getN() - mn2.getN());
	}

}
