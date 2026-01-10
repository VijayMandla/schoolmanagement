package com.school.service;

import java.util.List;
import java.util.Optional;

import com.school.entity.Student;

public interface StudentService {

	public void save(Student std);
	
	public void saveAll(List<Student> student);
	
	public Optional<Student> getById(Long id);
	
	public List<Student> getAll();
	
	public void deleteById(Long id);
	
	public void updateByid(Long id, Student std);
}
