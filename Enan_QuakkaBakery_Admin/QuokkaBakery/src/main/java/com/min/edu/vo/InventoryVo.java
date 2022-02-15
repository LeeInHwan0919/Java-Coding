package com.min.edu.vo;

import java.io.Serializable;

public class InventoryVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4699036714032145996L;
	private String g_code;
	private int g_amount;
	private String m_regdate; 
	private String end_date;
	
	public InventoryVo() {
		// TODO Auto-generated constructor stub
	}

	public InventoryVo(String g_code, int g_amount, String m_regdate, String end_date) {
		super();
		this.g_code = g_code;
		this.g_amount = g_amount;
		this.m_regdate = m_regdate;
		this.end_date = end_date;
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

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "InventoryVo [g_code=" + g_code + ", g_amount=" + g_amount + ", m_regdate=" + m_regdate + ", end_date="
				+ end_date + "]";
	}
	
	
}
