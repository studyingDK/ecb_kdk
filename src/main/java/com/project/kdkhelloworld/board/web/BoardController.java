package com.project.kdkhelloworld.board.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 게시판 관련 Controller
 * @author 김도겸
 *
 */
@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * 게시판 메인페이지 진입
	 */
	@PostMapping(value="/main")
	public String boardMainPage(HttpServletRequest request) throws Exception {
		
		//게시판 목록 불러오기
		
		return "/board/boardMain";
	}
	
	/**
	 * 해당 게시판 페이지 이동
	 */
	@PostMapping(value="/{pstCtdCd}")
	public String boardCategoryMove(HttpServletRequest request) throws Exception {
		String boardType = request.getParameter("pstCtdCd");
		
		
		
		if("해당 게시판 없으면".equals("asd")) {
			//에러처리
		}
		
		return "/board/"+boardType;
	}
	
	/**
	 * 게시글 조회
	 */
	@PostMapping(value="/{pstCtdCd}/{}")
	public String postSelect(HttpServletRequest request) throws Exception{
		String boardType = request.getParameter("pstCtdCd");
		String postcrudType = request.getParameter("pstCtdCd");
		
		if("해당 게시판 없으면".equals("asd")) {
			//에러처리
		}
		
		return "/board/"+boardType;
	}
	
	/**
	 * 게시글 생성
	 */
	
	/**
	 * 게시글 수정
	 */
	
	/**
	 * 게시글 삭제
	 */

}
