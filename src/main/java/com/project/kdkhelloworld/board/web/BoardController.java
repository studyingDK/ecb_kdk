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
import com.project.kdkhelloworld.board.service.BoardService;

/**
 * 게시판 관련 Controller
 * @author kdkhelloworld
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
	//@PostMapping(value="/{pstKindCd}")
	@RequestMapping(value="/{pstKindCd}")
	public String boardCategoryMove(@PathVariable String pstKindCd, HttpServletRequest request, Model model) throws Exception {
		String boardType = pstKindCd;
		
		//게시판 코드값 세팅
		Map<String, Object> map = new HashMap<>();
		
		map.put("pstKindCd", boardType);
		map.put("searchType", "oneSearch");
		
		List<PostInfoDTO> tmp = boardService.pstBoardNm(map);
		
		//해당 게시판이 존재하지 않으면 에러 페이지로 이동
		if(!boardType.equals(tmp.get(0).getPstKindCd())) {
			return "/error";
		}
		
		String pstKindNm = tmp.get(0).getPstKindNm();
			
		
		//유저 정보 계속 받아 오는거
		//이동할 때 해당 게시판 글 목록 세팅
		
		//게시판 메인 페이지, 인기글 리스트, none
		Map<String, Object> listSet = new HashMap<>();
		listSet.put("locations", "boardMain");
		listSet.put("listType", "popular");
		listSet.put("pstType", boardType);
		listSet.put("pstCtg", "none");
		
		
		//model.addAttribute("listSet", listSet);
		model.addAttribute("listSet", listSet);
		model.addAttribute("boardType", boardType);
		model.addAttribute("pstKindNm", pstKindNm);
		
		return "/board/boardDetail";
	}
	
	/**
	 * 해당 위치에 세팅할 글 목록
	 * 
	 * @param 어디에 무슨 글 목록 세팅할 지 판별 (해당 없으면 "none")
	 * map.get("locations"); // 위치
     * map.get("pstKindCd"); // 타입
     * map.get("listType"); // 목록 타입
     * map.get("pstCtdCd"); // 카테고리
	 * @return
	 */
	@RequestMapping(value="/setPostList",  method = RequestMethod.POST)
	@ResponseBody
	public List<PostInfoDTO> setPostList(@RequestBody Map<String, Object> map) {		
		List<PostInfoDTO> popularList = new ArrayList<>();
        List<PostInfoDTO> result = new ArrayList<>(); //시간 형식 보기 좋게 변경하여 리턴
        
        PostInfoDTO timeTmp = new PostInfoDTO();
     
        //인기글
		if ("popular".equals(map.get("listType"))) {
			popularList = boardService.boardPopularList(map);
		}
		
		//등록시간, 수정시간 null 아닐 때 포메팅 값 넣어주기
		for (PostInfoDTO dto : popularList) {
			if (dto.getRegDtm() != null) {
				dto.setRegDtmToString(timeTmp.dateFormatter(dto.getRegDtm()));
			}
			if (dto.getLstUpDtm() != null) {
				dto.setLstUpDtmToString(timeTmp.dateFormatter(dto.getLstUpDtm()));
			}
			
			result.add(dto);		
		}
		return result;
	}
	
	
	/**
	 * 게시글 조회
	 */
	@PostMapping(value="/postSelect")
	@ResponseBody
	public PostInfoDTO postSelect(@RequestParam Map<String, Object> pMap) throws Exception{
		Map<String, Object> pstCd = new HashMap<>();
		pstCd.put("pstId", pMap.get("role1"));
		pstCd.put("pstKindCd", pMap.get("role2"));
		pstCd.put("pstCtgCd", pMap.get("role3"));
		
		return boardService.postRead(pstCd);
	}
	
	/**
	 * 글쓰기 페이지 이동
	 */
	@PostMapping(value="/postwrite")
	public String postWritePage(HttpServletRequest request, Model model, @RequestParam String pstKindCd) {
		String boardType = request.getParameter("pstKindCd"); //게시판 종류
		//임의로 유저 정보 세팅
		String regId = "admin";
		String nickName = "관리자";
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("pstKindCd", boardType);
		
		//카테고리 세팅
		List<PostInfoDTO> ctgCdList = boardService.pstCtgCdList(map); 
		Map<String, Object> pstCtgList = new HashMap<>();
		
		for (PostInfoDTO tmp: ctgCdList) {
			pstCtgList.put(String.valueOf(tmp.getPstCtgCd()), tmp.getPstCtgNm());
		}
		
		//말머리 세팅
		List<PostInfoDTO> prefixList = boardService.pstPrefixList(map);
		Map<String, Object> pstTitlePrefixList = new HashMap<>();
		
		for (PostInfoDTO tmp: prefixList) {
			pstTitlePrefixList.put(String.valueOf(tmp.getPstTitlePrefixCd()), tmp.getPstTitlePrefixNm());
		}
		

		model.addAttribute("boardType", pstKindCd);
		model.addAttribute("regId", regId);
		model.addAttribute("nickname", nickName);
		model.addAttribute("titlePrefixList", pstTitlePrefixList);
		model.addAttribute("ctgList", pstCtgList);
		
		return "/board/boardPost";
	}
	
	/**
	 * 게시글 생성
	 */
	@RequestMapping(value="/postCreate",  method = RequestMethod.POST)
	@ResponseBody
	public String postWrite(@RequestBody PostInfoDTO dto) throws Exception {
		
		//exception 나중에 따로 정의 필요
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
