package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payroll {
	@Id
	@Column(name="payRollId")
	String id;
	Integer employeeId;
	String registeredBank;
	Long bankAccountNumber;
	Double monthlysalary;
	public Payroll(String payRollId, Integer employeeId, String registeredBank, Long bankAccountNumber,
			Double monthlysalary) {
		super();
		this.id = payRollId;
		this.employeeId = employeeId;
		this.registeredBank = registeredBank;
		this.bankAccountNumber = bankAccountNumber;
		this.monthlysalary = monthlysalary;
	}
  public Payroll()
  {
	  
  }
@Override
public String toString() {
	return "Payroll [payRollId=" + id + ", employeeId=" + employeeId + ", registeredBank=" + registeredBank
			+ ", bankAccountNumber=" + bankAccountNumber + ", monthlysalary=" + monthlysalary + "]";
}
public String getPayRollId() {
	return id;
}
public void setPayRollId(String payRollId) {
	this.id = payRollId;
}
public Integer getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(Integer employeeId) {
	this.employeeId = employeeId;
}
public String getRegisteredBank() {
	return registeredBank;
}
public void setRegisteredBank(String registeredBank) {
	this.registeredBank = registeredBank;
}
public Long getBankAccountNumber() {
	return bankAccountNumber;
}
public void setBankAccountNumber(Long bankAccountNumber) {
	this.bankAccountNumber = bankAccountNumber;
}
public Double getMonthlysalary() {
	return monthlysalary;
}
public void setMonthlysalary(Double monthlysalary) {
	this.monthlysalary = monthlysalary;
}
  


}
