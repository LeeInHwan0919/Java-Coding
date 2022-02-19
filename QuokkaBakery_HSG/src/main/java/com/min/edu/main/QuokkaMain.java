package com.min.edu.main;

import java.util.HashMap;
import java.util.Map;

import com.min.edu.ctrl.QuokkaController;
import com.min.edu.vo.AccountVo;

public class QuokkaMain {
	private static AccountVo vo;
	private static Object obj ;
	private static Map<String, Object> map = new HashMap<String, Object>();

	public static void main(String[] args) {
		QuokkaController ctrl = new QuokkaController();
		
		//거래처 추가 -한슬기
		ctrl.insertAccount(vo);
		System.out.println("거래처를 추가하였습니다.");
		
		//거래처 삭제 -한슬기
		ctrl.deleteAcName(map);
		System.out.println("거래처를 삭제하였습니다.");
		
		//거래처 전체조회 -한슬기
		ctrl.selectAll();
		System.out.println("거래처 전체조회 결과입니다");
		//거래처명으로 조회 -한슬기
		ctrl.selectAcName(obj);
		System.out.println("거래처명으로 조회한 결과입니다");
		//대표명으로 조회 -한슬기
		ctrl.selectCEO(obj);
		System.out.println("대표명으로 조회한 결과입니다");
		
		//거래처명 업데이트 -한슬기
		ctrl.updateAcName(map);
		System.out.println("거래처명을 업데이트 하였습니다");
		//거래처 전화번호 업데이트 -한슬기
		ctrl.updateAcTel(map);
		System.out.println("거래처 전화번호를 업데이트 하였습니다");
		//거래처 대표명 업데이트 -한슬기
		ctrl.updateCEO(map);
		System.out.println("대표명을 업데이트 하였습니다");
	}
}
