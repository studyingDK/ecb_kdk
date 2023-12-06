package com.project.kdkhelloworld.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 로그인 관련 서비스
 * @author 김도겸
 *
 */
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	
//	@Resource(name="txManager")
//	private DataSourceTransactionManager transactionManager;
	
	/**
	 * 로그인
	 */
//	@Override
//	public UserInfoDTO test() throws Exception {
//			
//		//Data set
//		UserInfoDTO userInfo = new UserInfoDTO();
//		userInfo.setUserId((String) map.get("userId"));
//		userInfo.setLoginId((String) map.get("setLoginId"));
//		userInfo.setPassword((String) map.get("password")); 
//		userInfo.setNickname((String) map.get("nickname")); 
//		userInfo.setUserPhoto((String) map.get("userPhoto")); 
//		userInfo.setUserPostsCnt((int) map.get("userPostsCnt"));
//		userInfo.setUserCommentsCnt((int) map.get("userCommentsCnt"));
//		userInfo.setUserLevel((int) map.get("userLevel"));
//		userInfo.setUserVisitCnt((int) map.get("userVisitCnt"));
//		userInfo.setUserReportCnt((int) map.get("userReportCnt"));
//		userInfo.setUserReportedCnt((int) map.get("userReportedCnt"));
//		userInfo.setUserReportedCnt((char) map.get("userLoginYn"));
//		userInfo.setRegId((String) map.get("regId"));
//		userInfo.setRegDtm((Date) map.get("regDtm"));
//		userInfo.setLstUpId((String) map.get("lstUpId"));
//		userInfo.setLstUpDtm((Date) map.get("lstUpDtm"));
//		
//		return userInfo;
//	}
	

	
	/**
	 * 신규 회원가입 data set
	 */
//	@Override
//	public TotalUserInfoDTO newMemberData(HttpServletRequest req) throws Exception {
//		TotalUserInfoDTO dto = new TotalUserInfoDTO();
//		
//		dto.setUserId(req.getParameter("userId"));
//		dto.setLoginId(req.getParameter("setLoginId"));
//		dto.setPassword(req.getParameter("password")); 
//		dto.setNickname(req.getParameter("nickname")); 
//		dto.setUserPhoto(req.getParameter("userPhoto")); 
//		dto.setUserName(req.getParameter("userName"));
//		dto.setUserGender(req.getParameter("userGender"));
//		dto.setUserName(req.getParameter("userPhone"));
//		dto.setUserBirthCd(req.getParameter("userBirthCd")); 
//		dto.setUserPhone(req.getParameter("userPhone")); 
//		dto.setUserZipCd(req.getParameter("userZipCd")); 
//		dto.setUserAddress(req.getParameter("userAddress"));
//		dto.setUserAddressDetail(req.getParameter("userAddressDetail"));
//		dto.setUserSecondaryEmail(req.getParameter("userSecondaryEmail"));
//
//		return dto;
//	}
	
	/**
	 * 신규 회원가입 data insert
	 */
//	@Override
//	public void insertMemberJoin(TotalUserInfoDTO dto) throws Exception {
//		logger.info("===================== 회원 데이터 insert 시작 =====================");
//		
//		loginMapper.insertUserInfo(dto);
//		loginMapper.insertUserDetail(dto);
//		
//		logger.info("===================== 회원 데이터 insert 종료 =====================");
//	}

}
