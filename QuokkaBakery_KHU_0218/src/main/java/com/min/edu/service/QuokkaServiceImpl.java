package com.min.edu.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.model.DeleteDaoImpl;
import com.min.edu.model.IDeleteDao;
import com.min.edu.model.IInsertDao;
import com.min.edu.model.ISelectDao;
import com.min.edu.model.IUpdateDao;
import com.min.edu.model.InsertDaoImpl;
import com.min.edu.model.SelectDaoImpl;
import com.min.edu.model.UpdateDaoImpl;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class QuokkaServiceImpl implements IQuokkaService {
	// 각 dao에 멤버필드 변수 설정
	private ISelectDao dao_select;

	public QuokkaServiceImpl() {
		dao_select = new SelectDaoImpl();
	}
	
	@Override //거래처 정보 전체조회 -한슬기
	public List<AdminVo> IDAll() {
		List<AdminVo> lists = dao_select.IDAll();
		return lists;
	}
	
	// selectPW 아이디와 이름으로 비밀번호 찾기 - 이인환
		@Override
		public AdminVo selectPW(String id, String name) { //아이디와 이름으로 비번찾기
			AdminVo vo = new AdminVo(id, null, name, null, null);
			AdminVo one = dao_select.selectPW(vo);
			return one;
		}
		
//		이름과 휴대폰번호로 아이디 찾기 - 이인환
		@Override
		public AdminVo selectID(String name, String phonenum) {
				AdminVo vo = new AdminVo(null, null, name, null, phonenum);
				AdminVo one = dao_select.selectID(vo);
				return one;
		}
		
		
//		아이디, 비밀번호 일치 여부 --이인환
		@Override
		public AdminVo Login(String id, String pw) {
			AdminVo vo = new AdminVo(id, pw, null, null, null);
			AdminVo one = dao_select.Login(vo);
			return one;
		}
		
		//계정만들기(회원가입)--이인환
		@Override
		public int insertAdmin(String id, String pw, String name, Date birthdate, String phonenum) {
			IInsertDao dao = new InsertDaoImpl();
	        AdminVo vo= new AdminVo(id, pw, name, birthdate, phonenum);
	        int row = dao.insertAdmin(vo);
	        return row;
		}
		
		//계정삭제--이인환
		@Override
		public int deleteAdmin(AdminVo vo) {
			IDeleteDao dao = new DeleteDaoImpl();
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("id", "Test");
			int row = dao.deleteAdmin(map);
			assertEquals(row, 1);
			return row;
		}
		
		
		//비밀번호 변경--이인환
		public int updatePw(String newp, String oldp) {
			IUpdateDao dao = new UpdateDaoImpl();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("newpw", newp);
			map1.put("oldpw", oldp);
			int row = dao.updatePw(map1);
			assertEquals(row, 1);
			return row;
		}
		
	

}
