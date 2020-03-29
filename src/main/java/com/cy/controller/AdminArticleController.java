package com.cy.controller;

import com.cy.constant.Number;
import com.cy.entity.User;
import com.cy.service.ArticleService;
import com.cy.util.FileUtils;
import com.cy.util.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: AdminArticleController
 * @Description: 文章管理
 * @date 2020/3/26 16:27
 */
@Controller
public class AdminArticleController extends BaseController {

	@Resource
	private ArticleService articleService;

	@GetMapping("adminArticleList")
	public ModelAndView adminArticleList(@RequestParam("page") int page, @RequestParam(value = "keyword", required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = articleService.getArticleList(page, Number.size, keyword);
		mav.addObject("articleResultMap", result);
		mav.setViewName("admin-article-list");
		return mav;
	}

	@GetMapping("loadPoetryInfoToAdd")
	public ModelAndView loadPoetryInfoToAdd() {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> result = articleService.loadPoetryInfo();
		mav.addObject("poetryInfoList", result);
		mav.setViewName("admin-article-add");
		return mav;
	}

	@PostMapping("addArticle")
	public ModelAndView addArticle(@RequestParam("articleName") String articleName,
	                               @RequestParam("content") String content,
	                               @RequestParam(value = "imageUrl", required = false) String imageUrl,
	                               @RequestParam("poetryId") int poetryId) {
		User user = (User) request.getSession().getAttribute("user");
		ModelAndView mav = new ModelAndView();
		articleService.addArticle(articleName, user.getUserId(), content, imageUrl, poetryId);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-article-list");
		return mav;
	}

	@GetMapping("loadPoetryInfoToEdit")
	public ModelAndView loadPoetryInfoToEdit() {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> result = articleService.loadPoetryInfo();
		mav.addObject("poetryInfoList", result);
		mav.setViewName("admin-article-edit");
		return mav;
	}

	@PostMapping("editArticle")
	public ModelAndView editArticle(@RequestParam("articleId") int articleId,
									@RequestParam("articleName") String articleName,
	                                @RequestParam("content") String content,
									@RequestParam(value = "imageUrl", required = false) String imageUrl,
	                                @RequestParam("poetryId") int poetryId) {
		ModelAndView mav = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		articleService.editArticle(articleId, articleName, user.getUserId(), content, imageUrl, poetryId);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-article-list");
		return mav;
	}

	@DeleteMapping("deleteArticle")
	public ModelAndView deleteArticle(@RequestParam("articleId") int articleId) {
		ModelAndView mav = new ModelAndView();
		articleService.deleteArticle(articleId);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-article-list");
		return mav;
	}

	@DeleteMapping("batchDeleteArticle")
	public ModelAndView batchDeleteArticle(@RequestParam("articleIds") List<Integer> articleIds) {
		ModelAndView mav = new ModelAndView();
		articleService.batchDeleteArticle(articleIds);
		ResultUtils.ajaxPrintWriter("success", response);
		mav.setViewName("admin-article-list");
		return mav;
	}

}
