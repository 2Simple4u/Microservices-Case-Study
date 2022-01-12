package com.lms.AddEmployeeService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.AddEmployeeService.model.Employee;
import com.lms.AddEmployeeService.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach(list::add);
		return list;
	}
	
	public Employee getEmployee(String eid) {
		return employeeRepository.findByEmpId(eid);
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	public ResponseEntity<String> delete(String eid){
		employeeRepository.deleteById(eid);
		return ResponseEntity.ok("Succesfully Deleted");
	}

}
