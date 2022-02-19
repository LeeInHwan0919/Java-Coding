package com.min.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.DeleteDaoImpl;
import com.min.edu.model.IDeleteDao;
import com.min.edu.model.IInsertDao;
import com.min.edu.model.ISelectDao;
import com.min.edu.model.IUpdateDao;
import com.min.edu.model.InsertDaoImpl;
import com.min.edu.model.SelectDaoImpl;
import com.min.edu.model.UpdateDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class MyBatis_JUnit4 {

	SqlSession session;
	ISelectDao dao = new SelectDaoImpl();

	@Before
	public void creatSession() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		session = manager.openSession();
		assertNotNull(session);
	}

//	@Test
	public void selectPW() { //아이디와 이름으로 비번찾기
		AdminVo vo = new AdminVo("Goobee", null , "이인환", null , null);
		AdminVo one = dao.selectPW(vo);
//		System.out.println(one.get(0));
//		assertEquals("결과값 있음", one.size(), 1);
	}
//	@Test // 이름과 휴대폰번호로 아이디 찾기
	public void selectID() {
		AdminVo vo = new AdminVo(null, null , "꽈자와자", null , "01012345678");
		AdminVo one = dao.selectID(vo);
//		System.out.println(one.get(0));
//		assertEquals("결과값 있음", one.size(), 1);
	}
	
//	@Test // 아이디, 비밀번호 일치 여부 > count
	public void Login() {
		AdminVo vo = new AdminVo("Goobee", "456123", null, null, null);
		AdminVo one = dao.Login(vo);
//		System.out.println(one.get(0));
//		assertEquals("결과값 있음", one.size(), 1);
	}
	
	

//비밀번호 변경 update
//	@Test
	public void updatePw() {
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newpw", "456");
		map.put("oldpw", "456123");
		int row = dao.updatePw(map);
		assertEquals(row, 1);
	}

	// Admin삭제 delete
//	@Test
	public void deleteAdmin() {
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "Test");
		int row = dao.deleteAdmin(map);
		assertEquals(row, 1);
	}
	//Admin계정 추가
//    @Test
    public void insertAdmin() {
        IInsertDao dao = new InsertDaoImpl();
        AdminVo vo = new AdminVo("Test", "test", "한슬기","1993-08-16","01012345679");
        int row = dao.insertAdmin(vo);
        assertEquals(row, 1);
        
    }

//	@Test
	public void selectAll() { //거래처 전체조회 -한슬기
		List<AccountVo> lists = dao.selectAll();
		System.out.println(lists);
		assertNotNull(lists);
		String[] a = lists.toString().split("[,=]");
		
		for (int i = 0; i < a.length; i++) {
			if(i%2!=0) {
			System.out.println(a[i]);
			}
		}
	}
