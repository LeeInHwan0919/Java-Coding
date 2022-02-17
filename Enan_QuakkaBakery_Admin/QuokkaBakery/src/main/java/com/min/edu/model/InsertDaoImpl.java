package com.min.edu.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;

public class InsertDaoImpl implements IInsertDao {
	
	private final String NS = "com.min.edu.model.InsertDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();


	@Override
	public int insertAdmin(AdminVo vo) {
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"insertAdmin", vo);
		return row;
	}
	
	
}
