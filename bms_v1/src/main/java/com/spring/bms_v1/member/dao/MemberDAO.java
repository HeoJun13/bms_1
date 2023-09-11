package com.spring.bms_v1.member.dao;

import com.spring.bms_v1.member.dto.MemberDTO;

public interface MemberDAO {
	
	public MemberDTO selectLogin(MemberDTO memberDTO) throws Exception;
	public void insertMember(MemberDTO memberDTO) throws Exception;
	public String selectDuplicatedId(String memberId) throws Exception;
	public int selectMyOrderCnt(String memberId) throws Exception;
	public int selectMyCartCnt(String memberId) throws Exception;
	
}
