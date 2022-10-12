package com.wahyu.perwira.learnrestapiv1.repository;

import com.wahyu.perwira.learnrestapiv1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
