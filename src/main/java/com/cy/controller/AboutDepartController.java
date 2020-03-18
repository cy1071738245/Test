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

import com.cy.entity.Department;
import com.cy.service.DepartmentService;

/**
 * 更改部门信息控制
 * @author cy
 *
 */
@Controller
public class AboutDepartController {

	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@PostMapping("operateDepart")
	public ModelAndView operateDepart(HttpServletRequest request,HttpServletResponse response,Integer departmentId,String departmentName) {
		
		ModelAndView mav = new ModelAndView();
		
		Department department = new Department();
		department.setDepartmentId(departmentId);
		department.setDepartmentName(departmentName);
		
		Integer result = departmentService.operateDepartService(department);
		
		try {
			PrintWriter out = response.getWriter();
			if(result < -1) {
				out.print(-1);
			}
			if(result > 0) {
				out.print(1);
			}
			//关闭流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mav.setViewName("forward:depart");
		
		return mav;
	}
	
	@RequestMapping("checkDepartName")
	public void checkDepartName(HttpServletRequest request,HttpServletResponse response,String departmentName) {
		
		Department result = departmentService.checkDepartmentName(departmentName);
		
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
