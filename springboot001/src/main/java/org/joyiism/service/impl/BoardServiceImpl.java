package org.joyiism.service.impl;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.joyiism.dao.AttachfileDao;
import org.joyiism.dao.BoardDao;
import org.joyiism.dao.MemberDao;
import org.joyiism.domain.Attachfile;
import org.joyiism.domain.Board;
import org.joyiism.domain.Member;
import org.joyiism.domain.PageMaker;
import org.joyiism.service.BoardService;
import org.joyiism.util.AttachfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service @Transactional
public class BoardServiceImpl implements BoardService{
	@Autowired private BoardDao boardDao;
	@Autowired private MemberDao memberDao;
	@Autowired private AttachfileDao attachfileDao;
	private final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public Map<String, Object> list(PageMaker pageMaker) throws Exception {
		return null;
	}
	
	@Override
	public void regist(MultipartHttpServletRequest mRequest) throws Exception {
		logger.info("execute board regist service");
		/* board regist */
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
		
		
		logger.info("board file regist service");
		/* file regist */
		final String STATIC_ROOT = "src/main/resources/static";
		Iterator<String> iterator = mRequest.getFileNames();
		while(iterator.hasNext()) {
			MultipartFile file = mRequest.getFile(iterator.next());
			
			String foriName = file.getOriginalFilename();
			Map<String, String> dirMap = 
					AttachfileUtil.uploadImageFile(
							new File(STATIC_ROOT + "/attachfile").getAbsolutePath(), 
							file.getBytes(), "board", foriName
					);
			String frealName = dirMap.get("frealName");
			String fsavedDir = dirMap.get("imagePath");
			String fthumbDir = dirMap.get("thumbnailPath");
			
			attachfileDao.save(new Attachfile(
				foriName, frealName, fsavedDir, fthumbDir, board));
		}
	}
}
