package com.cy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cy.interceptor.LoginInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	/**
	 * 拦截器配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册拦截器
		LoginInterceptor loginInterceptor = new LoginInterceptor();
		InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
		String[] excludePathPatterns = new String[]{"/register", "/login", "/getArticleById*",
				"/poetry-list", "/article-list", "/poetryList*", "/articleList*", "/upload/*"};
		//排除路径
		loginRegistry.excludePathPatterns(excludePathPatterns);
		//拦截路径
		loginRegistry.addPathPatterns("/*");
		
	}
	
}
