package com.cy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.cy.entity.Employee;
import com.cy.service.EmployeeService;

/**
 * 关于密码控制
 * @author cy
 *
 */
@Controller
public class AboutPwdController {

	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@PostMapping("updatePassword")
	public void updatePassword(HttpServletRequest request,HttpServletResponse response,String password) {
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		Integer result = employeeService.updatePasswordService(password, employee);
		
		try {
			PrintWriter out = response.getWriter();
			if(result == 1) {
				out.print(1);
			}
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
