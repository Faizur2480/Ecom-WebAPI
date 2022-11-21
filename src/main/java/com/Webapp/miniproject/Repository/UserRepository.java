package com.Webapp.miniproject.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Webapp.miniproject.Entity.User;

public interface UserRepository extends MongoRepository<User,String> {

	User findById(Long id);

	User findByEmail(String email);

}
