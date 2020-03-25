package com.cy.controller;

import javax.annotation.Resource;

import com.cy.constant.Number;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cy.service.PoetryService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 测试
 * @author cy
 *
 */
@Controller
public class PoetryController {

	@Resource
	private PoetryService poetryService;

	@GetMapping("poetryList")
	public ModelAndView poetryList(@RequestParam("page") int page, @RequestParam(value = "keyword", required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = poetryService.getPoetryList(page, Number.size, keyword);
		mav.addObject("poetryResultMap", result);
		mav.setViewName("poetry-list");
		return mav;
	}
	
}
