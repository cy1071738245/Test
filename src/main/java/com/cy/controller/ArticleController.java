package com.cy.controller;

import com.cy.constant.Number;
import com.cy.service.ArticleService;
import com.cy.service.PoetryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 测试
 * @author cy
 *
 */
@Controller
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@GetMapping("articleList")
	public ModelAndView articleList(@RequestParam("page") int page, @RequestParam(value = "keyword", required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = articleService.getArticleList(page, Number.size, keyword);
		mav.addObject("articleResultMap", result);
		mav.setViewName("article-list");
		return mav;
	}

	@GetMapping("getArticleById")
	public ModelAndView getArticleById(@RequestParam("articleId") int articleId) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = articleService.getArticleById(articleId);
		mav.addObject("articleInfo", result);
		mav.setViewName("article-detail");
		return mav;
	}
	
}
