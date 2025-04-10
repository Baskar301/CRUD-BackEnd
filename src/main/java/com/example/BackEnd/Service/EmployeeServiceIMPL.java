package com.example.BackEnd.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BackEnd.Exception.ResourceNotFoundException;
import com.example.BackEnd.Models.Employee;
import com.example.BackEnd.Repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService
{
	private EmployeeRepository employeeRepository;
    public EmployeeServiceIMPL(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // we need to check whether employee with given ID exists in DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee","id",id)
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public void deleteEmployee(long id) {
        // check whether an employee exist in a DB or not
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id",id));

        employeeRepository.deleteById(id);
    }
}