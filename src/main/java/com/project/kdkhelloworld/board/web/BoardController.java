package com.project.kdkhelloworld.board.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@PostMapping(value="/main")
	public String boardMainPage(HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		logger.info(req.getParameter("userid"));
		
		return "/board/boardMain";
	}

}
