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

import com.cy.entity.JobInfo;
import com.cy.service.JobInfoService;

/**
 * 更改职位信息控制
 * @author cy
 *
 */
@Controller
public class AboutRoleController {

	@Resource(name="jobInfoService")
	private JobInfoService jobInfoService;
	
	@PostMapping("operateRole")
	public ModelAndView operateRole(HttpServletRequest request,HttpServletResponse response,Integer jobInfoId,String jobInfoName,Integer departmentId) {
		
		ModelAndView mav = new ModelAndView();
		
		JobInfo jobInfo = new JobInfo();
		jobInfo.setJobInfoId(jobInfoId);
		if(jobInfoName == "") {
			
		}else {
			jobInfo.setJobInfoName(jobInfoName);
		}
		jobInfo.setDepartmentId(departmentId);
		
		Integer result = jobInfoService.operateRoleService(jobInfo);
		
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
		
		mav.setViewName("forward:role");
		
		return mav;
	}
	
	@RequestMapping("checkJobInfoName")
	public void checkJobInfoName(HttpServletRequest request,HttpServletResponse response,String jobInfoName) {
		
		JobInfo result = jobInfoService.checkJobInfoName(jobInfoName);
		
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
