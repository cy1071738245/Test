package com.cy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cy.entity.Employee;
import com.cy.entity.JobInfo;
import com.cy.service.EmployeeService;
import com.cy.service.JobInfoService;

/**
 * 更改员工信息控制
 * @author cy
 *
 */
@Controller
public class AboutUserController {

	@Resource(name="jobInfoService")
	private JobInfoService jobInfoService;
	
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@PostMapping("operateUser")
	public ModelAndView operateUser(HttpServletRequest request,HttpServletResponse response,
			Integer employeeId,String employeeUsername,String employeeRealname,String employeeNickname,String employeePhone,Integer jobInfoId) {
		
		ModelAndView mav = new ModelAndView();
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeUsername(employeeUsername);
		employee.setEmployeeRealname(employeeRealname);
		employee.setEmployeeNickname(employeeNickname);
		employee.setEmployeePhone(employeePhone);
		employee.setJobinfoId(jobInfoId);
		
		JobInfo result1 = jobInfoService.queryDepartByJobInfoIdService(jobInfoId);
		employee.setDepartmentId(result1.getDepartmentId());
		
		Integer result2 = employeeService.operateUserService(employee);
		
		try {
			PrintWriter out = response.getWriter();
			if(result2 < -1) {
				out.print(-1);
			}
			if(result2 > 0) {
				out.print(1);
			}
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mav.setViewName("user");
		
		return mav;
	}
	
	@PostMapping("resetPassword")
	public void resetPassword(HttpServletRequest request,HttpServletResponse response,Integer employeeId) {

		Integer result = employeeService.resetPasswordService(employeeId);
		
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
	
	@RequestMapping("checkEmployeeUsername")
	public void checkEmployeeUsername(HttpServletRequest request,HttpServletResponse response,String employeeUsername) {
		
		Employee result = employeeService.checkUsername(employeeUsername);
		
		if(result != null) {
			try {
				PrintWriter out = response.getWriter();
				out.print(1);
				//关闭流
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@RequestMapping("checkEmployeeNickname")
	public void checkEmployeeNickname(HttpServletRequest request,HttpServletResponse response,String employeeNickname) {
		
		Employee result = employeeService.checkNickname(employeeNickname);
		
		if(result != null) {
			try {
				PrintWriter out = response.getWriter();
				out.print(1);
				//关闭流
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
