package com.spring.bms_v1.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int selectOneNewBookCnt() throws Exception {
		return sqlSession.selectOne("common.selectOneNewBookCnt");
	}

	@Override
	public int selectOneGeneralBookCnt() throws Exception {
		return sqlSession.selectOne("common.selectOneGeneralBookCnt");
	}

	@Override
	public int selectOneBestSellerCnt() throws Exception {
		return sqlSession.selectOne("common.selectOneBestSellerCnt");
	}

	@Override
	public int selectOneSteadySellerCnt() throws Exception {
		return sqlSession.selectOne("common.selectOneSteadySellerCnt");
	}

	@Override
	public List<Map<String, Object>> selectListGoodsNewBooks() throws Exception {
		return sqlSession.selectList("common.selectListGoodsNewBooks");
	}

	@Override
	public List<Map<String, Object>> selectListGoodsBestBooks() throws Exception {
		return sqlSession.selectList("common.selectListGoodsBestBooks");
	}

	@Override
	public List<Map<String, Object>> selectListGoodsSteadyBooks() throws Exception {
		return sqlSession.selectList("common.selectListGoodsSteadyBooks");
	}
	
}
