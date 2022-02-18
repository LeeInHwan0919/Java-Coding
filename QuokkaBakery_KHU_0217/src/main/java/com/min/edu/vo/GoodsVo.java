package com.min.edu.vo;

import java.io.Serializable;

public class GoodsVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7853883067608108268L;
	private String g_code;
	private String g_name;  
	private int price;
	
	public GoodsVo() {
		// TODO Auto-generated constructor stub
	}

	public GoodsVo(String g_code, String g_name, int price) {
		super();
		this.g_code = g_code;
		this.g_name = g_name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "상품 [상품코드=" + g_code + ", 상품명=" + g_name + ", 가격=" + price + "]";
	}

	public String getG_code() {
		return g_code;
	}

	public void setG_code(String g_code) {
		this.g_code = g_code;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
