package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 链接跳转控制
 * @author cy
 *
 */
@Controller
public class LinkController {

	@RequestMapping("register")
	public String linkRegister() {
		return "register";
	}

	@RequestMapping("login")
	public String linkLogin() {
		return "login";
	}
	
	@RequestMapping("index")
	public String linkIndex() {
		return "index";
	}

	@RequestMapping("welcome")
	public String linkWelcome() {
		return "welcome";
	}

	@RequestMapping("admin-poetry-list")
	public String linkAdminPoetryList() {
		return "forward:adminPoetryList?page=1";
	}

	@RequestMapping("admin-poetry-add")
	public String linkAdminPoetryAdd() {
		return "forward:loadAuthorInfoToAdd";
	}

	@RequestMapping("admin-poetry-edit")
	public String linkAdminPoetryEdit() {
		return "forward:loadAuthorInfoToEdit";
	}

	@RequestMapping("admin-author-list")
	public String linkAdminAuthorList() {
		return "forward:adminAuthorList?page=1";
	}

	@RequestMapping("admin-author-add")
	public String linkAdminAuthorAdd() {
		return "admin-author-add";
	}

	@RequestMapping("admin-author-edit")
	public String linkAdminAuthorEdit() {
		return "admin-author-edit";
	}

	@RequestMapping("admin-article-list")
	public String linkAdminArticleList() {
		return "forward:adminArticleList?page=1";
	}

	@RequestMapping("admin-article-add")
	public String linkAdminArticleAdd() {
		return "forward:loadPoetryInfoToAdd";
	}

	@RequestMapping("admin-article-edit")
	public String linkAdminArticleEdit() {
		return "forward:loadPoetryInfoToEdit";
	}

	//=======前台页面跳转========

	@RequestMapping("poetry-list")
	public String linkPoetryList() {
		return "forward:poetryList?page=1";
	}

	@RequestMapping("article-list")
	public String linkArticleList() {
		return "forward:articleList?page=1";
	}

	@RequestMapping("article-detail")
	public String linkArticleDetail() {
		return "article-detail";
	}

}
