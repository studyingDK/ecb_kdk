package com.project.kdkhelloworld.login.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.ECBCommon;
import com.project.kdkhelloworld.login.dto.UserInfoDTO;
import com.project.kdkhelloworld.login.mapper.LoginMapper;

/**
 * 로그인 관련 서비스
 * @author kdkhelloworld
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Resource(name="LoginMapper")
	private LoginMapper mapper;
	
	@Autowired
	private ECBCommon common;
	
	/**
	 * 로그인 확인
	 */
	@Override
	public UserInfoDTO getloginVO(Map<String, Object> map) {	
		UserInfoDTO result = new UserInfoDTO();
		
		//유저 정보 or 체크용 판별
		if ("Y".equals(map.get("check"))) {
			logger.debug("유저정보 ");
			result = mapper.selectLoginVO(map);
		}
		else {
			logger.debug("체크용 ");
			map.put("sPassword", common.hashPassword(map.get("sPassword").toString()));
			result = mapper.selectLoginCheck(map);
		}
		
		return result;
	}
	
	/**
	 * 중복조회
	 */
	@Override
	public String checkDuplicateLoginId(Map<String, String> map) {
		Optional<String> result = Optional.ofNullable(mapper.selectDuplicateLoginId(map));
		
		// 조회되는 값 없으면 중복X
		if (!result.isPresent()) {
			return "possible";
		}
		
		return "duplicate";
	}
	
	/**
	 * 입력 받은 회원 데이터 저장
	 */
	@Override
	public void userinfoSave(Map<String, Object> map) {
		UUID myUuid = UUID.randomUUID();
		String user = myUuid.toString().replace("-", ""); 
		
		map.put("sUserId", user);
		map.put("sPassword", common.hashPassword(map.get("sPassword").toString()));
		map.put("sloginType", "L");
		
		//try catch랑 트랜잭션 처리 필요.
		mapper.insertUserinfo(map);
		mapper.insertUserinfoDetail(map);	
	}
}
