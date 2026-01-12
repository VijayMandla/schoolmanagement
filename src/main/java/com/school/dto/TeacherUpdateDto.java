package com.school.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TeacherUpdateDto {
	@NotBlank(message = "Name can not be blank or empty")
	private String name;

	private LocalDate dob;
	@NotBlank(message = "subject can not be blank or empty")
	private String subject;

	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be ten digits")
	private String phone;

	@Email(message = "Emial is not valid")
	@NotBlank(message = "email can not be empty or blnk")
	private String email;

	@NotBlank(message = "address can not be empty or blnk")
	private String address;

	@NotBlank(message = "gender can not be empty or blnk")
	private String gender;

}
