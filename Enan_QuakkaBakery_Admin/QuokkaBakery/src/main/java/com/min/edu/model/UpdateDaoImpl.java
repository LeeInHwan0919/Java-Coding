package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;

public class UpdateDaoImpl implements IUpdateDao {
	private final String NS = "com.min.edu.model.UpdateDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();

	// 비밀번호 변경 update
	@Override
	public int updatepw(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.update(NS + "updatepw", map);
		return row;
	}

}
