package com.project.kdkhelloworld.main;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 메인 페이지
 * @author 김도겸
 *
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	 * 메인 페이지 redirection
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/")
	public String mainPageRedirect() throws IOException {
 
		return "redirect:/home";
	}
	
	/**
	 * 메인 페이지 진입
	 * @return
	 */
	@RequestMapping(value = "/home")
	public String mainPage(HttpServletRequest req) {
		logger.info("==================main==================");
		
		logger.info("맛있는 쿠키 ㅇㅅㅇ "+req.getCookies());
		return "/home";
	}
}
