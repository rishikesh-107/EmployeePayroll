package com.example.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeEntity {

	@Id
	String id;
	String firstName;
	String lastName;
	Integer age;
	Double ctc;
	String organisation;
	public EmployeeEntity(String id, String firstName, String lastName, Integer age, Double ctc, String organisation) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ctc = ctc;
		this.organisation = organisation;
	}
	public EmployeeEntity()
	{
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getCtc() {
		return ctc;
	}
	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", ctc=" + ctc + ", organisation=" + organisation + "]";
	}


}
