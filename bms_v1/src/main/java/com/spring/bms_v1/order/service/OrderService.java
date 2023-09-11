package com.spring.bms_v1.order.service;

import java.util.List;
import java.util.Map;

import com.spring.bms_v1.goods.dto.GoodsDTO;
import com.spring.bms_v1.member.dto.MemberDTO;
import com.spring.bms_v1.order.dto.OrderDTO;

public interface OrderService {
	
	public void addOrder(OrderDTO orderDTO, int point) throws Exception;
	public MemberDTO getOrdererDetail(String memberId) throws Exception;
	public GoodsDTO getGoodsDetail(int goodsCd) throws Exception;
	public List<GoodsDTO> getGoodsListByCart(int[] goodsCdList) throws Exception;
	public void addOrderByCart(Map<String,String> orderListMap)  throws Exception;
	
}
