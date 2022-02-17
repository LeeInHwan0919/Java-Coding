package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MyBatisVo;

public interface IJobsSelectDao {
	
	public Integer select01(String id);
	
	public MyBatisVo select02(String id);
	
	public MyBatisVo select03(Object job_id);
	
	public List<MyBatisVo> select03_1();
	
	public Map<String, MyBatisVo> select04();
	
	public List<MyBatisVo> select05(MyBatisVo vo);
	
	public MyBatisVo select06(Map<String, Object> map);
	
	public List<MyBatisVo> select07(Object obj);
}
