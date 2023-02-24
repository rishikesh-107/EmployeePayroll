package com.example.DAO;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.entity.Payroll;

public interface PayrollDao extends MongoRepository<Payroll,String>{

	
}
