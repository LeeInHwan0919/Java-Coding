package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;

public class DeleteDaoImpl implements IDeleteDao {
	
	private final String NS="com.min.edu.model.DeleteDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	


	@Override
	public int deleteAdmin(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteAdmin", map);
		return row;
	}



	@Override
	public int deleteB(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteB", map);
		return row;
	}



	@Override
	public int deleteC(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteC", map);
		return row;
	}


}
