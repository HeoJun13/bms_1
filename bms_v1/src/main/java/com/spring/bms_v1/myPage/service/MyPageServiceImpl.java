package com.spring.bms_v1.myPage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bms_v1.member.dto.MemberDTO;
import com.spring.bms_v1.myPage.dao.MyPageDAO;
import com.spring.bms_v1.myPage.dto.CartDTO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDAO myPageDAO;
	
	@Override
	public List<Map<String,Object>> getMyOrderList(String memberId) throws Exception {
		return myPageDAO.selectListMyOrder(memberId);
	}

	@Override
	public Map<String,Object> getMyOrderDetail(Map<String,Object> orderDetailMap) throws Exception {
		return myPageDAO.selectOneMyOrder(orderDetailMap);
	}

	@Override
	public MemberDTO getMyInfo(String memberId) throws Exception {
		return myPageDAO.selectOneMyInfo(memberId);
	}

	@Override
	public void modifyMyInfo(MemberDTO memberDTO) throws Exception {
		if (memberDTO.getSmsstsYn() == null) memberDTO.setSmsstsYn("N"); 
		if (memberDTO.getEmailstsYn() == null) memberDTO.setEmailstsYn("N");
		myPageDAO.updateMyInfo(memberDTO);
	}

	@Override
	@Transactional
	public void removeMember(String memberId) throws Exception {
		myPageDAO.deleteMember(memberId);
		myPageDAO.deleteCartListByRemoveMember(memberId);
		myPageDAO.deleteOrderListByRemoveMember(memberId);
	}
	
	@Override
	public boolean checkDuplicatedCart(CartDTO cartDTO) throws Exception {
		if (myPageDAO.selectOneDuplicatedCart(cartDTO) == null) return false;
		else												    return true;
	}
	
	@Override
	public void addCart(CartDTO cartDTO) throws Exception {
		myPageDAO.insertCart(cartDTO);
	}

	@Override
	public List<Map<String,Object>> getMyCartList(String memberId) throws Exception {
		return myPageDAO.selectListMyCart(memberId);
	}

	@Override
	public void removeCart(int[] deleteCartCdList) throws Exception {
		myPageDAO.deleteCart(deleteCartCdList);
	}

	@Override
	public void modifyCartGoodsQty(Map<String , Object> updateMap) throws Exception {
		myPageDAO.updateCartGoodsQty(updateMap);
	}

	@Override
	public int countCartList(String memberId) throws Exception {
		return myPageDAO.selectCountMyCart(memberId);
	}

}
