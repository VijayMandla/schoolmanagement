package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

	public List<Student> findByName(String name);
	
	public List<Student> findByRollNumber(Long rollNumber);
}
