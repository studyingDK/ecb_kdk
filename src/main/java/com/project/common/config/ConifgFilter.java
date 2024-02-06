package com.project.common.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.PatternMatchUtils;

public class ConifgFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(ConifgFilter.class);
	
	//허용한 URL
	private static final String[] allowedOrigins = {
            "http://localhost:8181", "http://127.0.0.1:5500"
	};

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//    	if (servletRequest == null) {
//    		return;
//    	}
//    	
//    	HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String requestOrigin = request.getHeader("Origin");       
//    	
//        //CORS 아닌 경우
//        if (requestOrigin == null) {
//        	chain.doFilter(request, servletResponse);
//        }
//        
//        //****************************** CORS Filter *******************************
//    	if(isAllowedOrigin(requestOrigin)) {
//    		logger.info("허용 Origins\n" + requestOrigin);
//            // Authorize the origin, all headers, and all methods
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", requestOrigin);
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "*");
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
//                    "GET, OPTIONS, HEAD, PUT, POST, DELETE");
//            response.setHeader("Access-Control-Allow-Origin", requestOrigin);
//            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
//     
//            // CORS handshake (pre-flight request)
//            if (request.getMethod().equals("OPTIONS")) {
//            	response.setStatus(HttpServletResponse.SC_ACCEPTED);           	
//                return;
//            }
//            
//            chain.doFilter(request, servletResponse);
//        }
//        
//        else {
//        	response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        	response.getWriter().write("Access denied: Origin not allowed");
//        	return;
//        }              
//       //***************************** CORS Filter end *****************************
//        
//    }
//    
//    //허용한 URL 확인 메소드
//    private boolean isAllowedOrigin(String origin){
//    	if (origin == null) {
//    		return false;
//    	}
//    	
//    	return PatternMatchUtils.simpleMatch(allowedOrigins, origin);
//    }
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
}
