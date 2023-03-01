package com.example.DAO;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EmployeeEntity;
@Repository
public interface EmployeeDAO extends MongoRepository<EmployeeEntity,String>{
   
	Optional<EmployeeEntity> findById(String id);
}
