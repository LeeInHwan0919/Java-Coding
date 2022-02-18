package com.min.edu.model;

import com.min.edu.vo.AccountVo;
import com.min.edu.vo.AdminVo;
import com.min.edu.vo.GoodsVo;
import com.min.edu.vo.InventoryVo;

public interface IInsertDao {
	
	public int insertAdmin(AdminVo vo);
	
	public int insertAccount(AccountVo vo);
	
	public int insertGoods(GoodsVo vo);
	
	public int insertInventory01(InventoryVo vo);
}
