package com.onedata.library.repository;

import com.onedata.library.entities.MemberEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntities, Long> {
}
