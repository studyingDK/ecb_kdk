package com.project.kdkhelloworld.board.service;

import java.util.List;
import java.util.Map;

import com.project.kdkhelloworld.board.dto.PostInfoDTO;


public interface BoardService {
	
	/**
	 * 게시글 생성
	 */
	public void postWriteCreate(PostInfoDTO dto);
	
	/**
	 * 게시글 조회
	 */
	
	/**
	 * 게시글 수정
	 */
	
	/**
	 * 게시글 삭제
	 */
	
	/**
	 * 게시글 카테고리 리스트 조회
	 */
	public List<PostInfoDTO> pstTypeCdList(Map<String, String> map);
	
	/**
	 * 게시글 말머리 리스트 조회
	 */
	public List<PostInfoDTO> pstPrefixList(Map<String, String> map);

}
