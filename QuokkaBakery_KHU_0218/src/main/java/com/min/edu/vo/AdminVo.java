package com.min.edu.vo;

import java.io.Serializable;
import java.util.Date;

public class AdminVo implements Serializable {

	private static final long serialVersionUID = 8641526079138487536L;
	private String id;
	private String pw;
	private String name;
	private Date birthdate;
	private String phonenum;

	@Override
	public String toString() {
		return id;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getId() {
		return id;
	}



	public String getPw() {
		return pw;
	}



	public String getName() {
		return name;
	}



	public Date getBirthdate() {
		return birthdate;
	}



	public String getPhonenum() {
		return phonenum;
	}



	public void setId(String id) {
		this.id = id;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}



	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}



	public AdminVo(String id, String pw, String name, Date birthdate, String phonenum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthdate = birthdate;
		this.phonenum = phonenum;
	}



	
}