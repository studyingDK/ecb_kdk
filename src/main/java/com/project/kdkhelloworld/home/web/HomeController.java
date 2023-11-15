package com.project.kdkhelloworld.home.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 메인페이지 Controller
 * @author 김도겸
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 메인 페이지 진입
	 */
	@RequestMapping(value = "/")
	public String mainPageRedirect(HttpServletRequest request) {
		

		return "redirect:/home";
	}
	
	/**
	 * 메인 페이지 진입
	 */
	@RequestMapping(value = "/home")
	public String mainPage(HttpServletRequest request) {
		logger.info("================== Home 진입 ==================");
		
		HttpSession session = request.getSession();
		
		logger.info("맛있는 쿠키 ㅇㅅㅇ "+request.getCookies());
		logger.info("세션 "+session);
		logger.info("세션 Id"+session.getId());
		
		//관리자가 설정한 시스템설정 값 조회 및 적용(설정한 것들 무엇이 있을지 생각해보기)
		
		//접속 클라이언트 쿠키 조회(필요한 유저 정보 조회)
		
		//메인게시판 
		
		//게시판 인기글 목록

		//유저 랭킹 목록

		return "/home";
	}
}
