package com.min.edu.model;

import java.util.Map;

public interface IDeleteDao {
	public int deleteAdmin(Map<String, Object> map);
	
	public int deleteAcName(Map<String, Object> map);
	public int deleteAcTel(Map<String, Object> map);
	public int deleteCEO(Map<String, Object> map);
	
	public int deleteGoods(Map<String, Object> map);
	
	
	
}
