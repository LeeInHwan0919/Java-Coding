package com.min.edu.model;

import java.util.Map;

public interface IDeleteDao {
	
	//ID에 해당하는 계정 삭제
	public int deleteAdmin(Map<String, Object> map);
	
	public int deleteAcName(Map<String, Object> map);
	
	public int deleteAcTel(Map<String, Object> map);
	
	public int deleteCEO(Map<String, Object> map);
	
	public int deleteGoods(Map<String, Object> map);
	
	
	
}
