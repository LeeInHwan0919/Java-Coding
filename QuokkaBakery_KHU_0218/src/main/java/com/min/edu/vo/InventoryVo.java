package com.min.edu.vo;

import java.io.Serializable;

public class InventoryVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4699036714032145996L;
	private String g_code;
	private String g_name;
	private int g_amount;
	private String m_regdate; 
	
	public InventoryVo() {
		// TODO Auto-generated constructor stub
	}


	public InventoryVo(String g_code, String g_name, int g_amount) {
		super();
		this.g_code = g_code;
		this.g_name = g_name;
		this.g_amount = g_amount;
	}
	public String getG_name() {
		return g_name;
	}
	public String getG_code() {
		return g_code;
	}

	public void setG_code(String g_code) {
		this.g_code = g_code;
	}

	public int getG_amount() {
		return g_amount;
	}

	public void setG_amount(int g_amount) {
		this.g_amount = g_amount;
	}

	public String getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}


	@Override
	public String toString() {
		return "\n[상품코드=" + g_code + ", 상품명=" + g_name + ", 재고수량=" + g_amount + ", 최근입고일="
				+ m_regdate + "]||\n=============================================================================";
	}


	
	
}
