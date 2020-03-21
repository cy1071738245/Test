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

	@RequestMapping("member-list")
	public String linkMemberList() {
		return "member-list";
	}

	@RequestMapping("member-add")
	public String linkMemberAdd() {
		return "member-add";
	}

	@RequestMapping("member-edit")
	public String linkMemberEdit() {
		return "member-edit";
	}

	@RequestMapping("poetry-list")
	public String linkPoetryList() {
		return "poetry-list";
	}

	@RequestMapping("detail")
	public String linkDetail() {
		return "detail";
	}

}
