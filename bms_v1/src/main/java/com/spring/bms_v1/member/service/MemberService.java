package com.spring.bms_v1.member.service;

import com.spring.bms_v1.member.dto.MemberDTO;

public interface MemberService {
	
	public boolean login(MemberDTO memberDTO) throws Exception;
	public void addMember(MemberDTO memberDTO) throws Exception;
	public String checkDuplicatedId(String memberId) throws Exception;
	public int getMyOrderCnt(String memberId) throws Exception;
	public int getMyCartCnt(String memberId) throws Exception;
	
}
