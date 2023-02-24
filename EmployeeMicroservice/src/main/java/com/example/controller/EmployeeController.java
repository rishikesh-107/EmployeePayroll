package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.EmployeeDAO;
import com.example.entity.EmployeeEntity;

@RestController	@RequestMapping("/employees")
public class EmployeeController {
   
	@Autowired
	private EmployeeDAO employeeRepository;
	
	
	 @PostMapping
	    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity
	employee) {
		 EmployeeEntity entity= employeeRepository.save(employee);
	        return new  ResponseEntity<EmployeeEntity>(entity,HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity <List<EmployeeEntity>> getAllEmployees() {
	        List<EmployeeEntity> entity=employeeRepository.findAll();
	    	return new ResponseEntity<List<EmployeeEntity>>(entity,HttpStatus.OK);
	        
	    }

	    @GetMapping("/{id}")
	    public Optional<EmployeeEntity> getEmployeeById(@PathVariable("id") Integer id) {
	        
	    	return employeeRepository.findById(id);
	        
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id")Integer id, @RequestBody EmployeeEntity employee) {
	        employee.setId(id);
	        EmployeeEntity entity= employeeRepository.save(employee);
	        return new ResponseEntity<EmployeeEntity>(entity,HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Integer id) {
	        employeeRepository.deleteById(id);
	        return new ResponseEntity<String>("employee deleted",HttpStatus.ACCEPTED) ;
	    }
	}


	   

