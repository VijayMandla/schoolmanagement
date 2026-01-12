package com.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.TeacherCreateDto;
import com.school.dto.TeacherUpdateDto;
import com.school.entity.Teacher;
import com.school.exception.ResourceNotFounExceptionHandling;
import com.school.repository.TeacherRepo;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo;
	

	@Override
	public void save(TeacherCreateDto teacher) {
		Teacher teach= new Teacher();
		
		teach.setName(teacher.getName());
		teach.setDob(teacher.getDob());
		teach.setAddress(teacher.getAddress());
		teach.setEmail(teacher.getEmail());
		teach.setGender(teacher.getGender());
		teach.setPhone(teacher.getPhone());
		teach.setSubject(teacher.getSubject());
		
		teacherRepo.save(teach);
		
	}

	@Override
	public void saveAll(List<TeacherCreateDto> teacher) {
		 
		List<Teacher> Teacherslist= new ArrayList<>();
		
		for(TeacherCreateDto teachDto:teacher) {
			
			Teacher teac=new Teacher();
			
			teac.setName(teachDto.getName());
			teac.setDob(teachDto.getDob());
			teac.setAddress(teachDto.getAddress());
			
			teac.setEmail(teachDto.getEmail());
			teac.setGender(teachDto.getGender());
			teac.setPhone(teachDto.getPhone());
			teac.setSubject(teachDto.getSubject());
			
			Teacherslist.add(teac);
		}
		teacherRepo.saveAll(Teacherslist);
		
	}

	@Override
	public Teacher getbyId(Long id) {
		 
		return teacherRepo.findById(id)
		.orElseThrow(()-> new ResourceNotFounExceptionHandling("With this id "+id +" data not availble"));
	}

	@Override
	public List<Teacher> getAll() {
		 
		return teacherRepo.findAll();
	}

	@Override
	public void deleteById(Long id) {
		 Teacher t= teacherRepo.findById(id).
				 orElseThrow(()-> new ResourceNotFounExceptionHandling("With this id "+id +" data not availble"));
		
		 teacherRepo.delete(t);
	}

	@Override
	public void update(Long id,TeacherUpdateDto teacherUpdate) {
		 
		Teacher t= teacherRepo.findById(id).orElseThrow(()->new ResourceNotFounExceptionHandling("With this id "+id +" data not availble"));
		
       
		
		t.setName(teacherUpdate.getName());
		t.setDob(teacherUpdate.getDob());
		t.setAddress(teacherUpdate.getAddress());
		t.setEmail(teacherUpdate.getEmail());
		t.setGender(teacherUpdate.getGender());
		t.setPhone(teacherUpdate.getPhone());
		t.setSubject(teacherUpdate.getSubject());
		
	         
		teacherRepo.save(t);
	}

	@Override
	public List<Teacher> fingByName(String name) {
		
		List<Teacher> teachList= teacherRepo.findByName(name);
		
		if(teachList.isEmpty()) {
			throw new ResourceNotFounExceptionHandling("Theree no matching data/records availble with this name  "+ name);
		}
		return teachList;
		
	}

	}


