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
	
	@RequestMapping("depart")
	public String linkDepart() {
		return "forward:loadDepart";
	}
	
	@RequestMapping("role")
	public String linkRole() {
		return "forward:loadRole";
	}

	@RequestMapping("user")
	public String linkUser() {
		return "forward:loadUser";
	}
	
	@RequestMapping("schedule")
	public String linkSchedule() {
		return "schedule";
	}
	
	@RequestMapping("updatePwd")
	public String linkUpdatePwd() {
		return "updatePwd";
	}
	
	@RequestMapping("addDepart")
	public String linkAddDepart() {
		return "addDepart";
	}
	
	@RequestMapping("editRole")
	public String linkEditRole() {
		return "forward:dropDownMenuDepartEdit";
	}
	
	@RequestMapping("alterRole")
	public String linkAlterRole() {
		return "forward:dropDownMenuDepartAlter";
	}
	
	@RequestMapping("shareRole")
	public String linkShareRole() {
		return "forward:distributionRightsDisplay";
	}
	
	@RequestMapping("addUser")
	public String linkAddUser() {
		return "forward:dropDownMenuRole";
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
