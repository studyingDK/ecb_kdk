package com.project.kdkhelloworld.board.service;

import java.util.List;
import java.util.Map;

import com.project.kdkhelloworld.board.dto.PostInfoDTO;


public interface BoardService {
	
	/**
	 * 게시판 이름(목록) 조회
	 */
	public List<PostInfoDTO> pstBoardNm(Map<String, Object> map);
	
	/**
	 * 해당 게시판 인기글 목록 조회
	 */
	public List<PostInfoDTO> boardPopularList(Map<String, Object> map);
	
	/**
	 * 게시글 생성
	 */
	public void postWriteCreate(PostInfoDTO dto);
	
	/**
	 * 게시글 조회
	 */
	public PostInfoDTO postRead(Map<String, Object> map);
	
	/**
	 * 게시글 수정
	 */
	
	/**
	 * 게시글 삭제
	 */
	
	/**
	 * 게시글 카테고리 리스트 조회
	 */
	public List<PostInfoDTO> pstCtgCdList(Map<String, Object> map);
	
	/**
	 * 게시글 말머리 리스트 조회
	 */
	public List<PostInfoDTO> pstPrefixList(Map<String, Object> map);

}
