package com.transaction.management.Repository;

import com.transaction.management.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository  extends JpaRepository<LogEntity,Long> {
}
