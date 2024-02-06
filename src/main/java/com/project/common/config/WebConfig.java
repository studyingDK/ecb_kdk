package com.project.common.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author kdkhelloworld
 *
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).order(1).addPathPatterns("/**").excludePathPatterns(
				"/css/**", "/fonts/**", "/images/**"
				);
	}
	


}
