package com.project.common.pagination.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.project.common.pagination.dto.PaginationDTO;



@Repository("PaginationMapper")
public interface PaginationMapper {
	
	public PaginationDTO getTotalItem(Map<String, Object> map) throws Exception;
	
	//public List<ProfitListDTO> selectCurPage (Map<String, Object> map) throws Exception;
}
