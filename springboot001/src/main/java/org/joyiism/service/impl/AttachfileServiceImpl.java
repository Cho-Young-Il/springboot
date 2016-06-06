package org.joyiism.service.impl;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import org.joyiism.dao.AttachfileDao;
import org.joyiism.domain.Attachfile;
import org.joyiism.domain.Board;
import org.joyiism.service.AttachfileService;
import org.joyiism.util.AttachfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service @Transactional
public class AttachfileServiceImpl implements AttachfileService{
	@Autowired private AttachfileDao attachfileDao;
	private final Logger logger = LoggerFactory.getLogger(AttachfileServiceImpl.class);
	
	@Override
	public void regist(String uploadDir, Board board,
			MultipartHttpServletRequest mRequest) throws Exception {
		logger.info("execute board file regist service");
		
		Iterator<String> iterator = mRequest.getFileNames();
		while(iterator.hasNext()) {
			MultipartFile file = mRequest.getFile(iterator.next());
			
			String foriName = file.getOriginalFilename();
			Map<String, String> dirMap = 
					AttachfileUtil.uploadImageFile(
							new File(uploadDir).getAbsolutePath(), 
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
