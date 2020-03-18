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

import com.cy.entity.JobInfo;
import com.cy.service.JobInfoService;

/**
 * 加载职位列表控制
 * @author cy
 *
 */
@Controller
public class LoadRoleController {

	@Resource(name="jobInfoService")
	private JobInfoService jobInfoService;
	
	@RequestMapping("loadRole")
	public ModelAndView loadRole(HttpServletRequest request,HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		
		List<JobInfo> result = jobInfoService.allJobInfoService();
		
		mav.addObject("jobInfoList", result);
		mav.setViewName("role");
		
		return mav;
	}
	
	/**
	 * 下拉菜单加载职位信息
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping("dropDownMenuRole")
	public ModelAndView dropDownMenuRole(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		List<JobInfo> result = jobInfoService.allJobInfoService();
		
		mav.addObject("jobInfoList", result);
		mav.setViewName("addUser");
		
		return mav;
	}
	
	/**
	 * 搜索职位
	 * @param request
	 * @param response
	 * @param keyWord
	 * @return
	 */
	@PostMapping("searchRole")
	@ResponseBody
	public List<JobInfo> search(HttpServletRequest request,HttpServletResponse response,String keyWord) {
		
		List<JobInfo> result = jobInfoService.searchJobInfoService(keyWord);
		
		return result;
	}
	
}
