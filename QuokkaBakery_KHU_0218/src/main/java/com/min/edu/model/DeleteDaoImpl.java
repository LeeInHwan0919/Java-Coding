package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;

public class DeleteDaoImpl implements IDeleteDao {
	
	private final String NS="com.min.edu.model.DeleteDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	

	//ID에 해당하는 계정 삭제--이인환
	@Override
	public int deleteAdmin(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteAdmin", map);
		return row;
	}

	//거래처--한슬기
	@Override
	public int deleteAcName(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteAcName", map);
		return row;
	}
	//거래처--한슬기
	@Override
	public int deleteAcTel(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteAcTel", map);
		return row;
	}
	//거래처--한슬기
	@Override
	public int deleteCEO(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteCEO", map);
		return row;
	}
	
	@Override// 황인경
	public int deleteGoods(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteGoods", map);
		return row;
	}
	
	//재고--김휘웅
		@Override
		public int deleteInventory(Map<String, Object> map) {
			SqlSession session = manager.openSession(true);
			int row = session.delete(NS+"deleteInventory", map);
			return row;
		}
	
	

}
