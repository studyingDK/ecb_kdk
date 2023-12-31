package com.project.kdkhelloworld.login.service;

import javax.servlet.http.HttpServletRequest;

import com.project.kdkhelloworld.login.dto.TotalUserInfoDTO;

public interface LoginService {
	
	/**
	 * 로그인
	 */
//	public UserInfoDTO memberJoinInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 신규 회원가입 data set
	 */
	public TotalUserInfoDTO newMemberData(HttpServletRequest req) throws Exception;
	
	/**
	 * 신규 회원가입 data insert
	 */
	public void insertMemberJoin(TotalUserInfoDTO dto) throws Exception;
}
