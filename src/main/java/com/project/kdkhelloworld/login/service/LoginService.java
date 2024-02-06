package com.project.kdkhelloworld.login.service;

import java.util.Map;

import com.project.kdkhelloworld.login.dto.UserInfoDTO;

public interface LoginService {
	
	/**
	 * 로그인 확인
	 */
	public UserInfoDTO getloginVO(Map<String, Object> map);
	
	/**
	 * 유저 아이디 중복조회
	 */
	public String checkDuplicateLoginId(Map<String, String> map);
	
	
	/**
	 * 회원가입 데이터 저장
	 */
	public void userinfoSave(Map<String, Object> map);
}
