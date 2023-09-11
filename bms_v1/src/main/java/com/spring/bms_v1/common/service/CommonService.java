package com.spring.bms_v1.common.service;

import java.util.List;
import java.util.Map;

public interface CommonService {

	public int getNewBookCnt() throws Exception;
	public int getGeneralBookCnt() throws Exception;
	public int getBestSellerCnt() throws Exception;
	public int getSteadySellerCnt() throws Exception;
	public List<Map<String,Object>> getNewGoodsMainInfo() throws Exception;
	public List<Map<String,Object>> getBestGoodsMainInfo() throws Exception;
	public List<Map<String,Object>> getSteadyGoodsMainInfo() throws Exception;
	
}
