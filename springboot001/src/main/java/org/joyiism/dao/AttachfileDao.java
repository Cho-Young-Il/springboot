package org.joyiism.dao;

import org.joyiism.domain.Attachfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AttachfileDao extends JpaRepository<Attachfile, Integer>{
	
}
