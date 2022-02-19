package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.AccountVo;

public interface IQuokkaService {
	//거래처 추가
	public int insertAccount(AccountVo vo);
	//거래처 삭제
	public int deleteAcName(Map<String, Object> map);//거래처이름으로 삭제
	//거래처 조회
	public List<AccountVo> selectAll(); // 전체조회 -한슬기
	public AccountVo selectAcName (Object ac_name);//거래처명으로 조회 -한슬기
	public AccountVo selectCEO (Object ceo_name);//대표명으로 조회 -한슬기
	//거래처 정보 업데이트
	public int updateAcName(Map<String, Object> map); //거래처명 -한슬기
	public int updateAcTel(Map<String, Object> map); //거래처 전화번호 -한슬기
	public int updateCEO(Map<String, Object> map); //거래처 대표명 -한슬기
	
	
	
}
