package com.spring.bms_v1.common.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bms_v1.common.service.CommonService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class CommonController {
	
	@Autowired
	private CommonService commonService;
		
	private final String GOODS_IMAGE_REPO_PATH = "C:\\file_repo\\";					// window
	//private final String GOODS_IMAGE_REPO_PATH = "/var/lib/tomcat9/file_repo/";	// linux
	
	
	@GetMapping("/")
	public ModelAndView home() throws Exception{
		
		ModelAndView mv = new ModelAndView("/main");
		
		Map<String, String> goodsListMap = new HashMap<String, String>();
		goodsListMap.put("sort", "all");
		goodsListMap.put("part", "all");
		
		mv.addObject("newBookCnt"      , commonService.getNewBookCnt());
		mv.addObject("generalBookCnt"  , commonService.getGeneralBookCnt());
		mv.addObject("bestSellerCnt"   , commonService.getBestSellerCnt());
		mv.addObject("steadySellerCnt" , commonService.getSteadySellerCnt());
		mv.addObject("newBooksInfo"    , commonService.getNewGoodsMainInfo());
		mv.addObject("bestBooksInfo"   , commonService.getBestGoodsMainInfo());
		mv.addObject("steadyBooksInfo" , commonService.getSteadyGoodsMainInfo());
		
		return mv;
		
	}

	
	@GetMapping("/thumbnails")
	public void thumbnails(@RequestParam("goodsFileName") String goodsFileName , HttpServletResponse response) throws Exception {
	
		OutputStream out = response.getOutputStream();
		String filePath = GOODS_IMAGE_REPO_PATH + goodsFileName;
		
		File image = new File(filePath);
		if (image.exists()) { 
			Thumbnails.of(image).size(800,800).outputFormat("png").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
		
	}
	
}
