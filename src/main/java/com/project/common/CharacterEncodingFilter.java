package com.project.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {		
		// 받은 요청에 대해 문자 인코딩
		request.setCharacterEncoding("UTF-8");		
		
		// 다음 필터 또는 서블릿으로 전달
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}
}
