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
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class QuokkaServiceImpl implements IQuokkaService {
	private Logger logger = Logger.getLogger(this.getClass());
	// 각 dao에 멤버필드 변수 설정
	private IInsertDao dao_insert;
	private ISelectDao dao_select;

	public QuokkaServiceImpl() {
		dao_select = new SelectDaoImpl();
	}
	
	// selectPW 아이디와 이름으로 비밀번호 찾기 - 이인환
		@Override
		public AdminVo selectPW() { //아이디와 이름으로 비번찾기
			AdminVo vo = new AdminVo("Goobee", null , "이인환", null , null);
			AdminVo one = dao_select.selectPW(vo);
			return one;
		}
		
//		이름과 휴대폰번호로 아이디 찾기 - 이인환
		@Override
		public AdminVo selectID() {
				AdminVo vo = new AdminVo(null, null , "이인환", null , "01012345678");
				AdminVo one = dao_select.selectID(vo);
				return one;
		}
		
//		아이디, 비밀번호 일치 여부 --이인환
		@Override
		public AdminVo Login() {
			AdminVo vo = new AdminVo("Goobee", "456123", null, null, null);
			AdminVo one = dao_select.Login(vo);
			return one;
		}
		
		//계정만들기(회원가입)--이인환
		@Override
		public int insertAdmin(AdminVo vo) {
			IInsertDao dao = new InsertDaoImpl();
	        AdminVo vo1= new AdminVo("koka","7894","김휘웅","1987-08-07","01078945612");
	        int row = dao.insertAdmin(vo1);
	        assertEquals(row, 1);
	        return row;
		}
		
		//계정삭제--이인환
		@Override
		public int deleteAdmin(AdminVo vo) {
			IDeleteDao dao = new DeleteDaoImpl();
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("id", "Test");
			int row = dao.deleteAdmin(map);
			assertEquals(row, 1);
			return row;
		}
		
		
		//비밀번호 변경--이인환
		public int updatePw() {
			IUpdateDao dao = new UpdateDaoImpl();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("newpw", "1022");
			map1.put("oldpw", "7894");
			int row = dao.updatePw(map1);
			assertEquals(row, 1);
			return row;
		}
		
		
		
		
	// selectInventory(재고 전체출력) 김휘웅
	@Override
	public List<InventoryVo> selectInventory() {
		logger.info("재고 전체 조회");
		List<InventoryVo> lists = dao_select.selectInventory();
		System.out.println(lists);
		assertNotNull(lists);
		return lists;
	}

	// selectInventory02(재고 선택출력) 김휘웅
	@Override
	public InventoryVo selectInventory02(Object g_name) {
		String str = "감자깡";
		Object obj = str;
		InventoryVo vo = dao_select.selectInventory02(obj);
		System.out.println(vo);
		assertNotNull(vo);
		return vo;
	}

	// insertInventory01(재고 삽입 GOODS에 들어가있는 상품의 코드와 상품명에 맞춰서 입력) 김휘웅
	@Override
	public int insertInventory01(InventoryVo vo) {
		IInsertDao dao = new InsertDaoImpl();
		InventoryVo vo1 = new InventoryVo("ABC1234560", "무지개깡", 1, "2022-02-10");
		int row = dao.insertInventory01(vo1);
		assertEquals(row, 1);
		return row;

	}

	// updateInventory 김휘웅 재고 수정(상품명을 입력하여 재고의 수량을 수정)
	@Override
	public int updateInventory(Map<String, Object> map) {
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("newcode", "300");
		map1.put("oldcode", "새우깡");
		int row = dao.updateInventory(map1);
		assertEquals(row, 1);
		return row;
	}

	


	

	// 황인경
		@Override
		public List<GoodsVo> selectGoodsAll() {
			logger.info("상품 전체 조회");
			List<GoodsVo> listsG = dao_select.selectGoodsAll();
			System.out.println(listsG);
			assertNotNull(listsG);
			return listsG;
		}
		// 황인경 상품코드로 조회
		@Override
		public GoodsVo selectGoodsCode(Object g_code) {
			String str = "ABC1234560";
			Object obj = str;
			GoodsVo vo = dao_select.selectGoodsCode(obj);
			System.out.println(vo);
			assertNotNull(vo);
			return vo;
		}
		// 황인경 상품이름으로 조회
		@Override
		public GoodsVo selectGoodsName(Object g_name) {
			String str = "무지개깡";
			Object obj = str;
			GoodsVo vo = dao_select.selectGoodsName(obj);
			System.out.println(vo);
			assertNotNull(vo);
			return vo;
		}
		// 황인경 상품 추가
		@Override
		public int insertGoods(GoodsVo vo) {
			IInsertDao dao = new InsertDaoImpl();
			GoodsVo voGI = new GoodsVo("ABD1234567", "붕어싸만코", 1500);
			int row = dao.insertGoods(voGI);
			assertEquals(row, 1);
			return row;

		}
		// 황인경 상품가격 업데이트 
		@Override
		public int updateGoodsPrice(Map<String, Object> map) {
			IUpdateDao dao = new UpdateDaoImpl();
			Map<String, Object> mapGU = new HashMap<String, Object>();
			mapGU.put("newprice", "3000");
			mapGU.put("g_name", "붕어싸만코");
			int row = dao.updateGoodsPrice(mapGU);
			assertEquals(row, 1);
			return row;
		}
		// 황인경 상품가격 삭제 
		@Override
		public int deleteGoods(Map<String, Object> map) {
			IDeleteDao dao = new DeleteDaoImpl();
			Map<String, Object> mapGD = new HashMap<String, Object>();
			mapGD.put("g_name", "붕어싸만코");
			int row = dao.deleteGoods(mapGD);
			assertEquals(row, 1);
			return row;
		}
		
		
		
		
		
		
		@Override //거래처 추가 -한슬기
		public int insertAccount(AccountVo vo) {
			logger.info("거래처 추가");
			IInsertDao dao = new InsertDaoImpl();
			AccountVo vo1 = new AccountVo(1, "할리스", "1234567777", "0444529380","한은");	
			int row =dao.insertAccount(vo1);
			assertEquals(row, 1);
			return row;
		}

		@Override //거래처 삭제 -한슬기
		public int deleteAcName(Map<String, Object> map) {
			logger.info("거래처 삭제");
			IDeleteDao dao = new DeleteDaoImpl();
			Map<String, Object> map1 = new HashMap<String,Object>();
			map1.put("ac_name", "할리스커피");
			int row = dao.deleteAcName(map1);
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
			String str = "휘웅백화점";
			Object obj = str;
			AccountVo vo = dao_select.selectAcName(obj);
			System.out.println(vo);
			assertNotNull(vo);
			return vo;
		}

		@Override //대표명으로 거래처 정보 조회 -한슬기
		public AccountVo selectCEO(Object ceo_name) {
			logger.info("대표명으로 거래처 조회");
			String str = "한금";
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
			map1.put("new_acname","할리스커피");
			map1.put("old_acname","투썸플레이스");
			int row =dao.updateAcName(map1);
			assertEquals(row, 1);
			return row;
		}

		@Override //거래처전화번호 업데이트 -한슬기
		public int updateAcTel(Map<String, Object> map) {
			logger.info("거래처 전화번호 업데이트");
			IUpdateDao dao = new UpdateDaoImpl();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("new_tel","01033097483");
			map1.put("old_tel","010111111112");
			int row =dao.updateAcTel(map1);
			assertEquals(row, 1);
			return row;
		}

		@Override //대표명 업데이트 -한슬기
		public int updateCEO(Map<String, Object> map) {
			logger.info("대표명 업데이트");
			IUpdateDao dao = new UpdateDaoImpl();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("new_ceo","김흉");
			map1.put("old_ceo","김휘웅");
			int row =dao.updateCEO(map1);
			assertEquals(row, 1);
			return row;
		}



}
