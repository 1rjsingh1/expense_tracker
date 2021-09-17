package com.rstudy.expense_tracker.repository;

import com.rstudy.expense_tracker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User,String> {
    @Query("{id:'?0'}")
    User findUserById(String id);
}
