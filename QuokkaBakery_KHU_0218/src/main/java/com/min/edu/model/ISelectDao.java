package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;


public interface ISelectDao {

	public List<AdminVo> IDAll(); //id전체조회 - 이인환
	public AdminVo selectPW(AdminVo vo); //비밀번호찾기 - 이인환
	public AdminVo selectID(AdminVo vo); //아이디찾기 - 이인환
	public AdminVo Login(AdminVo vo); //아이디, 비밀번호 일치 여부 > 이인환
	
}
