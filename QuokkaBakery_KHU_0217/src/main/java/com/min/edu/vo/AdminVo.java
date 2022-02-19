package com.min.edu.vo;

import java.io.Serializable;

public class AdminVo implements Serializable {

	private static final long serialVersionUID = 8641526079138487536L;
	private int seq;
	private String id;
	private String pw;
	private String name;
	private String birthdate;
	private String phonenum;
	
	@Override
	public String toString() {
		return "AdminVo [seq=" + seq + ", id=" + id + ", pw=" + pw + ", name=" + name + ", birthdate=" + birthdate
				+ ", phonenum=" + phonenum + "]";
	}
	
	

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public AdminVo(String id, String pw, String name, String birthdate, String phonenum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthdate = birthdate;
		this.phonenum = phonenum;
	}
}