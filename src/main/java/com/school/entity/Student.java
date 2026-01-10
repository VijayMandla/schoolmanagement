package com.school.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name="student")
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotBlank(message="name is not null/blank")
	@Column(name="name")
	private String name;
	
	@Column(name="date_of_birth")
	private LocalDate dob;
	
	@Column(name="phone")
	@NotBlank(message="phone number must be 10 digits\"")
	@Pattern(regexp = "^[0-9]{10}$")
	private String phone;
	
	
	@NotNull(message="roll number is not null")
	@Column(name="roll_number" ,nullable =  false ,unique = true)
	private Long rollNumber;
	
	@Column(name="gender")
	@NotBlank(message="gender not blank or ull")
	private String gender;
	
	@Column(name="address")
	@NotBlank(message="address not blank or ull")
	private String address;

}
