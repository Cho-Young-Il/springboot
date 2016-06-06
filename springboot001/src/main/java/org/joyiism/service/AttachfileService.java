package org.joyiism.service;

import org.joyiism.domain.Board;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AttachfileService {
	void regist(String uploadDir, Board board, MultipartHttpServletRequest mRequest) throws Exception;
}
