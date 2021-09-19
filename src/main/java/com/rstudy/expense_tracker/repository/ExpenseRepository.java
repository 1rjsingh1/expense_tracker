package com.rstudy.expense_tracker.repository;

import com.rstudy.expense_tracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense,String> {
}
