package com.rstudy.expense_tracker.repository;

import com.rstudy.expense_tracker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

}
