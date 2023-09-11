package com.spring.bms_v1.admin.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bms_v1.admin.member.dao.AdminMemberDAO;
import com.spring.bms_v1.admin.member.dto.AdminDTO;
import com.spring.bms_v1.member.dto.MemberDTO;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {
	
	@Autowired
	private AdminMemberDAO adminMemberDAO;
	
	@Override
	public boolean adminLogin(AdminDTO adminDTO) throws Exception {
		
		if (adminMemberDAO.selectAdminLogin(adminDTO) != null) {
			return true;
		}
		
		return false;
		
	}
	
	public List<MemberDTO> getMemberList() throws Exception{
		return adminMemberDAO.selectListMember();
	}
	
}
