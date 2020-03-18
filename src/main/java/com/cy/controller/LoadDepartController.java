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

import com.cy.entity.Department;
import com.cy.service.DepartmentService;

/**
 * 加载部门列表控制
 * @author cy
 *
 */
@Controller
public class LoadDepartController {

	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@RequestMapping("loadDepart")
	public ModelAndView loadDepart(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Department> result = departmentService.allDepartmentService();
		
		mav.addObject("departmentList", result);
		mav.setViewName("depart");
		
		return mav;
	}
	
	/**
	 * 下拉菜单加载部门信息跳转editRole页面
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping("dropDownMenuDepartEdit")
	public ModelAndView dropDownMenuDepartEdit(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Department> result = departmentService.allDepartmentService();
		
		mav.addObject("departmentList", result);
		mav.setViewName("editRole");
		
		return mav;
	}
	
	/**
	 * 下拉菜单加载部门信息跳转alterRole页面
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping("dropDownMenuDepartAlter")
	public ModelAndView dropDownMenuDepartAlter(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Department> result = departmentService.allDepartmentService();
		
		mav.addObject("departmentList", result);
		mav.setViewName("alterRole");
		
		return mav;
	}
	
	/**
	 * 搜索部门
	 * @param request
	 * @param response
	 * @param keyWord
	 * @return
	 */
	@PostMapping("searchDepart")
	@ResponseBody
	public List<Department> search(HttpServletRequest request,HttpServletResponse response,String keyWord) {
		
		List<Department> result = departmentService.searchDepartmentService(keyWord);
		
		return result;
	}
	
}
