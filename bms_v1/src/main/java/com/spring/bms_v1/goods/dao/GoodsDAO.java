package com.spring.bms_v1.goods.dao;

import java.util.List;
import java.util.Map;

import com.spring.bms_v1.goods.dto.GoodsDTO;

public interface GoodsDAO {
	
	public List<GoodsDTO> selectGoodsList(GoodsDTO goodsDTO) throws Exception;
	public List<GoodsDTO> selectRelatedGoodsList(GoodsDTO goodsDTO) throws Exception;
	public GoodsDTO selectOneGoods(int goodsCd) throws Exception;
	public List<GoodsDTO> selectListSearchGoods(Map<String,Object> searchMap) throws Exception;
	
}
