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
	public String linkMemberList() {
		return "forward:adminPoetryList?page=1";
	}

	@RequestMapping("admin-poetry-add")
	public String linkMemberAdd() {
		return "admin-poetry-add";
	}

	@RequestMapping("member-edit")
	public String linkMemberEdit() {
		return "member-edit";
	}

	@RequestMapping("poetry-list")
	public String linkPoetryList() {
		return "forward:poetryList?page=1";
	}

	@RequestMapping("detail")
	public String linkDetail() {
		return "detail";
	}

}
