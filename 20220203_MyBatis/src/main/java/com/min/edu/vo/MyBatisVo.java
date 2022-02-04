package com.min.edu.vo;

import java.io.Serializable;

/*
 * POJO 객체로 만들어서 객체를 DB에서 입력할때, DB 작성된 결과를 저장할 때, 화면으로 이동할 때 사용되는 객체
 * DTO/VO의 이름을 갖는다
 * 은닉화 되어 있는 객체다
 * 
 * MyBatis 및 다른 DTO를 필요로 하는 객체를 default생성자, getter, setter메소드를 반드시 가지고 있어야 한다
 * 
 * --주의점--
 * SQL의 결과는 대문자로 반환됨: getter/setter는 반드시 소문자 
 * 
 */
public class MyBatisVo implements Serializable {

	private static final long serialVersionUID = -7620621369355163555L;
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;

	public MyBatisVo(String jOB_ID, String jOB_TITLE, int mIN_SALARY, int mAX_SALARY) {
		super();
		this.job_id = jOB_ID;
		this.job_title = jOB_TITLE;
		this.min_salary = mIN_SALARY;
		this.max_salary = mAX_SALARY;
	}

	@Override
	public String toString() {
		return "JobsVO [JOB_ID=" + job_id + ", JOB_TITLE=" + job_title + ", MIN_SALARY=" + min_salary + ", MAX_SALARY="
				+ max_salary + "]";
	}

	public String getJOB_ID() {
		return job_id;
	}

	public void setJOB_ID(String jOB_ID) {
		job_id = jOB_ID;
	}

	public String getJOB_TITLE() {
		return job_title;
	}

	public void setJOB_TITLE(String jOB_TITLE) {
		job_title = jOB_TITLE;
	}

	public int getMIN_SALARY() {
		return min_salary;
	}

	public void setMIN_SALARY(int mIN_SALARY) {
		min_salary = mIN_SALARY;
	}

	public int getMAX_SALARY() {
		return max_salary;
	}

	public void setMAX_SALARY(int mAX_SALARY) {
		max_salary = mAX_SALARY;
	}

	public MyBatisVo() {
		super();
	}

}
