package com.example.api_sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_sample.entity.Users;
public interface UsersRepo extends JpaRepository<Users,Long> {
Optional<Users> findByUserEmailAndUserPassword(String userEmail, String userPassword);
 
}