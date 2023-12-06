package com.project.kdkhelloworld.board.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.kdkhelloworld.board.dto.PostInfoDTO;
import com.project.kdkhelloworld.board.mapper.BoardMapper;
import com.project.kdkhelloworld.board.service.BoardService;

/**
 * 게시판 관련 Controller
 * @author 김도겸
 *
 */
@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource
	private BoardService boardService;

	
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
		
		Map<String, String> map = new HashMap<>();
		map.put("pstCtgCd", boardType);
		
		//카테고리 세팅
		List<PostInfoDTO> typeCdList = boardService.pstTypeCdList(map); 
		List<String> pstTypeCd = new ArrayList<>();
		
		for (PostInfoDTO tmp: typeCdList) {
			pstTypeCd.add(tmp.getPstTypeCd());
		}
		
		//말머리 세팅
		List<PostInfoDTO> prefixList = boardService.pstPrefixList(map);
		List<String> pstTitlePrefix = new ArrayList<>();
		
		for (PostInfoDTO tmp: prefixList) {
			pstTitlePrefix.add(tmp.getPstTitlePrefix());
		}
		
		
		

		model.addAttribute("boardType", boardType);
		model.addAttribute("titlePrefixList", pstTitlePrefix);
		model.addAttribute("typeCdList", pstTypeCd);
		
		return "/board/boardPost";
	}
	
	/**
	 * 게시글 생성
	 */
	@RequestMapping(value="/postCreate",  method = RequestMethod.POST)
	@ResponseBody
	public String postWrite(@RequestBody PostInfoDTO dto) throws Exception {
		
		try {
			boardService.postWriteCreate(dto);
		}
		catch(Exception e) {
			logger.error("글 생성중 오류 발생 : "+e.getMessage());
			return "fail";
		}
		
		//실패하면 알 수 있게 fail 리턴
		return "success";
	}
	
	/**
	 * 게시글 수정
	 */
	
	/**
	 * 게시글 삭제
	 */

}
