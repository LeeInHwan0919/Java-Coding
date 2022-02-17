package com.min.edu.vo;

import java.io.Serializable;

public class AccountVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7206044579590674978L;
	private int ac_code; 
	private String ac_name;
	private String ac_regnum;
	private String regdate; 
	private String ac_tel;
	private String ceo_name;
	
	public AccountVo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountVo [ac_code=" + ac_code + ", ac_name=" + ac_name + ", ac_regnum=" + ac_regnum + ", regdate="
				+ regdate + ", ac_tel=" + ac_tel + ", ceo_name=" + ceo_name + "]";
	}

	public AccountVo(int ac_code, String ac_name, String ac_regnum, String ac_tel, String ceo_name) {
		super();
		this.ac_code = ac_code;
		this.ac_name = ac_name;
		this.ac_regnum = ac_regnum;
		this.ac_tel = ac_tel;
		this.ceo_name = ceo_name;
	}

	public int getAc_code() {
		return ac_code;
	}

	public void setAc_code(int ac_code) {
		this.ac_code = ac_code;
	}

	public String getAc_name() {
		return ac_name;
	}

	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}

	public String getAc_regnum() {
		return ac_regnum;
	}

	public void setAc_regnum(String ac_regnum) {
		this.ac_regnum = ac_regnum;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getAc_tel() {
		return ac_tel;
	}

	public void setAc_tel(String ac_tel) {
		this.ac_tel = ac_tel;
	}

	public String getCeo_name() {
		return ceo_name;
	}

	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}

	
}