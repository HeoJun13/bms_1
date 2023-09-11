package com.spring.bms_v1.contact.dao;

import com.spring.bms_v1.contact.dto.ContactDTO;

public interface ContactDAO {

	public void insertContact(ContactDTO contactDTO) throws Exception;
	
}
