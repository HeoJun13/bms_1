package com.spring.bms_v1.admin.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bms_v1.admin.contact.service.AdminContactService;

@Controller
@RequestMapping("/admin/contact")
public class AdminContactController {
	
	@Autowired
	private AdminContactService adminContactService;
	
	@GetMapping("/contactDetail")
	public ModelAndView contactDetail(@RequestParam("contactCd") int contactCd) throws Exception{
		ModelAndView mv = new ModelAndView("/contactDetail");
		mv.addObject("contactDTO" , adminContactService.getContactDetail(contactCd));
		return mv;
	}
	
	@GetMapping("/contactList")
	public ModelAndView contactList() throws Exception{
		ModelAndView mv = new ModelAndView("/contactList");
		mv.addObject("contactList" , adminContactService.getContactList());
		return mv;
	}
	
	@GetMapping("/removeContact")
	public ResponseEntity<Object> removeCart(@RequestParam("contactCdList") String contactCdList) throws Exception {
		
		String[] temp = contactCdList.split(",");
		int[] deleteContactCdList = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
			deleteContactCdList[i] = Integer.parseInt(temp[i]);
		}
		
		adminContactService.removeContact(deleteContactCdList);
		
		String jsScript = "<script>";
				jsScript += "alert('컨텍트 정보를 삭제하였습니다.'); ";
				jsScript += "location.href='contactList'";
				jsScript += "</script>";
		
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(jsScript, responseHeaders, HttpStatus.OK);
		
	}
	
}
