package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DAO.EmployeeDAO;
import com.example.controller.EmployeeController;
import com.example.entity.EmployeeEntity;

@SpringBootTest
class EmployeeMicroserviceApplicationTests {

	@Autowired
	EmployeeDAO repo;
	@Test
	public void testGetAll() {
		EmployeeController emp=new EmployeeController();
		List<EmployeeEntity> entity=(List<EmployeeEntity>) emp.getAllEmployees();
		assertThat(entity).size().isGreaterThan(0);
		
	}
	
/*	@Test
	public void testCreateEmployee()
	{
		
		EmployeeEntity entity=new EmployeeEntity();
		entity.setId(105);
		entity.setFirstName("MS");
		entity.setLastName("Dhoni");
		entity.setAge(10);
		entity.setCtc(99.00);
		
		entity.setOrganisation("ICT");
		
	    repo.save(entity);
		assertNotNull(repo.findById(106).get());
		
	}*/
}
