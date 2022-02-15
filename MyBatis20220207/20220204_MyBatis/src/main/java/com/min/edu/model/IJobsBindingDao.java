package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MyBatisVo;

public interface IJobsBindingDao {
	
	/**
	 * Map의 Parameter은 반드시 Key명을 같게 사용해야 함
	 * column
	 * value
	 */
	public List<MyBatisVo> binding01(Map<String, Object> map);
	
	public List<MyBatisVo> binding02(Map<String, Object> map);
	
	
}
