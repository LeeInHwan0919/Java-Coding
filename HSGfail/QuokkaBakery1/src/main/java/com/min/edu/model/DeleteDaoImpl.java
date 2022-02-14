package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;

public class DeleteDaoImpl implements IDeleteDao{
	
	private final String NS = "com.min.edu.model.DeleteDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();

	@Override
	public int deleteAcName(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		// Map을 parameter로 사용할때는 key를 정확하게 입력
		int row = session.delete(NS+"deleteAcName", map);
		return row;
	}

	@Override
	public int deleteAcTel(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		// Map을 parameter로 사용할때는 key를 정확하게 입력
		int row = session.delete(NS+"deleteAcTel", map);
		return row;
	}

}
