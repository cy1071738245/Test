package com.cy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cy.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Objects.isNull;

/**
 * 登录拦截器
 * @author cy
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*User user = (User) request.getSession().getAttribute("user");
		if(isNull(user)) {
			//未登录 返回登陆页面
			request.getRequestDispatcher("login").forward(request, response);
			return false;
		}else {
			//已登录 放行请求
			return true;
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		
	}

}
