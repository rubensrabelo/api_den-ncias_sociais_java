package com.platform.reporting.repository;

import com.platform.reporting.domain.StatusHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusHistoryRepository extends MongoRepository<StatusHistory, String> {
}