//	@Test
	public void selectAcName() { // 거래처명으로 조회 - 한슬기
		String str = "슬기청과";
		Object obj = str;
		AccountVo vo = dao.selectAcName(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectAcTel() { // 거래처 전화번호로 조회 - 한슬기
		String str = "010111111111";
		Object obj = str;
		AccountVo vo = dao.selectAcTel(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectAcRegnum() { // 사업자등록번호로 조회 - 한슬기
		String str = "1234567890";
		Object obj = str;
		AccountVo vo = dao.selectAcRegnum(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectCEO() { // 사업자등록번호로 조회 - 한슬기
		String str = "완벽한남자김휘웅";
		Object obj = str;
		AccountVo vo = dao.selectCEO(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test
	public void selectAcCode() { // 사업자등록번호로 조회 - 한슬기
		String str = "3";
		Object obj = str;
		AccountVo vo = dao.selectAcCode(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
	
	
//	@Test
	public void insertAccount() { //거래처 정보 추가 - 한슬기
		IInsertDao dao = new InsertDaoImpl();
		AccountVo vo = new AccountVo(10, "아미유", "1234567898", "0314567891","김고양");	
		int row =dao.insertAccount(vo);
		assertEquals(row, 1);	
	}
	
	
//	@Test
	public void updateAcName() { //거래처명 변경 -한슬기
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("new_acname","슬기마트");
		map.put("old_acname","슬기청과");
		int row =dao.updateAcName(map);
		assertEquals(row, 1);
	}
//	@Test
	public void updateAcTel() { //거래처 전화번호 변경 -한슬기
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("new_tel","01098761234");
		map.put("old_tel","010111111112");
		int row =dao.updateAcTel(map);
		assertEquals(row, 1);
	}
//	@Test
	public void updateCEO() { //거래처 대표자 변경 -한슬기
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("new_ceo","완벽한남자김휘웅");
		map.put("old_ceo","김휘웅");
		int row =dao.updateCEO(map);
		assertEquals(row, 1);
	}
	
//	@Test 
	public void deleteAcName() {// 거래처이름으로 조회하여 삭제 -한슬기
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ac_name", "아미유");
		int row = dao.deleteAcName(map);
		assertEquals(row, 1);
	}
//	@Test 
	public void deleteAcTel() {// 거래처전화번호로 조회하여 삭제 -한슬기
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ac_tel", "010111111115");
		int row = dao.deleteAcTel(map);
		assertEquals(row, 1);
	}
	
//	@Test 
	public void deleteCEO() {// 거래처대표명으로 조회하여 삭제 -한슬기
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ceo_name", "김고양");
		int row = dao.deleteCEO(map);
		assertEquals(row, 1);
	}
//	@Test //황인경
	public void selectGoodsName() {
		String str = "새우깡";
		Object obj = str;
		GoodsVo vo = dao.selectGoodsName(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test //황인경
	public void selectGoodsCode() {
		String str = "ABC1234568";
		Object obj = str;
		GoodsVo vo = dao.selectGoodsCode(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
//	@Test //황인경
	public void selectGoodsAll() {
		List<GoodsVo> lists = dao.selectGoodsAll();
		System.out.println(lists);
		assertNotNull(lists);
	}
//	@Test // 황인경
	public void updateGoodsPrice() {
		IUpdateDao dao = new UpdateDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("g_name","새우깡" );
		map.put("newprice", "5000");
		int row = dao.updateGoodsPrice(map);
		assertEquals(row, 1);
	}
//	@Test // 황인경
	public void insertGoods() {
		IInsertDao dao = new InsertDaoImpl();
		GoodsVo vo = new GoodsVo("ABC1234570","바밤바", 700);
		int row = dao.insertGoods(vo);
		assertEquals(row, 1);
	}
	
//	@Test // 황인경
	public void deleteGoods() {
		IDeleteDao dao = new DeleteDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("g_name", "바밤바");
		int row = dao.deleteGoods(map);
		assertEquals(row, 1);
	}
//	 김휘웅 재고 조회(재고 전체 조회)
//		@Test
		public void selectInventory() {
			List<InventoryVo> lists = dao.selectInventory();
			System.out.println(lists);
			assertNotNull(lists);
		}
		// 김휘웅 재고 선택 조회
//		@Test
		public void selectInventory02() {
			String str = "새우깡";
			Object obj = str;
			InventoryVo vo = dao.selectInventory02(obj);
			System.out.println(vo);
			assertNotNull(vo);
		}
		
		// 김휘웅 재고 수정(상품명을 입력하여 재고의 수량을 수정)
//		@Test
		public void updateInventory() {
			IUpdateDao dao = new UpdateDaoImpl();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("newcode", "60");
			map.put("oldcode", "새우깡");
			int row = dao.updateInventory(map);
			assertEquals(row, 1);
		}
		// 김휘웅 재고 입력 (상품코드 상품명 수량 최근입고일) 상품코드, 상품명 : FK이기때문에 GOODS에서 조회후 넣으면 된다
		@Test
		public void insertInventory01() {
			IInsertDao dao = new InsertDaoImpl();
			InventoryVo vo = new InventoryVo("ABC1234569", "감자깡", 50);			
			int row = dao.insertInventory01(vo);
			assertEquals(row, 1);
		}
}
