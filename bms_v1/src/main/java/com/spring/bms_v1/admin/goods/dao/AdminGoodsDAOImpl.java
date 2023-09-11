package com.spring.bms_v1.admin.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bms_v1.goods.dto.GoodsDTO;

@Repository
public class AdminGoodsDAOImpl implements AdminGoodsDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<GoodsDTO> selectListGoods() throws Exception {
		return sqlSession.selectList("admin.goods.selectListGoods");
	}

	@Override
	public void insertGoods(GoodsDTO goodsDTO) throws Exception {
		sqlSession.insert("admin.goods.insertGoods" , goodsDTO);
	}

	@Override
	public void updateGoods(GoodsDTO goodsDTO) throws Exception {
		sqlSession.update("admin.goods.updateGoods" , goodsDTO);
	}

	@Override
	public void deleteGoods(int goodsCd) throws Exception {
		sqlSession.delete("admin.goods.deleteGoods" , goodsCd);
	}
	


}
