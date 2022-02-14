package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;

public class UpdateDaoImpl implements IUpdateDao{
	
	private final String NS = "com.min.edu.model.UpdateDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();

	@Override //거래처명 -한슬기
	public int updateAcName(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"updateAcName", map);
		return row;
	}

	@Override // 거래처전화번호 -한슬기
	public int updateAcTel(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"updateAcTel", map);
		return row;
	}

	@Override // 거래처대표명 -한슬기
	public int updateCEO(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"updateCEO", map);
		return row;
	}

}
