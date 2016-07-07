package org.joyiism.dao;

import org.joyiism.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BoardDao extends JpaRepository<Board, Integer> {
	
}
