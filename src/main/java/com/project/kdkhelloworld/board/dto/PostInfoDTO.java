package com.project.kdkhelloworld.board.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 게시글 DTO
 * @author 김도겸
 *
 */
@Getter
@Setter
public class PostInfoDTO {
	private String pstId; //게시글 pk
	private String pstCtgCd; //게시판 종류
	private int pstNo; //게시글 번호
	private String pstTypeCd; //게시글 유형
	private String pstTitlePrefix; //게시글 말머리 
	private String pstTitle; //게시글 제목 
	private String pstContent; //게시글내용
	private int pstLikeCnt; //좋아요 개수
	private int pstReportCnt; //신고횟수
	private String pstCommentYn; //댓글게시유무
	private String pstLookupChk; //조회조건
	private String pstCommnetChk; //댓글조건
	
	private String regId; //등록id
	@DateTimeFormat(pattern = "YYYY=MM=DD'T'HH:mm:ss")
	private Date regDtm; //등록일자
	private String lstUpId; //수정id
	@DateTimeFormat(pattern = "YYYY=MM=DD'T'HH:mm:ss")
	private Date lstUpDtm; //수정일자
}
