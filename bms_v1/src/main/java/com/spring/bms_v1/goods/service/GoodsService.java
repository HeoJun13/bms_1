package com.spring.bms_v1.goods.service;

import java.util.List;
import java.util.Map;

import com.spring.bms_v1.goods.dto.GoodsDTO;

public interface GoodsService {
	
	public List<GoodsDTO> getGoodsList(GoodsDTO goodsDTO) throws Exception;
	public List<GoodsDTO> getRelatedGoodsList(GoodsDTO goodsDTO) throws Exception;
	public GoodsDTO getGoodsDetail(int goodsCd) throws Exception;
	public List<GoodsDTO> getSearchGoodsList(Map<String,Object> searchMap) throws Exception;
	
}
