package com.school.service;

import java.util.List;

import com.school.dto.StudentCreateDto;
import com.school.dto.StudentUpdateDto;
import com.school.entity.Student;

public interface StudentService {

	public void save(Student std);
	
	public void saveAll(List<Student> student);
	
	public void SaveAlldata(List<StudentCreateDto> stdDto);
	public void saveDto(StudentCreateDto stdDto);
	
	public Student getById(Long id);
	
	public List<Student> getAll();
	
	public void deleteById(Long id);
	
	public Student updateByid(Long id, StudentUpdateDto std);
	
	public List<Student> findByname(String name);
	public List<Student> findByollNumber(Long rollNumber);
}
