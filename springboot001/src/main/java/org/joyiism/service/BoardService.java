package org.joyiism.service;

import org.joyiism.domain.Board;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	Board regist(MultipartHttpServletRequest mRequest) throws Exception;
}
