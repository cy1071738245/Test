package com.cy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cy.entity.Employee;
import com.cy.service.AboutAuthorityService;

/**
 * 分配权限控制
 * @author cy
 *
 */
@Controller
public class AssignAuthorityController {

	@Resource(name="aboutAuthorityService")
	private AboutAuthorityService aboutAuthorityService;
	
	@PostMapping("assignAuthority")
	public ModelAndView assignAuthority(HttpServletRequest request,HttpServletResponse response,Integer jobInfoId) {

		ModelAndView mav = new ModelAndView();
		
		String[] authorityArr = request.getParameterValues("second");
		
		Integer result = aboutAuthorityService.assignAuthorityService(jobInfoId, authorityArr);
		try
		{
			Employee employee = (Employee) request.getSession().getAttribute("employee");
			
			PrintWriter out = response.getWriter();
			if(result < -1) {
				out.print(-1);
			}
			if(result > -1)
			{
				if(jobInfoId == employee.getJobinfoId()) {
					out.print(0);
				}else {
					out.print(1);
				}
			}
			//必须关闭流，否则写出去的值会有html码
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		mav.setViewName("forward:shareRole");
		
		return mav;
	}
	
}
