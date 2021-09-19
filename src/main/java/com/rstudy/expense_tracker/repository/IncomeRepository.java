package com.rstudy.expense_tracker.repository;

import com.rstudy.expense_tracker.model.Income;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<Income, String> {
}
