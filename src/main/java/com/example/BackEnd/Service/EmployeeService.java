package com.example.BackEnd.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BackEnd.Models.Employee;

@Service
public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee>getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
}
