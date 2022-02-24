package com.min.edu.model;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;


public class SelectDaoImpl implements ISelectDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.SelectDaoImpl.";


	
	@Override
	public List<AdminVo> IDAll() {
		SqlSession session = manager.openSession();
		return session.selectList(NS + "IDAll");
	}

	
	// Admin 이름과 생년 월일로 비밀번호 찾기
	@Override
	public AdminVo selectPW(AdminVo vo) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "selectPW", vo);
	}

//		 Admin 이름과 전화번호로 아이디 찾기 select
	@Override
	public AdminVo selectID(AdminVo vo) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "selectID", vo);
	}

	// 아이디, 비밀번호 일치 여부 
	@Override
	public AdminVo Login(AdminVo vo) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "Login", vo);
		
	}



	
	

}
