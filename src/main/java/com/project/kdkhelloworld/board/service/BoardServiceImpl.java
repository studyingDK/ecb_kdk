package com.project.kdkhelloworld.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.kdkhelloworld.board.dto.PostInfoDTO;
import com.project.kdkhelloworld.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Resource(name="BoardMapper")
	private BoardMapper mapper;
	
	/**
	 * 게시판 이름(목록) 조회
	 */
	@Override
	public List<PostInfoDTO> pstBoardNm(Map<String, Object> map) {		
		//하나만 조회 필요할 경우 searchType="oneSearch" 값 받는다.
		return mapper.selectBoardNm(map);
	}
	
	/**
	 * 해당 게시판 인기글 목록 조회
	 */
	@Override
	public List<PostInfoDTO> boardPopularList(Map<String, Object> map) {
		return mapper.selectBoardPopular(map);
	}
	
	/**
	 * 게시글 생성
	 */
	@Override
	public void postWriteCreate(PostInfoDTO dto) {
		
		//트랜잭션 처리 필요
		mapper.insertCreatePost(dto); //글 생성
		mapper.updatePstNo(dto); //해당 게시판 카테고리 번호 +1	
	}
	
	/**
	 * 게시글 조회
	 */
	@Override
	public PostInfoDTO postRead(Map<String, Object> map) {
		return mapper.selectPosts(map);	
	}
	
	/**
	 * 게시글 수정
	 */
	
	/**
	 * 게시글 삭제
	 */
	
	/**
	 * 게시글 카테고리 리스트 조회
	 */
	@Override
	public List<PostInfoDTO> pstCtgCdList(Map<String, Object> map) {
		return mapper.selectPstCtgList(map);
	}
	
	/**
	 * 게시글 말머리 리스트 조회
	 */
	@Override
	public List<PostInfoDTO> pstPrefixList(Map<String, Object> map) {
		return mapper.selectTitlePrefixList(map);
	}
}
