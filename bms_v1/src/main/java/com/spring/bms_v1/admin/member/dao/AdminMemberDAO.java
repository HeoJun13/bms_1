package com.spring.bms_v1.admin.member.dao;

import java.util.List;

import com.spring.bms_v1.admin.member.dto.AdminDTO;
import com.spring.bms_v1.member.dto.MemberDTO;

public interface AdminMemberDAO {
	
	public AdminDTO selectAdminLogin(AdminDTO adminDTO) throws Exception;
	public List<MemberDTO> selectListMember() throws Exception;
	
}
