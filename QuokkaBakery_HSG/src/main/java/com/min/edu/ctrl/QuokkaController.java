package com.min.edu.ctrl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.service.IQuokkaService;
import com.min.edu.service.QuokkaServiceImpl;
import com.min.edu.vo.AccountVo;

public class QuokkaController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private IQuokkaService service;
	
	public QuokkaController() {
		service = new QuokkaServiceImpl();
	}
	
	//거래처 추가 -한슬기
	public int insertAccount(AccountVo vo) {
		logger.info("거래처정보 추가 실행");
		return service.insertAccount(vo);
	}
	
	
	//거래처이름으로 삭제 -한슬기
	public int deleteAcName(Map<String, Object> map){
		logger.info("거래처정보 삭제 실행");
		return service.deleteAcName(map);		
	}	

	
	//거래처 전체 출력 -한슬기
	public List<AccountVo> selectAll(){
		logger.info("거래처 전체 출력실행");
		return service.selectAll();	
	}
	//거래처 이름으로 조회 -한슬기
	public AccountVo selectAcName (Object ac_name){
		logger.info("거래처 이름으로 조회 실행");
		return service.selectAcName(ac_name);	
	}
	//대표명으로 조회 -한슬기
	public AccountVo selectCEO (Object ceo_name){
		logger.info("대표명으로 조회 실행");
		return service.selectCEO(ceo_name);
	}
	
	
	//거래처명 업데이트 -한슬기
	public int updateAcName(Map<String, Object> map) {
		logger.info("거래처명 업데이트 실행");
		return service.updateAcName(map);
	}
	//거래처 전화번호 업데이트 -한슬기
	public int updateAcTel(Map<String, Object> map) {
		logger.info("거래처 전화번호 업데이트 실행");
		return service.updateAcTel(map);
	}
	//거래처 대표명으로 조회 -한슬기
	public int updateCEO(Map<String, Object> map) {
		logger.info("거래처 대표명 업데이트 실행");
		return service.updateCEO(map);		
	}
	
	

}
