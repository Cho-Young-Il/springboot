package org.joyiism.dao;

import org.joyiism.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Integer>{}
