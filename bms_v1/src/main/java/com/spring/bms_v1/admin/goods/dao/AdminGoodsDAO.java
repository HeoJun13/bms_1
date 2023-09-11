
package com.spring.bms_v1.admin.goods.dao;

import java.util.List;

import com.spring.bms_v1.goods.dto.GoodsDTO;

public interface AdminGoodsDAO {
	
	public List<GoodsDTO>selectListGoods() throws Exception;
	public void insertGoods(GoodsDTO goodsDTO) throws Exception;
	public void updateGoods(GoodsDTO goodsDTO) throws Exception;
	public void deleteGoods(int goodsCd) throws Exception;
	
}
