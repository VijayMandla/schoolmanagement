package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Student;
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
	public Optional<Student> getById(Long id) {
		 
		return stdRepo.findById(id);
		
	}

	@Override
	public List<Student> getAll() {
		 
		return stdRepo.findAll();
	}

	@Override
	public void deleteById(Long id) {
		
	 stdRepo.deleteById(id);
		
	}

	@Override
	public Student updateByid(Long id, Student std) {
		 
		Student idCheck= stdRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Id not is not found"+ id));
		
		idCheck.setName(std.getName());
		idCheck.setDob(std.getDob());
		idCheck.setAddress(std.getAddress());
		idCheck.setGender(std.getGender());
	//	idCheck.setRollNumber(std.getRollNumber());
		idCheck.setPhone(std.getPhone());
		std.setId(id);
		return stdRepo.save(std);
		
	}

}
