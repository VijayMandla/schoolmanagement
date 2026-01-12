package com.school.service;

import java.util.List;

import com.school.dto.TeacherCreateDto;
import com.school.dto.TeacherUpdateDto;
import com.school.entity.Teacher;

public interface TeacherService {

	
	public void save(TeacherCreateDto teacher);
	
	public void saveAll(List<TeacherCreateDto> teacher);
	
	public Teacher getbyId(Long id);
	
	public List<Teacher> getAll();
	
	public void deleteById(Long id);
	
	public void update(Long id, TeacherUpdateDto teacherUpdate);
	
	public List<Teacher> fingByName(String name);
	
	
}
