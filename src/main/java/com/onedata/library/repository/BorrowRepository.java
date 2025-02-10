package com.onedata.library.repository;

import com.onedata.library.entities.BorrowEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntities, Long> {
}
