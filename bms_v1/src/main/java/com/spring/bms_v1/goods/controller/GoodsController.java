package com.spring.bms_v1.goods.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bms_v1.goods.dto.GoodsDTO;
import com.spring.bms_v1.goods.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	
	@GetMapping("/goodsList")
	public ModelAndView goodsList(@ModelAttribute GoodsDTO goodsDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/goods/goodsList");
		
		mv.addObject("goodsList" , goodsService.getGoodsList(goodsDTO));
		
		return mv;
		
	}
	
	
	@GetMapping("/goodsDetail")
	public ModelAndView goodsDetail(@RequestParam("goodsCd") int goodsCd) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		GoodsDTO goodsDTO = goodsService.getGoodsDetail(goodsCd);
		
		mv.setViewName("/goods/goodsDetail");
		mv.addObject("goodsDTO" , goodsDTO);

		mv.addObject("relatedGoodsList" , goodsService.getRelatedGoodsList(goodsDTO));
		
		return mv;
		
	}
	
	
	@GetMapping("/searchGoods")
	public ModelAndView goodsDetail(@RequestParam Map<String,Object> searchMap)throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/goods/goodsList");
		mv.addObject("goodsList" , goodsService.getSearchGoodsList(searchMap));
		
		return mv;
		
	}
	
	
}
