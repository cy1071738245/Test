package com.cy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cy.entity.Employee;
import com.cy.service.AboutAuthorityService;

/**
 * 加载权限控制
 * @author cy
 *
 */
@Controller
public class LoadAuthorityController {

	@Resource(name="aboutAuthorityService")
	private AboutAuthorityService aboutAuthorityService;
	
	@RequestMapping("loadAuthority")
	public ModelAndView loadAuthority(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		Employee result = aboutAuthorityService.loadAuthorityService(employee);
		request.getSession().setAttribute("employee", result);
		
		mav.setViewName("index");
		
		return mav;
	}
	
}
