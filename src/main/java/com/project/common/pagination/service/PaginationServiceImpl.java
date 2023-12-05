package com.project.common.pagination.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.common.pagination.dto.PaginationDTO;
import com.project.common.pagination.mapper.PaginationMapper;

@Service
public class PaginationServiceImpl implements PaginationService {
	
	private static final Logger logger = LoggerFactory.getLogger(PaginationServiceImpl.class);
	
	@Resource(name="PaginationMapper")
	private PaginationMapper mapper;
	
	/**
	 * 리스트 총 개수 받아오는 메소드
	 */
	@Override
	public int getTotalItem(Map<String, Object> map) throws Exception {
		Map<String, Object> paramInput = new HashMap<String, Object>();
		paramInput.put("pageSortType", map.get("pageSortType")); 
		paramInput.put("pageSortKeyword",map.get("pageSortKeyword"));
		
		//검색키워드 있을 시 값 할당
		if (map.get("searchKeyword") != null && !map.get("searchKeyword").equals("none")) {
			paramInput.put("searchKeyword", map.get("searchKeyword"));
		}
		
		PaginationDTO dto = mapper.getTotalItem(paramInput);
		
		return dto.getTotalItem();
	}
	
	/**
	 * 검색 조건에 맞는 리스트 만들어주는 메소드
	 */
//	@Override
//	public List<ProfitListDTO> setCurPageList(Map<String, Object> map) throws Exception {
//		Map<String, Object> paramInput = new HashMap<String, Object>();
//		paramInput.put("pageSortType", map.get("pageSortType")); 
//		paramInput.put("pageSortKeyword",map.get("pageSortKeyword"));
//		paramInput.put("startNum", map.get("startNum"));
//		paramInput.put("endNum", map.get("endNum"));
//		
//		//검색키워드 있을 시 값 할당
//		if (map.get("searchKeyword") != null && !map.get("searchKeyword").equals("none")) {
//			paramInput.put("searchKeyword", map.get("searchKeyword"));
//		}
//		
//		return mapper.selectCurPage(map);
//	}
	
	/**
	 * setCurPageList 결과값 받아오는 메소드
	 */
//	@Override
//	public List<ArrayList<String>> selectCurPage(List<ProfitListDTO> plist) throws Exception {
//		
//		//숫자 3자리마다 , 표시
//		DecimalFormat decimalFormat = new DecimalFormat("#,###");
//
//		List<ArrayList<String>> pageList = new ArrayList<ArrayList<String>>();
//		
//		if (plist.size() == 0) {
//			return pageList;
//		}
//		
//		//index 기준으로 data 뽑을 수 있게 set-up
//		for(int i=0; i<plist.size(); i++) {
//			ArrayList<String> tmp = new ArrayList<>(); 
//			int rentNo = plist.get(i).getRentNo(); // No
//			int roomCnt = plist.get(i).getRoomCnt(); // 보유한 집
//			int monthRent = plist.get(i).getMonthRent(); // 보유집 전부 임대하는 임대료
//			int unitRent = plist.get(i).getUnitRent(); // 월임대료 증가(unitRent 만큼 증가 할 때 마다 공실 하나씩 생김)
//			int maintCost = plist.get(i).getMaintCost(); // 관리비
//			int bestRent = plist.get(i).getBestRent(); //최대이익 일 때 임대료
//			int rentRoomCnt = plist.get(i).getRentRoomCnt(); //최대이익 일 때 임대 원룸 수
//			int maxProfit = plist.get(i).getMaxProfit(); // 최대이익
//			String regUser = plist.get(i).getRegUser();
//			String ipAddr = plist.get(i).getIpAddr();		
//			Date regDate = plist.get(i).getRegDate();
//			
//			tmp.add(0, decimalFormat.format(rentNo));
//			tmp.add(1, decimalFormat.format(roomCnt));
//			tmp.add(2, decimalFormat.format(monthRent));
//			tmp.add(3, decimalFormat.format(unitRent));
//			tmp.add(4, decimalFormat.format(maintCost));
//			tmp.add(5, decimalFormat.format(bestRent));
//			tmp.add(6, decimalFormat.format(rentRoomCnt));
//			tmp.add(7, decimalFormat.format(maxProfit));
//			tmp.add(8, decimalFormat.format(maxProfit));
//			tmp.add(9, regUser);
//			tmp.add(10, ipAddr);
//			tmp.add(11, String.valueOf(regDate));
//			pageList.add(tmp);
//		}
//
//		return pageList;
//	}


	
	

}
