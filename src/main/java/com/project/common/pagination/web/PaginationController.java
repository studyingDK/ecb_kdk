package com.project.common.pagination.web;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.common.pagination.service.PaginationService;
import com.project.kdkhelloworld.login.service.LoginServiceImpl;

import lombok.extern.log4j.Log4j2;

@Controller
public class PaginationController {
	
	private static final Logger logger = LoggerFactory.getLogger(PaginationController.class);
	
	@Resource
	private PaginationService paginationService;
	
	/**
	 * 리스트 관련 ajax 받는 Controller
	 */
	@PostMapping(value = "/optimalProfitList")
	@ResponseBody
	public List<ArrayList<String>> selectPaginationList(HttpServletRequest req, Model model, 
			@RequestParam int pageItemCount,
			@RequestParam int curPage,
			@RequestParam(required = false) String searchKeyword,
			@RequestParam(required = false) String pageSortType,
			@RequestParam(required = false) String pageSortKeyword) throws Exception {	
		
		int rcurPage = Integer.parseInt(req.getParameter("curPage"));
		int rpageItemCount = Integer.parseInt(req.getParameter("pageItemCount"));
		
		int startNum = 1 + ((rcurPage-1) * rpageItemCount); //시작
		int endNum = rcurPage * rpageItemCount; //끝
		
		//검색 관련
		Map<String, Object> searchParam = new HashMap<String, Object>();
		
		searchParam.put("pageSortType", req.getParameter("pageSortType")); //오름차순, 내림차순(default)
		searchParam.put("pageSortKeyword", req.getParameter("pageSortKeyword")); //정렬기준 키워드 (default : rentNo)
		searchParam.put("startNum", startNum);
		searchParam.put("endNum", endNum);
		
		//검색키워드 있을 시 값 할당
		if (req.getParameter("searchKeyword") != null && !req.getParameter("searchKeyword").equals("none")) {
			searchParam.put("searchKeyword", req.getParameter("searchKeyword")); //검색어
		}
		
		int totalItem = paginationService.getTotalItem(searchParam); //전체 아이템 개수
		
		//DB에 있는 리스트 추가
		List<ArrayList<String>> result = paginationService.selectCurPage(paginationService.setCurPageList(searchParam));
		
		if (result.size() == 0) {
			return result;
		}
			
		//페이지네이션 요소
		ArrayList<String> pageParam = new ArrayList<>();
		
		pageParam.add(String.valueOf((int) Math.ceil((double) totalItem/rpageItemCount))); //검색한 총 페이지 개수
		pageParam.add(String.valueOf(rcurPage)); //현재 페이지
		
		//result.size() = pageItemCount + pageParam
		result.add(pageParam);
		
		return result;
	}
	
	
	
}
