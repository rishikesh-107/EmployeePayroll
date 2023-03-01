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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.EmployeeDAO;
import com.example.entity.EmployeeEntity;
import com.example.service.Producer;

@RestController	@RequestMapping("/employees")
public class EmployeeController {
   
	@Autowired
	private EmployeeDAO employeeRepository;
	@Autowired
	private Producer employeeService;
	@Autowired
    Producer kafkaProducer;

	
	
	
	
	
	
	//@0PostMapping("/employees/{id}/cost-to-company")
    //public void updateCostToCompany(@PathVariable("id") Long id, @RequestBody EmployeeEntity costToCompanyUpdate) {
        // Update the employee's cost to company in the database
        // ...

        // Send a message to Kafka with the updated cost to company information
      //  kafkaTemplate.send("payroll-topic", costToCompanyUpdate);
    //}
	
	
	
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
	    public Optional<EmployeeEntity> getEmployeeById(@PathVariable("id") String id) {
	        
	    	return employeeRepository.findById(id);
	        
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id")String id, @RequestBody EmployeeEntity employee) {
	        employee.setId(id);
	        
	        EmployeeEntity entity= employeeRepository.save(employee);
	       
	      /// kafkaProducer.sendCTCupdate(String.valueOf(id),String.valueOf(employee.getCtc()));
	         //kafkaProducer.updateCTCMessageTopic(employee);
	        return new ResponseEntity<EmployeeEntity>(entity,HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("id")String id) {
	        employeeRepository.deleteById(id);
	        return new ResponseEntity<String>("employee deleted",HttpStatus.ACCEPTED) ;
	    }
//	    @GetMapping(value = "/producer")
//	    public String sendMessage(@RequestParam("message") String message)
//	    {
//	        kafkaProducer.sendMessageToTopic(message);
//	        return "Message sent Successfully to the your code decode topic ";
//	    }
	    
	    
	    
	    @PutMapping("/{employeeId}/ctc")
	    public ResponseEntity<String> updateEmployeeCTC(@PathVariable("employeeId") String employeeId, @RequestParam("ctc") double ctc) {
	        employeeService.updateEmployeeCTC(employeeId, ctc);
	        return ResponseEntity.ok("Employee CTC updated successfully");
	    }
	}


	   

