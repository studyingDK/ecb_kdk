package com.project.kdkhelloworld.login.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 유저 개인정보 DTO
 * @author 김도겸
 *
 */
@Getter
@Setter
public class UserInfoDetailDTO {
	
	private String userId; //유저 pk
	private String userName; //이름
	private String userGender; //성별
	private String userPhone; //전화번호
	private String userBirthCd; //생일
	private String userZipCd; //우편번호
	private String userAddress; //주소
	private String userAddressDetail; //상세주소
	private String userSecondaryEmail; //복구이메일
	private String regId; //등록id
	@DateTimeFormat(pattern = "YYYY=MM=DD'T'HH:mm:ss")
	private Date regDtm; //등록일자
	private String lstUpId; //수정id
	@DateTimeFormat(pattern = "YYYY=MM=DD'T'HH:mm:ss")
	private Date lstUpDtm; //수정일자
}
