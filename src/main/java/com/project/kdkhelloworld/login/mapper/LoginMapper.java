package com.project.kdkhelloworld.login.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.project.kdkhelloworld.login.dto.UserInfoDTO;

@Repository("LoginMapper")
public interface LoginMapper {

	/**
	 * 중복조회
	 */
	public String selectDuplicateLoginId(Map<String, String> map);
	
	/**
	 * 로그인 (체크용)
	 */
	public UserInfoDTO selectLoginCheck(Map<String, Object> map);
	
	/**
	 * 로그인 (메인 화면 진입 시 유저정보)
	 */
	public UserInfoDTO selectLoginVO(Map<String, Object> map);
	
	/**
	 * 회원가입 userinfo 저장
	 */
	public void insertUserinfo(Map<String, Object> map);
	
	/**
	 * 회원가입 userinfoDetail 저장
	 */
	public void insertUserinfoDetail(Map<String, Object> map);
	
	/**
	 * Oauth 회원 체크용
	 */
	public String selectOauthLoginCheck(String userId);
}
