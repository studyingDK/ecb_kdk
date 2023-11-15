package com.project.kdkhelloworld.login.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 유저 로그인에 필요한 DTO
 * @author 김도겸
 *
 */
@Getter
@Setter
public class UserInfoDTO {
	
	private String userId; //유저 pk
	private String loginId; //로그인 아이디
	private String password; //비밀번호
	private String nickname; //별칭
	private String userPhoto; //프로필사진
	private int userPostsCnt; //글개수
	private int userCommentsCnt; //댓글개수
	private int userLevel; //레벨
	private int userVisitCnt; //방문횟수
	private int userReportCnt; //신고횟수
	private int userReportedCnt; //신고당한횟수
	private String userLoginYn; //로그인상태
	private String regId; //등록id
	@DateTimeFormat(pattern = "YYYY=MM=DD'T'HH:mm:ss")
	private Date regDtm; //등록일자
	private String lstUpId; //수정id
	@DateTimeFormat(pattern = "YYYY=MM=DD'T'HH:mm:ss")
	private Date lstUpDtm; //수정일자
}
