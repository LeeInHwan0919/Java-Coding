package com.min.edu.model;

import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public interface IInsertDao {
	
	public int insertAdmin(AdminVo vo);// 계정추가 - 이인환
	
	public int insertAccount(AccountVo vo); // 거래처추가 - 한슬기
	
	public int insertGoods(GoodsVo vo);// 상품추가 - 황인경
	
	public int insertInventory01(InventoryVo vo); // 재고추가 - 김휘웅

}
