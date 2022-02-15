package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;

public class SelectDaoImpl implements ISelectDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.SelectDaoImpl.";

	// Admin 비밀번호 찾기
	@Override
	public int selectPW(String id) {
		SqlSession session = manager.openSession();
		int n = session.selectOne(NS + "selectPW", id);
		return n;
	}

	// Admin 아이디 찾기 select
	@Override
	public int selectID(String pw) {
		SqlSession session = manager.openSession();
		int n = session.selectOne(NS + "selectID", pw);
		return n;
	}



}
