package com.project.kdkhelloworld.login.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 모든 유저정보 요소
 * @author 김도겸
 *
 */
@Getter
@Setter
public class TotalUserInfoDTO {
	private String type; //타입(관리자용 A, 회원용 U) 
	private String userId; //유저 pk
	private String loginId; //로그인 아이디
	private String password; //비밀번호
	private String nickname; //별칭
	private String userName; //이름
	private String userPhoto; //프로필사진
	private int userPostsCnt; //글개수
	private int userCommentsCnt; //댓글개수
	private int userLevel; //레벨
	private int userVisitCnt; //방문횟수
	private int userReportCnt; //신고횟수
	private int userReportedCnt; //신고당한횟수
	private char userLoginYn; //로그인상태
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
