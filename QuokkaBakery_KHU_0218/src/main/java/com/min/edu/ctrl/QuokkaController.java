package com.min.edu.ctrl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.min.edu.service.IQuokkaService;
import com.min.edu.service.QuokkaServiceImpl;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class QuokkaController {

	private Logger logger = Logger.getLogger(this.getClass());
	private IQuokkaService service;

	public QuokkaController() {
		service = new QuokkaServiceImpl();
	}
//ADMIN============================================================

	// 거래처 전체 출력 -한슬기
	public List<AdminVo> IDAll() {
		logger.info("거래처 전체 출력실행");
		return service.IDAll();
	}

	// selectPW 아이디와 이름으로 비밀번호 찾기 이인환
	public AdminVo selectPW(String id, String name) {
		logger.info("selectPW 아이디와 이름으로 비밀번호 찾기 실행");
		return service.selectPW(id, name);
	}

//	이름과 휴대폰번호로 아이디 찾기 - 이인환
	public AdminVo selectID(String name, String phonenum) {
		logger.info("selectID 이름과 휴대폰번호로 아이디 찾기 실행");
		return service.selectID(name, phonenum);
	}

//	아이디, 비밀번호 일치 여부 --이인환
	public AdminVo Login(String id, String pw) {
		logger.info("아이디, 비밀번호 일치 여부 실행");
		return service.Login(id, pw);
	}

	// 계정생성 -이인환
	public int insertAdmin(String id, String pw, String name, Date birthdate, String phonenum) {
		logger.info("계정 생성 실행");
		return service.insertAdmin(id, pw, name, birthdate, phonenum);
	}

	// 계정삭제 -이인환
	public int deleteAdmin(AdminVo vo) {
		logger.info("계정 삭제 실행");
		return service.deleteAdmin(vo);
	}

	// 비밀번호 변경 - 이인환
	public int updatePw(String newp, String oldp) {
		logger.info("비밀번호 변경 실행");
		return service.updatePw(newp, oldp);
	}

}
