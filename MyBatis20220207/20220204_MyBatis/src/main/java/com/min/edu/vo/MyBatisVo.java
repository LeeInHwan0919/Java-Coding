package com.min.edu.vo;

import java.io.Serializable;

/*
 * POJO 객체로 만들어서 객체를 DB에서 입력할 때, DB 작성된 결과를 저장할 때, 화면으로 이동할 때 사용되는 객체
 * DTO / VO 의 이름을 갖는다
 * 은닉화 되어있는 객체이다
 * 
 * MyBatis 및 다른 DTO를 필요로 하는 객체를 default 생성자, getter/setter 메소드를 반드시 가지고 있어야 한다
 * 
 * --주의점--
 * SQL의 결과는 대문자로 반환됨 : getter/setter는 반드시 소문자(Camel, Hungarian)
 * 
 */
public class MyBatisVo implements Serializable{
	
	private static final long serialVersionUID = 1237388625978600399L;
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
	
	public MyBatisVo() {
	}
	
	public MyBatisVo(String job_id, String job_title, int min_salary, int max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}
	@Override
	public String toString() {
		return "MyBatisVo [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary
				+ ", max_salary=" + max_salary + "]";
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public int getMin_salary() {
		return min_salary;
	}
	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}
	public int getMax_salary() {
		return max_salary;
	}
	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}
	
	
}   
