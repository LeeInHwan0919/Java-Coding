package com.min.edu.model;

import java.util.Map;

public interface IUpdateDao {

	//비밀번호 변경 update
	public int updatepw(Map<String, Object> map);
}
