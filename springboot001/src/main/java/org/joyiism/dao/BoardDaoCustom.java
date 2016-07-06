package org.joyiism.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joyiism.domain.Board;
import org.joyiism.domain.PageMaker;
import org.joyiism.dto.BoardDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class BoardDaoCustom{
	@PersistenceContext
	private EntityManager em;
	
	public List<BoardDTO> boardList(int start, PageMaker pageMaker) {
		String searchKeyword = pageMaker.getSearchKeyword();
		String searchType = pageMaker.getSearchType();
		String jpql = "select b from Board b left join b.member m left join b.comments ";
		
		List<Board> boardList = new ArrayList<>();
		if(!StringUtils.isEmpty(searchKeyword)) {
			if("btitle".equals(searchType)) {
				jpql += "where b.btitle like :keyword ";
			} else if("bcontent".equals(searchType)) {
				jpql += "where b.bcontent like :keyword ";
			} else if("bwriter".equals(searchType)) {
				jpql += "where m.mname like :keyword ";
			} else {
				jpql += "where b.btitle like :keyword ";
				jpql += "   or b.bcontent like :keyword ";
				jpql += "   or m.mname like :keyword ";
			}
			jpql += "order by b.bgroup desc, b.bgroupSeq asc";
			boardList = em.createQuery(jpql, Board.class).setFirstResult(start)
						  .setParameter("keyword", "%" + searchKeyword + "%")
						  .setMaxResults(pageMaker.getSize()).getResultList();
		} else {
			jpql += "order by b.bgroup desc, b.bgroupSeq asc";
			boardList = em.createQuery(jpql, Board.class).setFirstResult(start)
						  .setMaxResults(pageMaker.getSize()).getResultList();
		}
		
		List<BoardDTO> retList = new ArrayList<>();
		for(Board board : boardList) {
			retList.add(new BoardDTO(board));
		}
		return retList;
	}
}
