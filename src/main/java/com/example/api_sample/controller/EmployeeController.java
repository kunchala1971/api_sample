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

import com.example.api_sample.entity.Employee;
import com.example.api_sample.repository.EmployeeRepo;

@RestController
public class EmployeeController {
	@Autowired
EmployeeRepo employeeRepo;
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/api/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/api/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/api/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee emp) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isPresent()) {
			employee.get().setEmpName(emp.getEmpName());
			employee.get().setEmpDesig(emp.getEmpDesig());
			employee.get().setEmpDept(emp.getEmpDept());
			employee.get().setEmpCity(emp.getEmpCity());
			return new ResponseEntity<>(employeeRepo.save(employee.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/api/employee/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
		Optional<Employee> empployee = employeeRepo.findById(id);
		if (empployee.isPresent()) {
			employeeRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
