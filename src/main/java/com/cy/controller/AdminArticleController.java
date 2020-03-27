package com.cy.controller;

import com.cy.constant.Number;
import com.cy.entity.User;
import com.cy.service.ArticleService;
import com.cy.util.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName: AdminArticleController
 * @Description: 文章管理
 * @date 2020/3/26 16:27
 */
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

	@PostMapping("addArticle")
	public ModelAndView addArticle(@RequestParam("title") String title,
	                               @RequestParam("content") String content,
	                               @RequestParam(value = "image", required = false) MultipartFile image,
	                               @RequestParam("poetryId") int poetryId) {
		User user = (User) request.getSession().getAttribute("user");
		ModelAndView mav = new ModelAndView();
		String imageUrl = null;
		articleService.addArticle(title, user.getUserId(), content, imageUrl, poetryId);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("admin-article-list");
		return mav;
	}

	@PutMapping("editArticle")
	public ModelAndView editArticle(@RequestParam("articleId") int articleId,
	                                @RequestParam("title") String title,
	                                @RequestParam("content") String content,
	                                @RequestParam(value = "image", required = false) MultipartFile image,
	                                @RequestParam("poetryId") int poetryId) {
		ModelAndView mav = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		String imageUrl = null;
		articleService.editArticle(articleId, title, user.getUserId(), content, imageUrl, poetryId);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("admin-article-list");
		return mav;
	}

	@DeleteMapping("deleteArticle")
	public ModelAndView deleteArticle(@RequestParam("articleId") int articleId) {
		ModelAndView mav = new ModelAndView();
		articleService.deleteArticle(articleId);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("admin-article-list");
		return mav;
	}

}
