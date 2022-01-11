package com.lms.AddEmployeeService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.lms.AddEmployeeService.model.Employee;

@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	 public Employee findByEmpId(String empId);
	public void deleteByEmpId(String eId);
}
