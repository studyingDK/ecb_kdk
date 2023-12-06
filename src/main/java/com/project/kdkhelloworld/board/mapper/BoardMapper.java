package com.project.kdkhelloworld.board.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.project.kdkhelloworld.board.dto.PostInfoDTO;

@Repository("BoardMapper")
public interface BoardMapper {
	
	/**
	 * 게시글 생성
	 */
	public void insertCreatePost(PostInfoDTO dto);
	
	/**
	 * 해당 게시판 글 번호 +1
	 */
	public void updatePstNo(PostInfoDTO dto);
	
	
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
	public List<PostInfoDTO> selectPstTypeCd(Map<String, String> map);
	
	/**
	 * 게시글 말머리 리스트 조회
	 */
	public List<PostInfoDTO> selectTitlePrefix(Map<String, String> map);
}
