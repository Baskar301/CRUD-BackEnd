package com.example.BackEnd.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "Employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name ="first_name")
	private String firstName;
	@Column(name ="last_name")
	private String lastName;
	@Column(name = "Email",nullable = false,unique = true)
	private String email;
}
