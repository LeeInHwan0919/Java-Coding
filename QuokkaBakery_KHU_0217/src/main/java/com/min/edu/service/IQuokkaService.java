package com.min.edu.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

/**
 * 여러개의 DAO를 조합하여 처리하는 interface
 * 
 *
 */

public interface IQuokkaService {
	
	/**
	 * 두개의 동작인 insert와 select를 묶어서 실행 시켜 주는 메소드
	 * @param vo 전달 값 그리고 selectkey의 대상이 되는 setSeq()가지고 있는 객체
	 * @return 입력한 row의 select된 결과
	 */
	//selectInventory(재고 전체출력) 김휘웅
	public List<InventoryVo> selectInventory();
	//selectInventory02(재고 선택출력) 김휘웅
	public InventoryVo selectInventory02(Object g_name);
	//insertInventory01(재고 삽입 GOODS에 들어가있는 상품의 코드와 상품명에 맞춰서 입력) 김휘웅 
	public int insertInventory01(InventoryVo vo);
	//updateInventory(재고의 수량을 수정)
	public int updateInventory(Map<String, Object> map);
	
	
	
	// selectPW 아이디와 이름으로 비밀번호 찾기 - 이인환
	public AdminVo selectPW();
	//	이름과 휴대폰번호로 아이디 찾기 - 이인환
	public AdminVo selectID();
    //	아이디, 비밀번호 일치 여부 --이인환
	public AdminVo Login();
	// 계정 추가(회원가입) --이인환
	public int insertAdmin(AdminVo vo);
	//계정삭제 -- 이인환
	public int deleteAdmin(AdminVo vo);	
	//비밀번호 변경 -- 이인환
	public int updatePw();
	
	
	
	public GoodsVo selectGoodsCode(Object g_code); //황인경 
	public GoodsVo selectGoodsName(Object g_name); //황인경 
	public List<GoodsVo> selectGoodsAll(); //황인경 
	public int insertGoods(GoodsVo vo);// 황인경
	public int updateGoodsPrice (Map<String, Object> map);// 황인경
	public int deleteGoods(Map<String, Object> map);// 황인경
	
	
	
	//거래처 추가
		public int insertAccount(AccountVo vo);
		//거래처 삭제
		public int deleteAcName(Map<String, Object> map);//거래처이름으로 삭제
		//거래처 조회
		public List<AccountVo> selectAll(); // 전체조회 -한슬기
		public AccountVo selectAcName (Object ac_name);//거래처명으로 조회 -한슬기
		public AccountVo selectCEO (Object ceo_name);//대표명으로 조회 -한슬기
		//거래처 정보 업데이트
		public int updateAcName(Map<String, Object> map); //거래처명 -한슬기
		public int updateAcTel(Map<String, Object> map); //거래처 전화번호 -한슬기
		public int updateCEO(Map<String, Object> map); //거래처 대표명 -한슬기
	
}
