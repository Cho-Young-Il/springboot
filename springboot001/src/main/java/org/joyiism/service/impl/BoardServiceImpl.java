package org.joyiism.service.impl;

import java.util.Date;

import org.joyiism.dao.BoardDao;
import org.joyiism.dao.MemberDao;
import org.joyiism.domain.Board;
import org.joyiism.domain.Member;
import org.joyiism.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service @Transactional
public class BoardServiceImpl implements BoardService{
	@Autowired private BoardDao boardDao;
	@Autowired private MemberDao memberDao;
	private final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public Board regist(MultipartHttpServletRequest mRequest) throws Exception {
		logger.info("execute board regist service");
		
		final int BGROUP_SEQ = 1, BDEPTH = 0;
		
		Member member = memberDao.findByMno(
				Integer.parseInt(mRequest.getParameter("mno")));
		Board board = new Board(BGROUP_SEQ, BDEPTH, mRequest.getParameter("btitle"),
				mRequest.getParameter("bcontent"), member, new Date());
		boardDao.save(board);
		
		if(!Boolean.parseBoolean(mRequest.getParameter("isReply"))) {
			board.setBgroup(board.getBno());
		} else {
			board.setBgroup(Integer.parseInt(mRequest.getParameter("bgroup")));
			board.setBgroupSeq(Integer.parseInt(mRequest.getParameter("bgroupSeq")) + 1);
			board.setBdepth(Integer.parseInt(mRequest.getParameter("bdepth")) + 1);
		}
		return board;
	}
}
