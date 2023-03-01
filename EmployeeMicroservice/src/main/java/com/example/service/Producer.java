package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.DAO.EmployeeDAO;
import com.example.entity.EmployeeEntity;

@Service
public class Producer {
	@Autowired
	private KafkaTemplate<String,String>kafkaTemplate;
	
	@Autowired
	private EmployeeDAO employeeRepository;
	@Autowired
	private MongoTemplate emp;
	/*@Autowired
	private KafkaTemplate<String,EmployeeEntity>kafkaTemplate1;
	@Autowired
	private KafkaTemplate<String,Integer>kafkaTemplate2;*/
	
    /*public void updateCTCMessageTopic(EmployeeEntity entity) {
        // Update the employee's cost to company in the database
        // ...

        // Send a message to Kafka with the updated cost to company information
        kafkaTemplate.send("ctctopic",entity);
    }*/
   /* public void updateCTCEmployeeIdMessageTopic(Integer id) {
        // Update the employee's cost to company in the database
        // ...

        // Send a message to Kafka with the updated cost to company information
        kafkaTemplate2.send("idtopic", id);
    }*/

	
    
    /*public void sendMessageToTopic(String message) {
		kafkaTemplate.send("CodeDecodeTopic", message);
	}*/
	
	
	  

	  
	  public void updateEmployeeCTC(String employeeId, double ctc) {
	      // update employee CTC in the database
	      EmployeeEntity employee = emp.findById(employeeId, EmployeeEntity.class);
	      employee.setCtc(ctc);
	      employeeRepository.save(employee);

	      // publish message to Kafka queue
	      String message = employeeId + "'s CTC has been updated to " + ctc;
	      kafkaTemplate.send("employee_ctc_updates", message);
	  }
	}

	

