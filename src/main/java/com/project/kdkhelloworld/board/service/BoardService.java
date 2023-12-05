package com.project.kdkhelloworld.board.service;

import com.project.kdkhelloworld.board.dto.BoardListDTO;
import com.project.kdkhelloworld.board.dto.PostInfoDTO;

public interface BoardService {
	
	/**
	 * 게시판 메인페이지 목록
	 */
	public BoardListDTO selectBoardList() throws Exception;
	
	/**
	 * 게시글 조회
	 */
	
	/**
	 * 게시글 생성
	 */
	
	public PostInfoDTO postWrite();
	
	/**
	 * 게시글 수정
	 */
	
	/**
	 * 게시글 삭제
	 */
}
