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
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.TeacherCreateDto;
import com.school.dto.TeacherUpdateDto;
import com.school.entity.Teacher;
import com.school.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teachserv;
    @PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody TeacherCreateDto teacherDto) {

		teachserv.save(teacherDto);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Single Teacher data is created/saved successfully");
	}

	@PostMapping("/bulk")
	public ResponseEntity<String> saveAll(@Valid @RequestBody List<TeacherCreateDto> teacherDto) {

		teachserv.saveAll(teacherDto);

		return ResponseEntity
				.status(HttpStatus.CREATED).body("Teacher data is created/saved successfully");
	}
	
	@GetMapping("/{id}")
	public Teacher getById(@PathVariable Long id) {
		
		return teachserv.getbyId(id);
	}
	@GetMapping()
	public List<Teacher> getAll() {
		
		return teachserv.getAll();
	}
	
	@PutMapping("/{id}")
	public void updateById(@PathVariable Long id, @Valid @RequestBody TeacherUpdateDto teachUpdate) {
		teachserv.update(id, teachUpdate);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		 teachserv.deleteById(id);
		
	}
}
