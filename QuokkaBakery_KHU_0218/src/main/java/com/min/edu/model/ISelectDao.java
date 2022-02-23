package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public interface ISelectDao {

	public AdminVo selectPW(AdminVo vo); //비밀번호찾기 - 이인환
	public AdminVo selectID(AdminVo vo); //아이디찾기 - 이인환
	public AdminVo Login(AdminVo vo); //아이디, 비밀번호 일치 여부 > 이인환
	
	public List<AccountVo> selectAll(); // 전체조회 -한슬기
	public AccountVo selectAcName (Object ac_name);//거래처명으로 조회 -한슬기
	public AccountVo selectAcTel (Object ac_tel);//거래처명으로 조회 -한슬기
	public AccountVo selectAcRegnum (Object ac_regnum);//사업자등록번호로 조회 -한슬기
	public AccountVo selectCEO (Object ceo_name);//대표명으로 조회 -한슬기
	public AccountVo selectAcCode (Object ac_code);//거래처코드로 조회 -한슬기
	
	public GoodsVo selectGoodsCode(Object g_code); //황인경 
	public GoodsVo selectGoodsName(Object g_name); //황인경 
	public List<GoodsVo> selectGoodsAll(); //황인경 
	
	public List<InventoryVo> selectInventory(); //김휳
	public InventoryVo selectInventory02(Object g_name);//김휳
	
}