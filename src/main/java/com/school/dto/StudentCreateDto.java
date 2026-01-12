package com.school.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class StudentCreateDto {
@NotBlank(message="name is not null/blank")
	
	private String name;
	

	private LocalDate dob;

	@NotBlank(message="phone number must be 10 digits\"")
	@Pattern(regexp = "^[0-9]{10}$")
	private String phone;
	

	@NotBlank(message="gender not blank or ull")
	private String gender;
	
	@NotNull(message = "roll number is not null")
	
	private Long rollNumber;

	@NotBlank(message="address not blank or ull")
	private String address;
}
