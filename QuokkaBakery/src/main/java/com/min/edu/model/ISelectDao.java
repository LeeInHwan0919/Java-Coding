package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.AccountVo;

public interface ISelectDao {

	// 단일 행 값 출력
	public int selectPW(String id);
	
	public int selectID(String pw);
	
}
