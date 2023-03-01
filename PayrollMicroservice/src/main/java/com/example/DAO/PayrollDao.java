package com.example.DAO;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Payroll;
@Repository
public interface PayrollDao extends MongoRepository<Payroll,String>{

	Payroll findByEmployeeId(String  employeeId);
	Optional<Payroll> findById(String  employeeId);

	
}
