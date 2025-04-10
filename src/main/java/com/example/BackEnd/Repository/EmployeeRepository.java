package com.example.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackEnd.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
