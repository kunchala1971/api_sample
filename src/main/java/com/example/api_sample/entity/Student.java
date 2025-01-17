package com.example.api_sample.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String studentName;
private String studentEmail;
private String studentAddress;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentEmail() {
	return studentEmail;
}
public void setStudentEmail(String studentEmail) {
	this.studentEmail = studentEmail;
}
public String getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(String studentAddress) {
	this.studentAddress = studentAddress;
}
public Student(long id, String studentName, String studentEmail, String studentAddress) {
	super();
	this.id = id;
	this.studentName = studentName;
	this.studentEmail = studentEmail;
	this.studentAddress = studentAddress;
}
public Student()
{
	super();
}
@Override
public String toString() {
	return "Student [id=" + id + ", studentName=" + studentName + ", studentEmail=" + studentEmail + ", studentAddress="
			+ studentAddress + "]";
}

}
