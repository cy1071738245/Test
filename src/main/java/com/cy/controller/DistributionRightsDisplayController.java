package com.cy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cy.entity.AuthorityJob;
import com.cy.service.AboutAuthorityService;

/**
 * 权限展示控制
 * @author cy
 *
 */
@Controller
public class DistributionRightsDisplayController {

	@Resource(name="aboutAuthorityService")
	private AboutAuthorityService aboutAuthorityService;
	
	@RequestMapping("distributionRightsDisplay")
	public ModelAndView distributionRightsDisplay(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> result = aboutAuthorityService.queryAllLevelAuthorityService();
		
		mav.addObject("distributionRightsList", result);
		mav.setViewName("shareRole");
		
		return mav;
	}
	
	@RequestMapping("checkAuthority")
	public void checkAuthority(HttpServletRequest request,HttpServletResponse response,Integer jobInfoId) {
		
		List<AuthorityJob> authorityJobResult = aboutAuthorityService.queryRoleAuthorityIdService(jobInfoId);
		for (AuthorityJob authorityJob : authorityJobResult) {
			try
			{
				PrintWriter out = response.getWriter();
				out.print("s"+authorityJob.getAuthorityId()+",");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
