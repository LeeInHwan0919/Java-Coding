package com.min.test;

import static org.junit.Assert.*;

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
import com.min.edu.vo.AdminVo;

public class MyBatis_JUnit4 {

	SqlSession session;
	ISelectDao dao = new SelectDaoImpl();

	@Before
	public void creatSession() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		session = manager.openSession();
		assertNotNull(session);
	}

//	@Test
	public void selectPW() {
		int n = dao.selectPW("Goobee");
		System.out.println("Goobee의 " + n);
		assertNotNull(n);
	}

//아이디찾기 select
//	@Test
	public void selectID() {
		int n = dao.selectID("ccc");
		System.out.println("ccc의 " + n);
		assertNotNull(n);
	}

//비밀번호 변경 update
//	@Test
	public void updatepw() {
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newpw", "456");
		map.put("oldpw", "777");
		int row = dao.updatepw(map);
		assertEquals(row, 1);
	}

	//Admin삭제 delete
//	@Test
	public void deleteAdmin() {
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "123");
		int row = dao.deleteAdmin(map);
		assertEquals(row, 1);
	}
	//Admin계정 추가
//	@Test
	public void insertAdmin() {
		IInsertDao dao = new InsertDaoImpl();
		AdminVo vo = new AdminVo("Test", "test");
		int row = dao.insertAdmin(vo);
		assertEquals(row, 1);
	}
	
//	@Test
	public void deleteB() {
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ac_name", "민균백화점");
		int row = dao.deleteB(map);
		assertEquals(row, 1);
	}
	
	@Test
	public void deleteC() {
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ac_tel", "010111111111");
		int row = dao.deleteC(map);
		assertEquals(row, 1);
	}
}
