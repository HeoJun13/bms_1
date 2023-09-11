package com.spring.bms_v1.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bms_v1.common.dao.CommonDAO;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public int getNewBookCnt() throws Exception {
		return commonDAO.selectOneNewBookCnt();
	}


	@Override
	public int getGeneralBookCnt() throws Exception {
		return commonDAO.selectOneGeneralBookCnt();
	}


	@Override
	public int getBestSellerCnt() throws Exception {
		return commonDAO.selectOneBestSellerCnt();
	}


	@Override
	public int getSteadySellerCnt() throws Exception {
		return commonDAO.selectOneSteadySellerCnt();
	}


	@Override
	public List<Map<String, Object>> getNewGoodsMainInfo() throws Exception {
		return commonDAO.selectListGoodsNewBooks();
	}


	@Override
	public List<Map<String, Object>> getBestGoodsMainInfo() throws Exception {
		return commonDAO.selectListGoodsBestBooks();
	}


	@Override
	public List<Map<String, Object>> getSteadyGoodsMainInfo() throws Exception {
		return commonDAO.selectListGoodsSteadyBooks();
	}
	
}
