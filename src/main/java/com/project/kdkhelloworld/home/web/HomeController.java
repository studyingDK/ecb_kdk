package com.project.kdkhelloworld.home.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.common.ClientUtils;
import com.project.common.redis.service.RedisService;
import com.project.kdkhelloworld.login.dto.UserInfoDTO;
import com.project.kdkhelloworld.login.service.LoginService;

/**
 * 메인페이지 Controller
 * @author kdkhelloworld
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ClientUtils clientUtils;
	
	@Resource
	private LoginService loginService;
	
	@Resource
	private RedisService redisService;
	
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
	public String mainPage(HttpServletRequest request, 
			@RequestParam(required = false) String sLoginId,
			@RequestParam(required = false) String sPassword,
			@RequestParam(required = false) String check,
			@ModelAttribute UserInfoDTO userInfo) {
		logger.debug("================== Home 진입 ==================");

		String clientIP = clientUtils.getClientIpAddress(request);
		
		//로그인 정보가 없을 때 메인 화면으로 진입.
		if (!"Y".equals(check)) {
			return "/home";
		}
		
		/* 로그인 유저 정보 세팅 *********************************************/
		Map<String, Object> map = new HashMap<>();
		
		map.put("sLoginId", sLoginId);
		map.put("sPassword", sPassword);
		map.put("check", check);
		
		UserInfoDTO loginVO = loginService.getloginVO(map);
		
		HttpSession session = request.getSession();

		logger.debug("로그인 유저 Session = "+session);
		
		Map<String, Object> redis = new HashMap<>();
		redis.put("testAdmin", UUID.randomUUID().toString());
		redisService.redisInsert("testAdmin", redis);
		
		logger.debug("redis Select = "+redisService.redisSelect("testAdmin"));
		
		/* 로그인 하여 포탈 홈으로 돌아올 때 받는 파라미터 및 VALUE 세팅
		 * ㆍ관리자가 설정한 시스템설정 값 조회 및 적용(설정한 것들 무엇이 있을지 생각해보기)
		 * ㆍ접속 클라이언트 쿠키 조회(필요한 유저 정보 조회)
		*/
		
		//메인게시판 
		
		//게시판 인기글 목록

		//유저 랭킹 목록

		return "/home";
	}
}
