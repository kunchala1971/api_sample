package com.example.api_sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String empName;
private String empDesig;
private String empDept;
private String empCity;
public Employee() {
	super();
}
public Employee(long id, String empName, String empDesig, String empDept, String empCity) {
	super();
	this.id = id;
	this.empName = empName;
	this.empDesig = empDesig;
	this.empDept = empDept;
	this.empCity = empCity;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpDesig() {
	return empDesig;
}
public void setEmpDesig(String empDesig) {
	this.empDesig = empDesig;
}
public String getEmpDept() {
	return empDept;
}
public void setEmpDept(String empDept) {
	this.empDept = empDept;
}
public String getEmpCity() {
	return empCity;
}
public void setEmpCity(String empCity) {
	this.empCity = empCity;
}

}
