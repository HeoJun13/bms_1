package com.spring.bms_v1.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bms_v1.goods.dto.GoodsDTO;
import com.spring.bms_v1.member.dto.MemberDTO;
import com.spring.bms_v1.order.dao.OrderDAO;
import com.spring.bms_v1.order.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	@Transactional
	public void addOrder(OrderDTO orderDTO , int point) throws Exception{
		
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("point"         , point);
		orderMap.put("orderGoodsQty" , orderDTO.getOrderGoodsQty());
		orderMap.put("goodsCd"       , orderDTO.getGoodsCd());
		orderMap.put("memberId"      , orderDTO.getMemberId());
		
		orderDAO.updateGoodsStockCnt(orderMap);
		orderDAO.updateMemberPoint(orderMap);
		orderDAO.insertOrder(orderDTO);
		
	}

	@Override
	public MemberDTO getOrdererDetail(String memberId) throws Exception {
		return orderDAO.selectOneOrderer(memberId);
	}

	@Override
	public GoodsDTO getGoodsDetail(int goodsCd) throws Exception {
		return orderDAO.selectOneCartGoods(goodsCd);
	}	
	
	@Override
	public List<GoodsDTO> getGoodsListByCart(int[] goodsCdList) throws Exception {
		return orderDAO.selectListCartGoods(goodsCdList);
	}

	@Override
	@Transactional
	public void addOrderByCart(Map<String, String> orderListMap) throws Exception {
	
		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		
		String[] temp1 = orderListMap.get("goodsCdList").split(","); 
		int[] goodsCdList = new int[temp1.length];
		for (int i = 0; i < temp1.length; i++) {
			goodsCdList[i] = Integer.parseInt(temp1[i]);
		}
		
		String[] temp2 = orderListMap.get("orderGoodsQtyList").split(",");
		int[] orderGoodsQtyList = new int[temp2.length];
		for (int i = 0; i < temp2.length; i++) {
			orderGoodsQtyList[i] = Integer.parseInt(temp2[i]);
		}
		
		String[] temp3 = orderListMap.get("paymentAmtList").split(",");
		int[] paymentAmtList = new int[temp3.length];
		for (int i = 0; i < temp3.length; i++) {
			paymentAmtList[i] = Integer.parseInt(temp3[i]);
		}
		
		
		for (int i = 0; i < goodsCdList.length; i++) {
			
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setGoodsCd(goodsCdList[i]);
			orderDTO.setMemberId(orderListMap.get("memberId"));
			orderDTO.setOrderGoodsQty(orderGoodsQtyList[i]);
			orderDTO.setPaymentAmt(paymentAmtList[i]);
			orderDTO.setOrdererNm(orderListMap.get("ordererNm"));
			orderDTO.setOrdererHp(orderListMap.get("ordererHp"));
			orderDTO.setReceiverNm(orderListMap.get("receiverNm"));
			orderDTO.setReceiverHp(orderListMap.get("receiverHp"));
			orderDTO.setZipcode(orderListMap.get("zipcode"));
			orderDTO.setRoadAddress(orderListMap.get("roadAddress"));
			orderDTO.setJibunAddress(orderListMap.get("jibunAddress"));
			orderDTO.setNamujiAddress(orderListMap.get("namujiAddress"));
			orderDTO.setDeliveryMethod(orderListMap.get("deliveryMethod"));
			orderDTO.setDeliveryMessage(orderListMap.get("deliveryMessage"));
			orderDTO.setGiftWrapping(orderListMap.get("giftWrapping"));
			orderDTO.setPayMethod(orderListMap.get("payMethod"));
			orderDTO.setPayOrdererHp(orderListMap.get("payOrdererHp"));
			orderDTO.setCardCompanyNm(orderListMap.get("cardCompanyNm"));
			orderDTO.setCardPayMonth(orderListMap.get("cardPayMonth"));
			orderList.add(orderDTO);
			
		}
		
		Map<String, Object> memberMap = new HashMap<String, Object>();
		memberMap.put("point", Integer.parseInt(orderListMap.get("totalPoint")));
		memberMap.put("memberId" , orderListMap.get("memberId"));
		
		orderDAO.updateMemberPointByCart(memberMap); 

		List<Map<String,Integer>> goodsMapList = new ArrayList<Map<String,Integer>>();
		for (int i = 0; i < goodsCdList.length; i++) {
			Map<String,Integer> goodsMap = new HashMap<String, Integer>();
			goodsMap.put("goodsCd" , goodsCdList[i]);
			goodsMap.put("orderGoodsQty" , orderGoodsQtyList[i]);
			goodsMapList.add(goodsMap);
		}
		
		orderDAO.updateGoodsStockCntByCart(goodsMapList); 
		orderDAO.insertOrderByCart(orderList);
		
		String[] temp4 = orderListMap.get("cartCdList").split(",");
		int[] cartCdList = new int[temp4.length];
		for (int i = 0; i < temp4.length; i++) {
			cartCdList[i] = Integer.parseInt(temp4[i]);
		}
		
		orderDAO.deleteCartByOrder(cartCdList);
		
	}

	
}
