package com.spring.bms_v1.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bms_v1.goods.dto.GoodsDTO;
import com.spring.bms_v1.member.dto.MemberDTO;
import com.spring.bms_v1.order.dto.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertOrder(OrderDTO orderDTO) throws Exception{
		sqlSession.insert("order.insertOrder" , orderDTO);
	}

	@Override
	public MemberDTO selectOneOrderer(String memberId) throws Exception {
		return sqlSession.selectOne("order.selectOneOrderer" , memberId);
	}

	@Override
	public GoodsDTO selectOneCartGoods(int goodsCd) throws Exception {
		return sqlSession.selectOne("order.selectOneCartGoods" , goodsCd);
	}

	@Override
	public List<GoodsDTO> selectListCartGoods(int[] goodsCdList) throws Exception {
		return sqlSession.selectList("order.selectListCartGoods" , goodsCdList);
	}
	
	@Override
	public void insertOrderByCart(List<OrderDTO> orderList) throws Exception{
		sqlSession.insert("order.insertOrderByCart" , orderList);
	}


	@Override
	public void updateGoodsStockCnt(Map<String, Object> orderMap) throws Exception {
		sqlSession.update("order.updateGoodsStockCnt" , orderMap);
	}

	@Override
	public void updateMemberPoint(Map<String, Object> orderMap) throws Exception {
		sqlSession.update("order.updateMemberPoint" , orderMap);
	}

	@Override
	public void updateGoodsStockCntByCart(List<Map<String, Integer>> goodsMapList) throws Exception {
		sqlSession.update("order.updateGoodsStockCntByCart" , goodsMapList);
	}
	
	@Override
	public void updateMemberPointByCart(Map<String, Object> memberMap) throws Exception {
		sqlSession.update("order.updateMemberPointByCart" , memberMap);
	}
	
	@Override
	public void deleteCartByOrder(int[] cartCdList) throws Exception {
		sqlSession.insert("order.deleteCartByOrder" , cartCdList);
	}
	
}

