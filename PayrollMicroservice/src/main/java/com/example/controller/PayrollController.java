package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.PayrollDao;
import com.example.entity.Payroll;

@RestController	@RequestMapping("/payroll")
public class PayrollController {
   
	    @Autowired
	    private PayrollDao payrollRepository;
	   

		

	    @PostMapping
	    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
	        
	    	Payroll entity=payrollRepository.save(payroll) ;
	    	
	    	return new ResponseEntity<Payroll>(entity,HttpStatus.CREATED);
	        
	    }

	    @GetMapping
	    public ResponseEntity<List<Payroll>> getAllPayrolls() {
	       List<Payroll>entity=payrollRepository.findAll();
	    	return new ResponseEntity(entity,HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public Optional<Payroll> getPayrollById(@PathVariable("id") String id) {
	        
	    	return payrollRepository.findById(id);
	        
	    }

	    @PutMapping("/{id}")
	    public Payroll updatePayroll(@PathVariable("id") String id, @RequestBody Payroll payroll) {
	        payroll.setPayRollId(id);
	        return payrollRepository.save(payroll);
	    }
	    
	    @DeleteMapping("/{id}")
	    public String deletePayroll(@PathVariable("id") String id) {
	        payrollRepository.deleteById(id);
	        return "payroll information deleted";
	    }
	   
	}
   

