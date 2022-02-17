package com.min.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.DeleteDaoImpl;
import com.min.edu.model.IDeleteDao;
import com.min.edu.model.IInsertDao;

import com.min.edu.model.ISelectDao;
import com.min.edu.model.IUpdateDao;
import com.min.edu.model.InsertDaoImpl;

import com.min.edu.model.SelectDaoImpl;
import com.min.edu.model.UpdateDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;

public class MyBatis_JUnit4 {

	
	SqlSession session;
	ISelectDao dao = new SelectDaoImpl();
		
	
	@Before
	public void creatSession() {
		SqlSessionFactory manager =  SqlSessionFactoryManager.getFactory();
		session = manager.openSession();
		assertNotNull(session);
     }
	
//	@Test
	public void selectAll() { //거래처 전체조회 -한슬기
		List<AccountVo> lists = dao.selectAll();
		System.out.println(lists);
		assertNotNull(lists);
	}
//	@Test
	public void selectAcName() { // 거래처명으로 조회 - 한슬기
		String str = "슬기슈퍼마켓";
		Object obj = str;
		AccountVo vo = dao.selectAcName(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectAcTel() { // 거래처 전화번호로 조회 - 한슬기
		String str = "01098761234";
		Object obj = str;
		AccountVo vo = dao.selectAcTel(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectAcRegnum() { // 사업자등록번호로 조회 - 한슬기
		String str = "1234567890";
		Object obj = str;
		AccountVo vo = dao.selectAcRegnum(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectCEO() { // 사업자등록번호로 조회 - 한슬기
		String str = "완벽한남자김휘웅";
		Object obj = str;
		AccountVo vo = dao.selectCEO(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectAcCode() { // 사업자등록번호로 조회 - 한슬기
		String str = "3";
		Object obj = str;
		AccountVo vo = dao.selectAcCode(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
	
	
//	@Test
	public void insert01() { //거래처 정보 추가 - 한슬기
		IInsertDao dao = new InsertDaoImpl();
		AccountVo vo = new AccountVo(7, "우연백화점", "1234567895", "01011111116","김우연");	
		int row =dao.insert01(vo);
		assertEquals(row, 1);	
	}
	
	
//	@Test
	public void updateAcName() { //거래처명 변경 -한슬기
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("new_acname","슬기청과");
		map.put("old_acname","슬기마트");
		int row =dao.updateAcName(map);
		assertEquals(row, 1);
	}
//	@Test
	public void updateAcTel() { //거래처 전화번호 변경 -한슬기
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("new_tel","01098761234");
		map.put("old_tel","010111111112");
		int row =dao.updateAcTel(map);
		assertEquals(row, 1);
	}
//	@Test
	public void updateCEO() { //거래처 전화번호 변경 -한슬기
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("new_ceo","완벽한남자김휘웅");
		map.put("old_ceo","김휘웅");
		int row =dao.updateCEO(map);
		assertEquals(row, 1);
	}
	
	@Test 
	public void deleteAcName() {// 거래처이름으로 조회하여 삭제 -한슬기
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ac_name", "민균백화점");
		int row = dao.deleteAcName(map);
		assertEquals(row, 1);
	}
//	@Test 
	public void deleteAcTel() {// 거래처전화번호로 조회하여 삭제 -한슬기
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ac_tel", "010111111115");
		int row = dao.deleteAcTel(map);
		assertEquals(row, 1);
	}

	
}
	
