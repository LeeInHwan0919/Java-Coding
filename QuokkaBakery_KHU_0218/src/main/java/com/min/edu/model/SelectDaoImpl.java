package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class SelectDaoImpl implements ISelectDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.SelectDaoImpl.";

	// Admin 이름과 생년 월일로 비밀번호 찾기
//		@Override
//		 public List<AdminVo> selectPW(AdminVo vo) {
//			SqlSession session = manager.openSession();
//	        List<AdminVo> one = session.selectOne(NS+"selectPW", vo);
//			return one;
//		}

	@Override
	public AdminVo selectPW(AdminVo vo) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "selectPW", vo);
	}

//		 Admin 이름과 전화번호로 아이디 찾기 select
	@Override
	public AdminVo selectID(AdminVo vo) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "selectID", vo);
	}

	// 아이디, 비밀번호 일치 여부 
	@Override
	public AdminVo Login(AdminVo vo) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS + "Login", vo);
		
	}

	// 거래처 전체 조회
	@Override
	public List<AccountVo> selectAll() {// 거래처 전체 조회 -한슬기
		SqlSession session = manager.openSession();
		return session.selectList(NS + "selectAll");
	}

	@Override
	public AccountVo selectAcName(Object ac_name) {// 거래처명으로 조회 -한슬기
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectAcName", ac_name);
		return vo;
	}

	@Override
	public AccountVo selectAcTel(Object ac_tel) { // 거래처 전화번호로 조회 -한슬기
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectAcTel", ac_tel);
		return vo;
	}

	@Override
	public AccountVo selectAcRegnum(Object ac_regnum) { // 사업자등록번호로 조회 -한슬기
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
	public AccountVo selectAcCode(Object ac_code) { // 거래처 코드 조회
		SqlSession session = manager.openSession();
		AccountVo vo = session.selectOne(NS + "selectAcCode", ac_code);
		return vo;
	}

	@Override // 황인경
	public GoodsVo selectGoodsCode(Object g_code) {
		SqlSession session = manager.openSession();
		GoodsVo vo = session.selectOne(NS + "selectGoodsCode", g_code);
		return vo;
	}

	@Override // 황인경
	public GoodsVo selectGoodsName(Object g_name) {
		SqlSession session = manager.openSession();
		GoodsVo vo = session.selectOne(NS + "selectGoodsName", g_name);
		return vo;
	}

	@Override // 황인경
	public List<GoodsVo> selectGoodsAll() {
		SqlSession session = manager.openSession();
		return session.selectList(NS + "selectGoodsAll");
	}

	// INVENTORY 재고 전체조회
	@Override
	public List<InventoryVo> selectInventory() {
		SqlSession session = manager.openSession();
		return session.selectList(NS + "selectInventory");
	}
	// 김휘웅 선택조회
	@Override
	public InventoryVo selectInventory02(Object g_name) {
		SqlSession session = manager.openSession();
		InventoryVo vo = session.selectOne(NS + "selectInventory02", g_name);
		return vo;
	}

}
