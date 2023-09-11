package com.spring.bms_v1.goods.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bms_v1.goods.dao.GoodsDAO;
import com.spring.bms_v1.goods.dto.GoodsDTO;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDAO goodsDAO;
	
	public List<GoodsDTO> getGoodsList(GoodsDTO goodsDTO) throws Exception {
		return goodsDAO.selectGoodsList(goodsDTO);
	}
	
	@Override
	public List<GoodsDTO> getRelatedGoodsList(GoodsDTO goodsDTO) throws Exception {
		return goodsDAO.selectRelatedGoodsList(goodsDTO);
	}
	
	public GoodsDTO getGoodsDetail(int goodsCd) throws Exception {
		return goodsDAO.selectOneGoods(goodsCd);
	}

	@Override
	public List<GoodsDTO> getSearchGoodsList(Map<String, Object> searchMap) throws Exception {
		return goodsDAO.selectListSearchGoods(searchMap);
	}
	
}
