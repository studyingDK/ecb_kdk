package com.project.kdkhelloworld.board.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.project.kdkhelloworld.board.dto.PostInfoDTO;

@Repository("BoardMapper")
public interface BoardMapper {
	
	/**
	 * 게시판 이름(목록) 조회
	 */
	public List<PostInfoDTO> selectBoardNm(Map<String, Object> map);
	
	/**
	 * 해당 게시판 인기글 목록 조회
	 */
	public List<PostInfoDTO> selectBoardPopular(Map<String, Object> map);
	
	/**
	 * 게시글 생성
	 */
	public void insertCreatePost(PostInfoDTO dto);
	
	/**
	 * 해당 게시판 카테고리 번호 +1	
	 */
	public void updatePstNo(PostInfoDTO dto);
	
	/**
	 * 게시글 조회
	 */
	public PostInfoDTO selectPosts(Map<String, Object> map);
	
	/**
	 * 게시글 수정
	 */

	/**
	 * 게시글 삭제
	 */
	
	/**
	 * 게시글 카테고리 리스트 조회
	 */
	public List<PostInfoDTO> selectPstCtgList(Map<String, Object> map);
	
	/**
	 * 게시글 말머리 리스트 조회
	 */
	public List<PostInfoDTO> selectTitlePrefixList(Map<String, Object> map);
}
