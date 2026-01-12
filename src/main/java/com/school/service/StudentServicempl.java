package com.school.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.StudentCreateDto;
import com.school.dto.StudentUpdateDto;
import com.school.entity.Student;
import com.school.exception.ResourceNotFounExceptionHandling;
import com.school.repository.StudentRepo;

@Service
public class StudentServicempl implements StudentService {

	@Autowired
	private StudentRepo stdRepo;

	@Override
	public void save(Student std1) {
		stdRepo.save(std1);

	}

	@Override
	public void saveAll(List<Student> student) {

		stdRepo.saveAll(student);
	}

	@Override
	public Student getById(Long id) {

		return stdRepo.findById(id).orElseThrow(() -> new ResourceNotFounExceptionHandling("Id not is not found " + id));

	}

	@Override
	public List<Student> getAll() {

		return stdRepo.findAll();
	}

	@Override
	public void deleteById(Long id) {

		Student idcheck = stdRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFounExceptionHandling("Student not found with this id " + id));

		stdRepo.delete(idcheck);

	}

	@Override
	public Student updateByid(Long id, StudentUpdateDto std) {

		Student idCheck = stdRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFounExceptionHandling("Id not is not found " + id));

		idCheck.setName(std.getName());
		idCheck.setDob(std.getDob());
		idCheck.setAddress(std.getAddress());
		idCheck.setGender(std.getGender());
		idCheck.setPhone(std.getPhone());

		return stdRepo.save(idCheck);

	}

	@Override
	public void SaveAlldata(List<StudentCreateDto> stdDto) {
		
		List<Student> list= new ArrayList<>();
				for(StudentCreateDto std: stdDto) {
					
					Student std1=new Student();
					std1.setName(std.getName());
					std1.setPhone(std.getPhone());
					std1.setAddress(std.getAddress());
					std1.setDob(std.getDob());
					std1.setGender(std.getGender());
					std1.setRollNumber(std.getRollNumber());
					list.add(std1);
				}
				stdRepo.saveAll(list);
	}

	//Student data saving by using DTO class
	@Override
	public void saveDto(StudentCreateDto stdDto) {
		
		Student std= new Student();
		
		std.setName(stdDto.getName());
		std.setPhone(stdDto.getPhone());
		std.setAddress(stdDto.getAddress());
		std.setDob(stdDto.getDob());
		std.setGender(stdDto.getGender());
		std.setRollNumber(stdDto.getRollNumber());
		
		stdRepo.save(std);
		
		
	}
	

}
