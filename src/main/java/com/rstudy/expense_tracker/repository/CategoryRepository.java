package com.rstudy.expense_tracker.repository;

import com.rstudy.expense_tracker.model.Category;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
