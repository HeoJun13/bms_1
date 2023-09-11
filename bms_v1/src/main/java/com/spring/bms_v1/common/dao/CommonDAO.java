package com.spring.bms_v1.common.dao;

import java.util.List;
import java.util.Map;

public interface CommonDAO {

	public int selectOneNewBookCnt() throws Exception;
	public int selectOneGeneralBookCnt() throws Exception;
	public int selectOneBestSellerCnt() throws Exception;
	public int selectOneSteadySellerCnt() throws Exception;
	public List<Map<String,Object>> selectListGoodsNewBooks() throws Exception;
	public List<Map<String,Object>> selectListGoodsBestBooks() throws Exception;
	public List<Map<String,Object>> selectListGoodsSteadyBooks() throws Exception;
	
}
