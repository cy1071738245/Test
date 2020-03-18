package com.cy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cy.entity.Employee;
import com.cy.service.EmployeeService;

/**
 * 登录控制
 * @author cy
 *
 */
@Controller
public class LoginController {

	@Resource(name="employeeService")
	private EmployeeService employeeService;

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@PostMapping("loginVerify")
	public ModelAndView loginVerify(String username,String password,HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		Employee employee = new Employee();
		employee.setEmployeeUsername(username);
		employee.setEmployeePassword(password);
		
		Employee result = employeeService.loginVerifyService(employee);
		if(result != null) {
			request.getSession().removeAttribute("employee");
			request.getSession().setAttribute("employee", result);
			mav.setViewName("forward:loadAuthority");
		}else {
			mav.addObject("msg","用户名或密码错误");
			mav.setViewName("login");
		}
		
		return mav;
	}
	
	/**
	 * 注销
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		request.getSession().removeAttribute("employee");
		
		mav.setViewName("login");
		
		return mav;
	}
	
}
