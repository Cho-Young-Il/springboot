package org.joyiism.dao;

import java.util.Date;

import org.joyiism.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MemberDao extends JpaRepository<Member, Integer>{
	Member findByMid(String mid);
	
	@Modifying @Query(value="update member"
		+ " set msession_key = ?1, msession_limit = ?2"
		+ " where mid = ?3", nativeQuery=true)
	void keepLogin(String msessionKey, Date next, String mid);
	
	@Query(value="select * from member where msession_key = ?1"
		+ " and msession_limit > now()", nativeQuery=true)
	Member checkMemberWithSessionKey(String value);
	
	@Modifying @Query(value="update member set mphoto = ?1"
			+ " where mno = ?2", nativeQuery=true)
	void updateImage(String savedDir, int mno);
}
