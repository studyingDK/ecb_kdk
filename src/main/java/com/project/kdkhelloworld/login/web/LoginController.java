package com.project.kdkhelloworld.login.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.kdkhelloworld.login.dto.UserInfoDTO;
import com.project.kdkhelloworld.login.service.LoginService;
import com.project.kdkhelloworld.login.service.OauthLoginService;

/**
 * 로그인 Controller
 * 
 * @author kdkhelloworld
 *
 */
@RequestMapping(value = "/login")
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private LoginService loginService;
	
	@Resource
	private OauthLoginService oauthLoginService;

	/**
	 * 로그인 페이지 진입
	 */
	@PostMapping(value = "")
	public String loginPage(HttpServletRequest request) {
		// 해당 클라이언트의 로그인 정보(쿠키, 세션등)

		return "/login/login";
	}

	/**
	 * 로그인
	 */
	@PostMapping(value = "/local")
	@ResponseBody
	public UserInfoDTO loginCheck(@RequestBody Map<String, Object> map) {
		logger.debug("================== login 진입 ==================");

		// 모바일 시스템 추가 시 판별 로직 필요.

		// 로그인 데이터 체크
		Optional<UserInfoDTO> tmp = Optional.ofNullable(loginService.getloginVO(map));
		UserInfoDTO result = new UserInfoDTO();

		if (tmp.isPresent()) {
			result = tmp.get();
			// 접속중인 상태가 아닐 때
			if (result.getUserLoginYn().equals("N")) {
				logger.debug("로그인 성공");
			} else {
				logger.debug("중복 로그인");
				result.setUserLoginYn("D");
			}
		} else {
			logger.debug("로그인 실패");

		}

		return result;
	}

	/**
	 * 회원가입 페이지 진입
	 */
	@PostMapping(value = "/member")
	public String memberJoinPage() {

		return "/login/memberJoin";
	}

	/**
	 * 회원가입 시 데이터 중복조회
	 */
	@PostMapping(value = "/duplicateCheck")
	@ResponseBody
	public String idDuplicateCheck(@RequestBody Map<String, Object> map) {
		Optional<String> type = Optional.ofNullable((String) map.get("type"));
		Optional<String> inputText = Optional.ofNullable((String) map.get("inputText"));

		// 파라미터 확인
		if (!type.isPresent() || !inputText.isPresent()) {
			logger.error("중복조회 할 type 혹은 inputText 값이 없습니다.");
			return "fail";
		}

		Map<String, String> pMap = new HashMap<>();

		if (type.get().equals("loginId")) {
			pMap.put("loginId", inputText.get());
		} else {
			pMap.put("nickname", inputText.get());
		}

		Optional<String> tmp = Optional.ofNullable(loginService.checkDuplicateLoginId(pMap));

		return tmp.get();
	}
	
	/**
	 * 입력 받은 회원 데이터 저장
	 */
	@PostMapping(value = "/memberSave")
	@ResponseBody
	public String memberJoin(@RequestBody Map<String, Object> map) throws Exception {
		logger.debug("===================== 회원가입 정보 저장 시작 =====================");

		// try catch 처리 필요.
		loginService.userinfoSave(map);

		return "success";
	}
	
	/**************************************** Oauth Login ****************************************/
	
	/**
	 * Oauth 로그인 결과 화면
	 */
	@RequestMapping(value = "/oauth/getLogin")
	public String nGetToken(HttpServletRequest request, Model model,
			@RequestParam(required = false) String access_token, @RequestParam(required = false) String refresh_token,
			@RequestParam(required = false) String token_type, @RequestParam(required = false) String expires_in) {
		logger.debug("===================== Oauth 로그인 결과 화면 =====================");

		model.addAttribute("request", request);

		return "/login/oauthLoginResult";
	}

	/**
	 * Naver oauth 로그인
	 * @param code : 네이버 로그인 인증에 성공하면 반환받는 인증 코드, 접근 토큰(access token) 발급에 사용
	 * @param state : 사이트 간 요청 위조 공격을 방지하기 위해 애플리케이션에서 생성한 상태 토큰으로 URL 인코딩을 적용한 값
	 * @param error : 네이버 로그인 인증에 실패하면 반환받는 에러 코드
	 * @param error_description : 네이버 로그인 인증에 실패하면 반환받는 에러 메시지
	 */
	@RequestMapping(value = "/oauth/nRedirect")
	public String nRedirect(HttpServletRequest request, Model model, @RequestParam(required = false) String code,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String error,
			@RequestParam(required = false) String error_description) {
		logger.debug("===================== Oauth Login - Naver =====================");
		
		String result = oauthLoginService.naverOauth(code, state);
		
		if ("error".equals(result)) {
			logger.error("=================== Oauth Login(Naver) ERROR ===================");
		}
		
		model.addAttribute("request", request);

		return "/oauth/getLogin";
	}

	/**
	 * Kakao oauth 로그인
	 * @param code : 토큰 받기 요청에 필요한 인가 코드
	 * @param state : 요청 시 전달한 state 값과 동일한 값
	 * @param error : 인증 실패 시 반환되는 에러 코드
	 * @param error_description : 인증 실패 시 반환되는 에러 메시지
	 */
	@RequestMapping(value = "/oauth/kRedirect")
	public String kRedirect(HttpServletRequest request, Model model, @RequestParam(required = false) String code,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String error,
			@RequestParam(required = false) String error_description) {
		logger.debug("===================== Oauth Login - Kakao =====================");
		
		String result = oauthLoginService.kakaoOauth(code, state);
		
		return "/oauth/getLogin";
	}

	/**
	 * Google oauth redirect
	 * 
	 * @return 응답 데이터
	 */
	@RequestMapping(value = "$", method = RequestMethod.POST)
	public String gRedirect(HttpServletRequest request, Model model) {
		logger.info("=====================oauth 로그인~=======================");
		return "1234";
	}

}
