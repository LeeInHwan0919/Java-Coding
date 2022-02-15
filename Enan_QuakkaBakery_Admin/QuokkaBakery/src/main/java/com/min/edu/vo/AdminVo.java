package com.min.edu.vo;

import java.io.Serializable;

public class AdminVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8641526079138487536L;
	private int seq;
	private String id;
	private String pw;
	
	public AdminVo() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "AdminVo [seq=" + seq + ", id=" + id + ", pw=" + pw + "]";
	}
	
	
	

	public AdminVo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
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

}
