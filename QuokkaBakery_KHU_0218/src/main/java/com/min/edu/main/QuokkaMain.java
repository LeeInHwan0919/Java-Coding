package com.min.edu.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.min.edu.ctrl.QuokkaController;
import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public class QuokkaMain {
	private static AdminVo vod;
	private static AccountVo voc;
	private static InventoryVo voi;
	private static GoodsVo vog;
	private static Object obj;
	private static Map<String, Object> map = new HashMap<String, Object>();

	public static void main(String[] args) {
		QuokkaController ctrl = new QuokkaController();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("쿼카제과 물류관리 시스템입니다. 로그인 또는 회원가입을 해주세요.\n"
				+ "1. 로그인  2.회원가입  3.아이디 찾기  4.비밀번호 찾기");
		System.out.println("값 입력 : ");
		int first = scan.nextInt();
		if(first == 1) {
			System.out.println("아이디와 비밀번호를 입력하여 로그인을 해주세요.");
			
			AdminVo list3 = ctrl.Login();
			System.out.println(list3.getId().isEmpty());//값이 있다면 FALSE
			System.out.println("회원정보가 일치합니다..");
		}else if(first ==2) {
			System.out.println("회원가입을 시작합니다.\n ");
		}else if(first ==3) {
			System.out.println("아이디를 찾습니다.");
		}else if(first ==4) {
			System.out.println("비밀번호를 찾습니다.");
		}else {
			System.out.println("다시 입력해주세요.");
		}
		
		// selectPW 아이디와 이름으로 비밀번호 찾기 이인환
//		AdminVo list = ctrl.selectPW();
//		System.out.println(list);
//		System.out.println(list.getPw());
//		System.out.println("비밀번호 찾아드렸습니다.");
	
//		 이름과 전화번호로 아이디 찾기
//		AdminVo list2 = ctrl.selectID();
//		System.out.println(list2.getId());
//		System.out.println("아이디를 찾아드렸습니다.");
		
//		아이디, 비밀번호 일치 여부 --이인환
//		AdminVo list3 = ctrl.Login();
//		System.out.println(list3.getId().isEmpty());//값이 있다면 FALSE
//		System.out.println("회원정보가 일치합니다..");	
		

		//계정추가(회원가입)--이인환
//		ctrl.insertAdmin(vod);
//		System.out.println("계정이 생성되었습니다.");

		//계정삭제--이인환
//		ctrl.deleteAdmin(vod);
//		System.out.println("계정이 삭제되었습니다.");
		
		//비밀번호 변경--이인환
//		ctrl.updatePw();
//		System.out.println("비밀번호가 변경되었습니다.");
		
				
		
		
		// selectInventory(재고 전체출력) 김휘웅
//		ctrl.commandSelectInventory();
//		System.out.println("재고 목록을 출력해드렸습니다");

		// selectInventory02(재고 선택조회) 김휘웅
//		ctrl.selectInventory02(obj);
//		System.out.println("상품의 정보를 출력해드렸습니다");

		// insertInventory01(재고 삽입 GOODS에 들어가있는 상품의 코드와 상품명에 맞춰서 입력) 김휘웅 *이미 들어가있거나
		// 없는 값 넣으면 에러뜹니다.
//		ctrl.insertInventory01(voi);
//		System.out.println("우와 무지개깡이다");

		// updateInventory 김휘웅 재고 수정(상품명을 입력하여 재고의 수량을 수정)
//		ctrl.updateInventory(map);
//		System.out.println("해당 재고의 수량을 업데이트해드렸습니다"); //무지개깡은 수정하지마세요..유일한 과자

//		//deleteInventory 김휘웅 재고 삭제
//		ctrl.deleteInventory(map);
//		System.out.println("재고를 삭제하였습니다.");
		
		
		
		//거래처 추가 -한슬기
//		ctrl.insertAccount(voc);
//		System.out.println("거래처를 추가하였습니다.");
//				
//		//거래처 삭제 -한슬기
//		ctrl.deleteAcName(map);
//		System.out.println("거래처를 삭제하였습니다.");
//				
//		//거래처 전체조회 -한슬기
//		ctrl.selectAll();
//		System.out.println("거래처 전체조회 결과입니다");
//		//거래처명으로 조회 -한슬기
//		ctrl.selectAcName(obj);
//		System.out.println("거래처명으로 조회한 결과입니다");
//		//대표명으로 조회 -한슬기
//		ctrl.selectCEO(obj);
//		System.out.println("대표명으로 조회한 결과입니다");
//				
//		//거래처명 업데이트 -한슬기
//		ctrl.updateAcName(map);
//		System.out.println("거래처명을 업데이트 하였습니다");
//		//거래처 전화번호 업데이트 -한슬기
//		ctrl.updateAcTel(map);
//		System.out.println("거래처 전화번호를 업데이트 하였습니다");
//		//거래처 대표명 업데이트 -한슬기
//		ctrl.updateCEO(map);
//		System.out.println("대표명을 업데이트 하였습니다");
//		
//		
//		
//		//황인경
//		ctrl.commandSelectGoods();
//		System.out.println("상품 목록을 출력해드렸습니다");
//		//황인경
//		ctrl.selectGoodsCode(obj);
//		System.out.println("상품코드로 정보를 출력해드렸습니다");
//		//황인경
//		ctrl.selectGoodsName(obj);
//		System.out.println("상품이름으로 정보를 출력해드렸습니다");
//		//황인경
//		ctrl.insertGoods(vog);
//		System.out.println("상품을 추가 하였습니다");
//		//황인경
//		ctrl.updateGoodsPrice(map);
//		System.out.println("상품가격을 변경 하였습니다");
		//황인경 상품삭제 일단 보류
//		ctrl.deleteGoods(map);
//		System.out.println("상품을 삭제 하였습니다");
	}
}
