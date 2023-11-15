package com.project.kdkhelloworld.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.kdkhelloworld.login.dto.TotalUserInfoDTO;
import com.project.kdkhelloworld.login.service.LoginServiceImpl;

/**
 * 로그인 Controller
 * @author 김도겸
 *
 */
@RequestMapping(value = "/login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
	private LoginServiceImpl loginServiceImpl;
	
	/**
	 * 로그인 페이지 진입
	 */
	@PostMapping(value = "")
	public String loginPage() {
		//해당 클라이언트의 로그인 정보(쿠키, 세션등)
		
		return "/login/login";
	}
	
	/**
	 * 회원가입 페이지 진입
	 */
	@PostMapping(value="/member")
	public String memberJoinPage() {
		
		return "login/memberJoin";
	}
	
	/**
	 * 입력 받은 회원 데이터 저장
	 */
	@PostMapping(value="#")
	public String memberJoin(HttpServletRequest request, BindingResult bindingResult) throws Exception {
		logger.debug("===================== 회원가입 =====================");
		
		//Validation failed
	    if (bindingResult.hasErrors()) {
	        return "redirect:/login/member";
	    }
		
		TotalUserInfoDTO dto = new TotalUserInfoDTO();
		dto = loginServiceImpl.newMemberData(request);
		
		loginServiceImpl.insertMemberJoin(dto);
		
		//회원가입 끝나고 난 후 다시 로그인 페이지로
		
		return "login/memberJoin";
	}
	
	
	
	/**
	 * Naver oauth redirect
	 * @return 응답 데이터
	 */
	@RequestMapping(value="/login/oauth/nRedirect", method = RequestMethod.POST)
	public String nRedirect(HttpServletRequest request, Model model) {
		logger.info("===================== naver 응답값 =====================");
		
		
		logger.info("");
		
		model.addAttribute("request", request);
		
		return "/login/callback";
	}
	
	/**
	 * Kakao oauth redirect
	 * @return 응답 데이터
	 */
	@RequestMapping(value="/login/oauth/kRedirect", method = RequestMethod.POST)
	public String kRedirect(HttpServletRequest request, Model model) {
		logger.info("=====================oauth 로그인~=======================");
		return "1234";
	}
	
	/**
	 * Google oauth redirect
	 * @return 응답 데이터
	 */
	@RequestMapping(value="$", method = RequestMethod.POST)
	public String gRedirect(HttpServletRequest request, Model model) {
		logger.info("=====================oauth 로그인~=======================");
		return "1234";
	}

}
