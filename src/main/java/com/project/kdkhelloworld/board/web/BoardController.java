package com.project.kdkhelloworld.board.web;

import java.net.http.HttpRequest;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.kdkhelloworld.board.dto.PostInfoDTO;

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
	public String boardCategoryMove(@PathVariable String pstCtdCd, HttpServletRequest request, Model model) throws Exception {
		String boardType = pstCtdCd;
		
		
		if("해당 게시판 없으면".equals("asd")) {
			//에러처리
		}
		
		logger.info("boardType=" + boardType);
		model.addAttribute("boardType", boardType);
		
		return "/board/boardDetail";
	}
	
	/**
	 * 게시글 조회
	 */
	@PostMapping(value="/{pstCtdCd}/{}")
	public String postSelect(HttpServletRequest request, Model model) throws Exception{
		String boardType = request.getParameter("pstCtdCd"); //게시판 종류

		
		if("해당 게시판 없으면".equals("asd")) {
			//에러처리
		}
		
		model.addAttribute("boardType", boardType);
		
		return "/board/"+boardType;
	}
	
	/**
	 * 글쓰기 페이지 이동
	 */
	@PostMapping(value="/{pstCtdCd}/postwrite")
	public String postWritePage(HttpServletRequest request, Model model, @RequestParam String pstCtdCd) {
		String boardType = request.getParameter("pstCtdCd"); //게시판 종류
		//해당 게시판 카테고리
		
		model.addAttribute("boardType", boardType);
		
		return "/board/boardPost";
	}
	
	/**
	 * 게시글 생성
	 */
	@PostMapping(value="/postCreate")
	@ResponseBody
	public String postWrite(HttpServletRequest request, @RequestBody PostInfoDTO dto) throws Exception{			
//		String pstCtdCd = dto.getPstCtgCd(); //게시글 종류 (게시판)
//		String pstTypeCd = dto.getPstTypeCd(); //게시글 유형 (카테고리)
//		String pstTitlePrefix= dto.getPstTitlePrefix(); //게시글 말머리 
//		String pstTitle = dto.getPstTitle(); //게시글 제목 
//		String pstContent = dto.getPstContent(); //게시글내용
//		String pstCommentYn = dto.getPstCommentYn(); //댓글게시유무 (E:모두허용,M:회원만, N:허용안함)
//		String pstLookupChk = dto.getPstLookupChk(); //조회조건 (E:모두허용,M:회원만)
//		String pstCommnetChk  = dto.getPstCommnetChk(); //댓글조건 (나중에 명확하게 분류 - 레벨, 조건없음 등)
		
		//데이터 넘어가는거 까지 확인했고 글 서비스쪽에서 insert 로직짜기
		
		return "success";
	}
	
	/**
	 * 게시글 수정
	 */
	
	/**
	 * 게시글 삭제
	 */

}
