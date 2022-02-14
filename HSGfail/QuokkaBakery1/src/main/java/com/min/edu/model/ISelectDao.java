package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.AccountVo;

public interface ISelectDao {
	
	public List<AccountVo> selectAll(); // 전체조회 -한슬기
	public AccountVo selectAcName (Object ac_name);//거래처명으로 조회 -한슬기
	public AccountVo selectAcTel (Object ac_tel);//거래처명으로 조회 -한슬기
	public AccountVo selectAcRegnum (Object ac_regnum);//사업자등록번호로 조회 -한슬기
	public AccountVo selectCEO (Object ceo_name);//대표명으로 조회 -한슬기
	public AccountVo selectAcCode (Object ac_code);//거래처코드로 조회 -한슬기
}
