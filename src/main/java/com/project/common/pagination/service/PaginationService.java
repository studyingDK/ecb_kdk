package com.project.common.pagination.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kaoni.esdept.optimalprofit.dto.ProfitListDTO;

public interface PaginationService {
	
	/**
	 * 리스트 총 개수 받아오는 메소드
	 */
	public int getTotalItem(Map<String, Object> map) throws Exception;
	
	/**
	 * 검색 조건에 맞는 리스트 만들어주는 메소드
	 */
	//public List<ProfitListDTO> setCurPageList(Map<String, Object> map) throws Exception;
	
	/**
	 * setCurPageList 결과값 받아오는 메소드
	 */
	//public List<ArrayList<String>> selectCurPage(List<ProfitListDTO> plist) throws Exception;
}
