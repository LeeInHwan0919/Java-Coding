package com.min.edu.vo;

import java.io.Serializable;

public class JobsVO implements Serializable {

	private static final long serialVersionUID = -7620621369355163555L;
	private String job_id;
	private String job_title;
	private String min_salary;
	private String max_salary;

	public JobsVO(String jOB_ID, String jOB_TITLE, String mIN_SALARY, String mAX_SALARY) {
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

	public String getMIN_SALARY() {
		return min_salary;
	}

	public void setMIN_SALARY(String mIN_SALARY) {
		min_salary = mIN_SALARY;
	}

	public String getMAX_SALARY() {
		return max_salary;
	}

	public void setMAX_SALARY(String mAX_SALARY) {
		max_salary = mAX_SALARY;
	}

	public JobsVO() {
		super();
	}

}
