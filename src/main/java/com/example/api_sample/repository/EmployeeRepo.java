package com.example.api_sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_sample.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
