package com.min.edu.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

/**
 * 여러개의 DAO를 조합하여 처리하는 interface
 * 
 *
 */

public interface IQuokkaService {
	
	// selectPW 아이디와 이름으로 비밀번호 찾기 - 이인환
	public AdminVo selectPW(String id, String name);
	//	이름과 휴대폰번호로 아이디 찾기 - 이인환
	public AdminVo selectID(String name, String phonenum);
    //	아이디, 비밀번호 일치 여부 --이인환
	public AdminVo Login(String id, String pw);
	// 계정 추가(회원가입) --이인환
	public int insertAdmin(String id, String pw, String name, Date birthdate, String phonenum);
	//계정삭제 -- 이인환
	public int deleteAdmin(AdminVo vo);	
	//비밀번호 변경 -- 이인환
	public int updatePw(String newp, String oldp);

	
	
	
	
	
}
