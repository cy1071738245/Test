package com.cy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cy.entity.Employee;
import com.cy.service.EmployeeService;

/**
 * 加载员工列表控制
 * @author cy
 *
 */
@Controller
public class LoadUserController {

	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@RequestMapping("loadUser")
	public ModelAndView loadUser(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Employee> result = employeeService.allEmployeeService();
		
		mav.addObject("userList", result);
		mav.setViewName("user");
		
		return mav;
	}
	
	/**
	 * 搜索员工
	 * @param request
	 * @param response
	 * @param keyWord
	 * @return
	 */
	@PostMapping("searchUser")
	@ResponseBody
	public List<Employee> search(HttpServletRequest request,HttpServletResponse response,String keyWord) {
		
		List<Employee> result = employeeService.searchEmployeeService(keyWord);
		
		return result;
	}
	
}
