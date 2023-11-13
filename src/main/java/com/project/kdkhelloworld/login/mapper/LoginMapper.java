package com.project.kdkhelloworld.login.mapper;

import org.springframework.stereotype.Repository;

import com.project.kdkhelloworld.login.dto.TotalUserInfoDTO;

@Repository("LoginMapper")
public interface LoginMapper {
	
	public void insertUserInfo(TotalUserInfoDTO dto) throws Exception;
	
	public void insertUserDetail(TotalUserInfoDTO dto) throws Exception;
	
}
