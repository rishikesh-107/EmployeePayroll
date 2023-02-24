package com.example.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.EmployeeEntity;

public interface EmployeeDAO extends MongoRepository<EmployeeEntity,Integer>{

}
