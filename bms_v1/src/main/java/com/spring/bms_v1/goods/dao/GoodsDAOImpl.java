package com.spring.bms_v1.goods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bms_v1.goods.dto.GoodsDTO;

@Repository
public class GoodsDAOImpl implements GoodsDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<GoodsDTO> selectGoodsList(GoodsDTO goodsDTO) throws Exception {
	   return sqlSession.selectList("goods.selectListGoods" , goodsDTO);	
	}
	
	@Override
	public List<GoodsDTO> selectRelatedGoodsList(GoodsDTO goodsDTO) throws Exception {
		return sqlSession.selectList("goods.selectListRelatedGoods" , goodsDTO);	
	}
	
	@Override
	public GoodsDTO selectOneGoods(int goodsCd) throws Exception{
		return sqlSession.selectOne("goods.selectOneGoods" , goodsCd);
	}

	@Override
	public List<GoodsDTO> selectListSearchGoods(Map<String, Object> searchMap) throws Exception {
		return sqlSession.selectList("goods.selectListSearchGoods" , searchMap);
	}
	
}
