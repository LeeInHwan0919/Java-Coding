package com.min.edu.model;

import java.util.Map;

import com.min.edu.vo.MyBatisVo;

public interface IJobsIDUDao {
	
	public int insert01(MyBatisVo vo);
	public int delete01(Map<String, Object> map);
	public int update01(Map<String, Object> map);
}
