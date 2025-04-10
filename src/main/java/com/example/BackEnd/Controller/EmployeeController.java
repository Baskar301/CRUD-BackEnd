package com.example.BackEnd.Controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.BackEnd.Models.Employee;
import com.example.BackEnd.Service.EmployeeService;


@CrossOrigin(origins="http://localhost:5174/")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	@GetMapping
	  public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }
	 @PutMapping("/update/{id}")
	 public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,@RequestBody Employee employee) {
	    return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeId),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully!.",HttpStatus.OK);
    }
	    
}
