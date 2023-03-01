package com.example.service;



import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.DAO.PayrollDao;
import com.example.entity.EmployeeEntity;
import com.example.entity.Payroll;
@Service
public class Consumer {
	
	@Autowired
	PayrollDao payrollRepository;
	
	/*@KafkaListener(topics = "CodeDecodeTopic", groupId = "codedecode-group")
	public void listenToCodeDecodeKafkaTopic(String messageReceived) {
		System.out.println("Message received is " + messageReceived);
	}
	@KafkaListener(topics = "ctcupdate", groupId = "ctc-group")
	public void listenToctcupdateKafkaTopic(String id,String ctc) {
		//System.out.println("Message received is " + messageReceived);
	     Payroll payroll= payrollRepository.findByEmployeeId(Integer.valueOf(id));
	     payroll.setMonthlysalary((Double.valueOf(ctc))/12);
	     payrollRepository.save(payroll);
	}*/
	
	/*@KafkaListener(topics = "idtopic", groupId = "ctc-group1")
	public void listenToIdKafkaTopic(Integer id) {
		this.empId=id;
		
	}*/
	
	/*@KafkaListener(topics = "ctctopic", groupId = "ctc-group2")
	public void listenToctcKafkaTopic(EmployeeEntity entity) {
		Payroll payroll=new Payroll();
		payroll =payrollRepository.findById(entity.getId());
		payroll.setEmployeeId(entity.getId());
		payroll.setMonthlysalary(entity.getCtc()/12);
	    payrollRepository.save(payroll);
	    
	    System.out.println("Payroll monthly salary updated with employee ctc and id");
	}*/
	
	 @KafkaListener(topics = "employee_ctc_updates", groupId = "payroll_service")
	  public void processEmployeeCTCUpdate(String message) {
	      // extract employee ID and updated CTC from the message
	      String[] parts = message.split("'s CTC has been updated to ");
	      String employeeId = parts[0];
	      double updatedCtc = Double.parseDouble(parts[1]);

	      // update payroll service in the database
	      Payroll payroll = payrollRepository.findByEmployeeId(employeeId);
	      payroll.setMonthlysalary(updatedCtc / 12.0);
	      payrollRepository.save(payroll);
	  }
}
