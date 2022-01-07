package com.min.edu;

public class ValueMN {

	private double m;
	private double n;
	
	//생성자 Overloading 외부에서는 default 생성자를 사라짐
	public ValueMN(double m, double n) {
		super();
		this.m = m;
		this.n = n;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}
//
	public double getN() {
		return n;
	}

	public void setN(double n) {
		this.n = n;
	}
	
	
	
}
