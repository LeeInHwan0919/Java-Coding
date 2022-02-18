package com.min.edu.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.model.DeleteDaoImpl;
import com.min.edu.model.IDeleteDao;
import com.min.edu.model.IInsertDao;
import com.min.edu.model.ISelectDao;
import com.min.edu.model.IUpdateDao;
import com.min.edu.model.InsertDaoImpl;
import com.min.edu.model.SelectDaoImpl;
import com.min.edu.model.UpdateDaoImpl;
import com.min.edu.vo.AccountVo;

public class QuokkaServiceImpl implements IQuokkaService {
	private Logger logger = Logger.getLogger(this.getClass());
	// 각 dao에 멤버필드 변수 설정
	private IInsertDao dao_insert;//
	private ISelectDao dao_select;
	
	public QuokkaServiceImpl() {
		dao_select = new SelectDaoImpl();
	}
	
	@Override //거래처 추가 -한슬기
	public int insertAccount(AccountVo vo) {
		logger.info("거래처 추가");
		IInsertDao dao = new InsertDaoImpl();
		AccountVo vo1 = new AccountVo(11, "투썸플레이스", "1234567800", "0314529380","한금");	
		int row =dao.insertAccount(vo1);
		assertEquals(row, 1);
		return row;
	}

	@Override //거래처 삭제 -한슬기
	public int deleteAcName(Map<String, Object> map) {
		logger.info("거래처 삭제");
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map1 = new HashMap<String,Object>();
		map1.put("ceo_name", "장재영");
		int row = dao.deleteCEO(map1);
		assertEquals(row, 1);
		return row;
	}

	@Override //거래처 정보 전체조회 -한슬기
	public List<AccountVo> selectAll() {
		logger.info("거래처 정보 전체조회");
		List<AccountVo> lists = dao_select.selectAll();
		System.out.println(lists);
		assertNotNull(lists);
		return lists;
	}

	@Override //거래처이름으로 거래처 정보조회 -한슬기
	public AccountVo selectAcName(Object ac_name) {
		logger.info("이름으로 거래처 조회");
		String str = "슬기청과";
		Object obj = str;
		AccountVo vo = dao_select.selectAcName(obj);
		System.out.println(vo);
		assertNotNull(vo);
		return vo;
	}

	@Override //대표명으로 거래처 정보 조회 -한슬기
	public AccountVo selectCEO(Object ceo_name) {
		logger.info("대표명으로 거래처 조회");
		String str = "완벽한남자김휘웅";
		Object obj = str;
		AccountVo vo = dao_select.selectCEO(obj);
		System.out.println(vo);
		assertNotNull(vo);
		return vo;
	}

	@Override //거래처명 업데이트 -한슬기
	public int updateAcName(Map<String, Object> map) {
		logger.info("거래처명 업데이트");
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("new_acname","슬기마트");
		map1.put("old_acname","슬기청과");
		int row =dao.updateAcName(map1);
		assertEquals(row, 1);
		return row;
	}

	@Override //거래처전화번호 업데이트 -한슬기
	public int updateAcTel(Map<String, Object> map) {
		logger.info("거래처 전화번호 업데이트");
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("new_tel","01033334444");
		map1.put("old_tel","01011111116");
		int row =dao.updateAcTel(map1);
		assertEquals(row, 1);
		return row;
	}

	@Override //대표명 업데이트 -한슬기
	public int updateCEO(Map<String, Object> map) {
		logger.info("대표명 업데이트");
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("new_ceo","김휭");
		map1.put("old_ceo","완벽한남자김휘웅");
		int row =dao.updateCEO(map1);
		assertEquals(row, 1);
		return row;
	}

}
