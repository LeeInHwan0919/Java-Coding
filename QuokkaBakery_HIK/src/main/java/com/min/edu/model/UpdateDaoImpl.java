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
		
	// Account Update 
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
	//황인경
	@Override
	public int updateGoodsPrice(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"updateGoodsPrice", map);
		return row;
	}
	
	// 김휘웅 재고 수정
		@Override
		public int updateInventory(Map<String, Object> map) {
			SqlSession session = manager.openSession(true);
			int row = session.update(NS+"updateInventory", map);
			return row;
		}

}
