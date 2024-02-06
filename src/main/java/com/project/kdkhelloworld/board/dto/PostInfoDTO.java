package com.project.kdkhelloworld.board.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 게시글 DTO
 * @author kdkhelloworld
 *
 */
@Data
public class PostInfoDTO {
	private long pstId; //게시글 pk
	private String pstKindCd; //게시판 종류 코드
	private String pstKindNm; //게시판 종류 이름
	private long pstCtgCd; //게시글 카테고리 코드
	private String pstCtgNm; //게시글 카테고리 이름
	private String pstTypeCd; //게시글 유형 코드 (공지:A , 일반:C 등)
	private String pstTypeNm; //게시글 유형 이름
	private long pstNo; //게시글 번호
	private long pstTitlePrefixCd; //게시글 말머리 코드 
	private String pstTitlePrefixNm; //게시글 말머리 이름
	private String pstTitle; //게시글 제목 
	private String pstContent; //게시글 내용
	private int pstViews; //조회수
	private int pstLikeCnt; //좋아요 개수
	private int pstReportCnt; //신고횟수
	private String pstCommentYn; //댓글게시유무 (E:모두 허용, M:회원만, N:허용 안함)
	private String pstLookupChk; //조회조건 (E:모두 허용, M:회원만)
	private String pstCommentChk; //댓글조건
	private String nickname; //별칭
	private int rowNum; //순위
	private String regId; //등록id
	@DateTimeFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
	private Date regDtm; //등록일자
	private String lstUpId; //수정id
	@DateTimeFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
	private Date lstUpDtm; //수정일자
	
	private String regDtmToString; //등록일자 dateFormatter return
	private String lstUpDtmToString; //수정일자 dateFormatter return
	
	//날짜 형식 보기 좋게 변경
	//Mon Dec 11 09:59:33 KST 2023 → 20231211095933
	public String dateFormatter(Date pDate) {
		String tmp = pDate.toString();
		String result ="";
		
		SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		
		try {
			Date date = inputFormat.parse(tmp);
			
			// 포맷 변경
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result = outputFormat.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
}
