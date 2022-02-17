package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MyBatisVo;

public interface IJobsDynamicDao {

	//IF 태그 사용
	public List<MyBatisVo> getJobsIf(Map<String, Object> map);
	
	//foreach + java.util.List<String>
	public List<MyBatisVo> getJobsList(List<String> list);
	
	//foreach + java.util.Map<String, String[]>
	public List<MyBatisVo> getJobsMap(Map<String, String[]> map);
	
	//Choose
	public List<MyBatisVo> getJobsChoose(MyBatisVo vo);
	
	//Trim
	public List<MyBatisVo> getJobsTrim(MyBatisVo vo);
	
	//Set
	public int updateJobsSet(MyBatisVo vo);
	
	//Set 문법을 Trim문의 suffixOverrides 문법으로 변경
	public int updateJobsTrim(MyBatisVo vo);
}
