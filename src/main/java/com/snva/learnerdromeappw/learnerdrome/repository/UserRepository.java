package com.snva.learnerdromeappw.learnerdrome.repository;

import com.snva.learnerdromeappw.learnerdrome.model.dbmodel.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByFirstName(String firstName);
    User findByEmail(String email);
}
