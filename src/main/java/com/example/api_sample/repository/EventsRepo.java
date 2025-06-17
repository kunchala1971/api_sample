package com.example.api_sample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_sample.entity.Events;
public interface EventsRepo extends JpaRepository<Events,Long> {

}