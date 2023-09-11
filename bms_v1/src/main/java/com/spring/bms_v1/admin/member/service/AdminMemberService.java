package com.spring.bms_v1.admin.member.service;

import java.util.List;

import com.spring.bms_v1.admin.member.dto.AdminDTO;
import com.spring.bms_v1.member.dto.MemberDTO;

public interface AdminMemberService {
	
	public boolean adminLogin(AdminDTO adminDTO) throws Exception;
	public List<MemberDTO> getMemberList() throws Exception;
	
}
