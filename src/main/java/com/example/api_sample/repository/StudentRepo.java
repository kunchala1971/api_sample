package com.example.api_sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_sample.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
