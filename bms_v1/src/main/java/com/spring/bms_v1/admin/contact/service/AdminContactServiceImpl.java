package com.spring.bms_v1.admin.contact.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.spring.bms_v1.admin.contact.dao.AdminContactDAO;
import com.spring.bms_v1.contact.dto.ContactDTO;

@Service
public class AdminContactServiceImpl implements AdminContactService{

	@Autowired
	private AdminContactDAO adminContactDAO;
	
	@Override
	public List<ContactDTO> getContactList() throws Exception {
		return adminContactDAO.selectListContact();
	}

	@Override
	public ContactDTO getContactDetail(int contactCd) throws Exception {
		return adminContactDAO.selectOneContact(contactCd);
	}

	@Override
	public void removeContact(int[] deleteContactCdList) throws Exception {
		adminContactDAO.deleteContact(deleteContactCdList);
	}

	@Override
	@Scheduled(cron="59 59 23 * * *")
	public void getDailyNewContactList() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<ContactDTO> dailyNewContactList =  adminContactDAO.selectListDailyNewContact(sdf.format(new Date()));
		System.out.println("- 관리자 메일 전송 기능 구현- ");
		for (ContactDTO contactDTO : dailyNewContactList) {
			System.out.println(contactDTO);
		}
	}

}
