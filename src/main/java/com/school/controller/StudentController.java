package com.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Student;
import com.school.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService stdServ;
	
	@PostMapping()
	public ResponseEntity<String> save(@Valid @RequestBody Student std1){
		
		stdServ.save(std1);
		return ResponseEntity.status(HttpStatus.CREATED).body("single Student data saved successfully");
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<String> saveAll(@Valid @RequestBody List<Student> student){
		
		stdServ.saveAll(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("multiple StudentsS data saved successfully");
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getById(@Valid @PathVariable Long id) {
		
		return stdServ.getById(id);
		
	}
	
	@GetMapping()
	public List<Student> getAll() {
		
		return stdServ.getAll();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletbyId(@Valid @PathVariable Long id) {
		stdServ.deleteById(id);

		return 		ResponseEntity.status(HttpStatus.OK).body("Deleted student data based on id");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateByid(@PathVariable Long id,@RequestBody Student std){
		
		stdServ.updateByid(id, std);
		
		return ResponseEntity.status(HttpStatus.OK).body("Updated student based on id");
	}
	
	
}
