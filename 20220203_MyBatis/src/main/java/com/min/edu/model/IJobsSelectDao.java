package com.min.edu.model;

import com.min.edu.vo.MyBatisVo;

public interface IJobsSelectDao {
	
	public Integer select01(String id);
	
	public MyBatisVo select02(String id);
	
	public MyBatisVo select03(String id);
}
