package org.joyiism.service;

import java.util.Map;

import org.joyiism.domain.PageMaker;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	Map<String, Object> list(PageMaker pageMaker) throws Exception;
	void regist(MultipartHttpServletRequest mRequest) throws Exception;
	Map<String, Object> detail(int bno) throws Exception;
}
