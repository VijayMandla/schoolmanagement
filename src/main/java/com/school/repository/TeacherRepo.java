package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.Teacher;

public interface TeacherRepo  extends JpaRepository<Teacher, Long>{

	public List<Teacher> findByName(String name);
	
}
