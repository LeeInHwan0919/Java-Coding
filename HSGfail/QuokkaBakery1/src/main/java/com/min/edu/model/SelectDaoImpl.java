package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;

public class SelectDaoImpl implements ISelectDao{

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();	
	private final String NS = "com.min.edu.model.SelectDaoImpl.";

	@Override
	public List<AccountVo> selectAll() {//거래처 전체 조회 -한슬기
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAll");
	}
	@Override
	public AccountVo selectAcName(Object ac_name) {//거래처명으로 조회 -한슬기
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectAcName", ac_name);
		return vo;
	}
	@Override
	public AccountVo selectAcTel(Object ac_tel) { //거래처 전화번호로 조회 -한슬기
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectAcTel", ac_tel);
		return vo;
	}
	@Override
	public AccountVo selectAcRegnum(Object ac_regnum) { //사업자등록번호로 조회 -한슬기
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectAcRegnum", ac_regnum);
		return vo;
	}
	@Override
	public AccountVo selectCEO(Object ceo_name) { // 대표명으로 조회 -한슬기
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectCEO", ceo_name);
		return vo;
	}
	@Override
	public AccountVo selectAcCode(Object ac_code) {
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectAcCode", ac_code);
		return vo;
	}

}
