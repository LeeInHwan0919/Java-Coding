package com.min.edu.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class InsertDaoImpl implements IInsertDao {
	
	private final String NS = "com.min.edu.model.InsertDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	//계정추가 - 이인환
	@Override
	public int insertAdmin(AdminVo vo) {
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"insertAdmin", vo);
		return row;
	}
	
	
}
