package com.project.kdkhelloworld.login.service;

import java.util.Map;

public interface OauthLoginService {
	
	/**
	 * 기존 Oauth 로그인 회원 판별 및 중복로그인 체크
	 */
	public String existenceUser(String userId);
	
	/**
	 * Oauth 회원 데이터 저장
	 */
	public void oauthUserinfoSave(Map<String, Object> map);
	
	/**
	 * 네이버 Oauth 로그인
	 */
	public String naverOauth(String code, String state);
	
	/**
	 * 카카오 Oauth 로그인
	 */
	public String kakaoOauth(String code, String state);

}
