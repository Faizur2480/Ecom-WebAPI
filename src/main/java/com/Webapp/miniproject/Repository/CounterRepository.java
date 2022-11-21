package com.Webapp.miniproject.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Webapp.miniproject.Entity.Counter;

public interface CounterRepository extends MongoRepository<Counter,Long>{

}
