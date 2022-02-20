package com.min.edu.ctrl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.min.edu.service.IQuokkaService;
import com.min.edu.service.QuokkaServiceImpl;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class QuokkaController {

	private Logger logger = Logger.getLogger(this.getClass());
	private IQuokkaService service;

	public QuokkaController() {
		service = new QuokkaServiceImpl();
	}
//ADMIN============================================================
	// selectPW 아이디와 이름으로 비밀번호 찾기 이인환
	public AdminVo selectPW() {
		logger.info("selectPW 아이디와 이름으로 비밀번호 찾기 실행");
		return service.selectPW();
	}

//	이름과 휴대폰번호로 아이디 찾기 - 이인환
	public AdminVo selectID() {
		logger.info("selectID 이름과 휴대폰번호로 아이디 찾기 실행");
		return service.selectID();
	}

//	아이디, 비밀번호 일치 여부 --이인환
	public AdminVo Login(String id, String pw) {
		logger.info("아이디, 비밀번호 일치 여부 실행");
		return service.Login(id, pw);
	}
	
	//계정생성 -이인환
	public int insertAdmin(String id, String pw, String name, String birthdate, String phonenum) {
		logger.info("계정 생성 실행");
		return service.insertAdmin(id, pw, name, birthdate, phonenum);
	}
	
	//계정삭제 -이인환
	public int deleteAdmin(AdminVo vo) {
		logger.info("계정 삭제 실행");
		return service.deleteAdmin(vo);
	}
	
	//비밀번호 변경 - 이인환
	public int updatePw(String newp, String oldp) {
		logger.info("비밀번호 변경 실행");
		return service.updatePw(newp, oldp);
	}
	
//INVENTORY============================================================	
	// selectInventory(재고 전체출력) 김휘웅
	public List<InventoryVo> commandSelectInventory() {
		logger.info("Quokka Controller 재고 전체출력 실행");
		return service.selectInventory(); // IQuokkaService selectInventory() 반환

	}

	// selectInventory02(재고 선택출력) 김휘웅
	public InventoryVo selectInventory02(String snak) {
		logger.info("Quokka Controller 재고 선택출력 실행 ");
		return service.selectInventory02(snak);
	}

	// insertInventory01(재고 삽입 GOODS에 들어가있는 상품의 코드와 상품명에 맞춰서 입력) 김휘웅
	public int insertInventory01(InventoryVo vo) {
		logger.info("Quokka Controller 재고 삽입 실행");
		return service.insertInventory01(vo);
	}

	// updateInventory 김휘웅 재고 수정(상품명을 입력하여 재고의 수량을 수정)
	public int updateInventory(Map<String, Object> map) {
		logger.info("Quokka Controller 재고 수량 수정");
		return service.updateInventory(map);

	}
	// deleteInventory 김휘웅 재고 삭제
	public int deleteInventory(Map<String, Object> map) {
		logger.info("Quokka Controller 재고 삭제 실행 ");
		return service.deleteInventory(map);
		
	}
	//ACCOUNT============================================================
	//거래처 추가 -한슬기
		public int insertAccount(AccountVo vo) {
			logger.info("거래처정보 추가 실행");
			return service.insertAccount(vo);
		}
		
		
		//거래처이름으로 삭제 -한슬기
		public int deleteAcName(Map<String, Object> map){
			logger.info("거래처정보 삭제 실행");
			return service.deleteAcName(map);		
		}	

		
		//거래처 전체 출력 -한슬기
		public List<AccountVo> selectAll(){
			logger.info("거래처 전체 출력실행");
			return service.selectAll();	
		}
		//거래처 이름으로 조회 -한슬기
		public AccountVo selectAcName (Object ac_name){
			logger.info("거래처 이름으로 조회 실행");
			return service.selectAcName(ac_name);	
		}
		//대표명으로 조회 -한슬기
		public AccountVo selectCEO (Object ceo_name){
			logger.info("대표명으로 조회 실행");
			return service.selectCEO(ceo_name);
		}
		
		
		//거래처명 업데이트 -한슬기
		public int updateAcName(Map<String, Object> map) {
			logger.info("거래처명 업데이트 실행");
			return service.updateAcName(map);
		}
		//거래처 전화번호 업데이트 -한슬기
		public int updateAcTel(Map<String, Object> map) {
			logger.info("거래처 전화번호 업데이트 실행");
			return service.updateAcTel(map);
		}
		//거래처 대표명으로 조회 -한슬기
		public int updateCEO(Map<String, Object> map) {
			logger.info("거래처 대표명 업데이트 실행");
			return service.updateCEO(map);		
		}
		
		//GOODS============================================================
		
		//selectGoodsAll(상품 전체조회) 황인경
				public List<GoodsVo> commandSelectGoods() {
					logger.info("Quokka Controller 상품 전체출력 실행");
					return service.selectGoodsAll(); //IQuokkaService selectGoodsAll() 반환
					
				}
			//selectGoodsCode(상품 코드로 선택조회) 황인경
				public GoodsVo selectGoodsCode(Object g_code) {
					logger.info("Quokka Controller 상품코드 선택조회 실행");
					return service.selectGoodsCode(g_code);
				}
				
			//selectGoodName(상품 이름으로 선택조회) 황인경
				public GoodsVo selectGoodsName(Object g_name) {
					logger.info("Quokka Controller 상품이름 선택조회 실행");
					return service.selectGoodsCode(g_name);
				}
			//insertGoods(상품 추가 실행) 황인경	
				public int insertGoods(GoodsVo vo) {
					logger.info("Quokka Controller 상품 추가 실행 ");
					return service.insertGoods(vo);
				}
			//updateGoods(상품 가격 수정 실행) 황인경	
				public int updateGoodsPrice(Map<String, Object> map) {
					logger.info("Quokka Controller 상품 가격 수정 실행 ");
					return service.updateGoodsPrice(map);
				}
			//deleteGoods(상품 삭제 실행) 황인경	
				public int deleteGoods(Map<String, Object> map) {
					logger.info("Quokka Controller 상품 삭제 실행 ");
					return service.deleteGoods(map);
					
				}
				
}
