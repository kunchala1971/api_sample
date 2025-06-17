package com.example.api_sample.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_sample.entity.Events;
import com.example.api_sample.repository.EventsRepo;

@RestController
public class EventController {
	@Autowired
	EventsRepo eventsRepo;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/api/events")
	public ResponseEntity<Events> saveEvents(@RequestBody Events events) {
		return new ResponseEntity<>(eventsRepo.save(events), HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/api/events")
	public ResponseEntity<List<Events>> getEvents() {
		return new ResponseEntity<>(eventsRepo.findAll(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/api/event/{id}")
	public ResponseEntity<Events> getStudent(@PathVariable long id) {
		Optional<Events> event = eventsRepo.findById(id);
		if (event.isPresent()) {
			return new ResponseEntity<>(event.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/api/event/{id}")
	public ResponseEntity<Events> updateStudent(@PathVariable long id, @RequestBody Events even) {
		Optional<Events> events = eventsRepo.findById(id);
		if (events.isPresent()) {
			events.get().setUserId(even.getUserId());
			events.get().setEventName(even.getEventName());
			events.get().setVenue(even.getVenue());
			events.get().setEventDate(even.getEventDate());
			events.get().setEventStatus(even.getEventStatus());
			events.get().setPrice(even.getPrice());

			return new ResponseEntity<>(eventsRepo.save(events.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/api/event/{id}")
	public ResponseEntity<Void> deleteEvents(@PathVariable long id) {
		Optional<Events> event = eventsRepo.findById(id);
		if (event.isPresent()) {
			eventsRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
