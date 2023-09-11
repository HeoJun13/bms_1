package com.spring.bms_v1.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bms_v1.contact.dao.ContactDAO;
import com.spring.bms_v1.contact.dto.ContactDTO;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDAO contactDAO;

	@Override
	public void addNewContact(ContactDTO contactDTO) throws Exception {
		contactDAO.insertContact(contactDTO);
	}

}
