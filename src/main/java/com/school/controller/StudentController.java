package com.school.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.StudentCreateDto;
import com.school.dto.StudentUpdateDto;
import com.school.entity.Student;
import com.school.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService stdServ;


	/*
	 * @PostMapping() public ResponseEntity<String> save(@Valid @RequestBody Student
	 * std1) {
	 * 
	 * stdServ.save(std1); return ResponseEntity.status(HttpStatus.CREATED).
	 * body("single Student data saved successfully"); }
	 */

	/*
	 * @PostMapping("/bulk") public ResponseEntity<String>
	 * saveAll(@Valid @RequestBody List<Student> student) {
	 * 
	 * stdServ.saveAll(student); return ResponseEntity.status(HttpStatus.CREATED).
	 * body("multiple StudentsS data saved successfully"); }
	 */

	@PostMapping("/bulkData")
	public ResponseEntity<String> saveAlldata(@Valid @RequestBody List<StudentCreateDto> student) {

		stdServ.SaveAlldata(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("multiple StudentsS data saved successfully");
	}

	@PostMapping()
	public ResponseEntity<String> create(@Valid @RequestBody StudentCreateDto std1) {

		stdServ.saveDto(std1);
		return ResponseEntity.status(HttpStatus.CREATED).body("single Student data saved successfully");
	}

	@GetMapping("/{id}")
	public Student getById(@PathVariable Long id) {

		return stdServ.getById(id);

	}

	@GetMapping()
	public List<Student> getAll() {

		return stdServ.getAll();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletbyId(@PathVariable Long id) {
		stdServ.deleteById(id);

		return ResponseEntity.status(HttpStatus.OK).body("Deleted student data based on id");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateByid(@PathVariable Long id, @Valid @RequestBody StudentUpdateDto std) {

		stdServ.updateByid(id, std);

		return ResponseEntity.status(HttpStatus.OK).body("Updated student based on id");
	}

	@GetMapping("/getByName")
	public List<Student> getByName(@RequestParam String name){
		
		
		
		return stdServ.findByname(name);
		
		
	}
	
	@GetMapping("/getByRollNumber")
	public List<Student> getByName(@RequestParam Long rollNumber){
		
		
		
		return stdServ.findByollNumber(rollNumber);
		
		
	}
}
