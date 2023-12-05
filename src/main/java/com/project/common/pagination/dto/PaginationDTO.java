package com.project.common.pagination.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 페이지네이션 DTO
 * @author 김도겸
 *
 */
@Getter
@Setter
public class PaginationDTO {
	private int totalItem; //전체 아이템 수
	private int pageListCount; //한 페이지 보여줄 목록 건수
	private double totalPage; // 페이지 개수
	private int curPage; //현재 페이지
	private int startNum; //시작 
	private int endNum; //끝
	private String searchType; //검색 타입
	private String searchKeyword; //검색 키워드
	private String pageSortType; //정렬 타입(ASC, DESC)
	private String pageSortKeyword; //정렬기준 키워드
}
