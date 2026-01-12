package com.school.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_of_birth")
	private LocalDate dob;

	@Column(name = "phone")

	private String phone;

	@Column(name = "roll_number", nullable = false, unique = true)
	private Long rollNumber;

	@Column(name = "gender")

	private String gender;

	@Column(name = "address")

	private String address;

}
