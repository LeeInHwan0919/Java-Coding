package com.min.edu.model;

import java.util.Map;

public interface IUpdateDao {
	public int updatePw(Map<String, Object> map);
	
	public int updateAcName(Map<String, Object> map); //거래처명 -한슬기
	public int updateAcTel(Map<String, Object> map); //거래처 전화번호 -한슬기
	public int updateCEO(Map<String, Object> map); //거래처 대표명 -한슬기
	
	public int updateGoodsPrice (Map<String, Object> map);
	
	public int updateInventory(Map<String, Object> map);
}
