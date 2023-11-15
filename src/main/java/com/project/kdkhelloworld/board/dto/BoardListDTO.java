package com.project.kdkhelloworld.board.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListDTO {
	private String pstCtgCd; //게시판 종류
	private String pstCtgNm; //게시판 이름
	
	private String regId; //등록id
	@DateTimeFormat(pattern = "YYYY=MM=DD'T'HH:mm:ss")
	private Date regDtm; //등록일자
}
