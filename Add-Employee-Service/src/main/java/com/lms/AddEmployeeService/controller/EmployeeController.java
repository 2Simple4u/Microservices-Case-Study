package com.lms.AddEmployeeService.controller;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lms.AddEmployeeService.model.Employee;
import com.lms.AddEmployeeService.repository.EmployeeRepository;
import com.lms.AddEmployeeService.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAll(){
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{Id}")
	public ResponseEntity<String> delById(@PathVariable("Id") String eId){
		return employeeService.delete(eId);
	}
	
	@PutMapping("/emp/{Id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee , @PathVariable("Id") String eid) {
//		Employee emp = employeeRepository.findByEmpId(eid);
//		emp.setEmpDob(employee.getEmpDob());
//		emp.setEmpName(employee.getEmpName());
//		emp.setEmpDoj(employee.getEmpDoj());
//		emp.setEmpEmail(employee.getEmpEmail());
//		emp.setEmpPhone(employee.getEmpPhone());
//		emp.setEmpId(employee.getEmpId());
//		 System.out.println(emp.getEmpEmail());
//		final Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
		
		Optional<Employee> empOptional = employeeRepository.findById(eid);
		if (empOptional.isPresent()) {
			Employee empSave = empOptional.get();
			empSave.setEmpDob(employee.getEmpDob() != null ? employee.getEmpDob() : empSave.getEmpDob());
			empSave.setEmpDoj(employee.getEmpDoj() != null ? employee.getEmpDoj() : empSave.getEmpDoj());
			empSave.setEmpEmail(employee.getEmpEmail() != null ? employee.getEmpEmail() : empSave.getEmpEmail());
			empSave.setEmpId(employee.getEmpId() != null ? employee.getEmpId() : empSave.getEmpId());
			empSave.setEmpName(employee.getEmpName() != null ? employee.getEmpName() : empSave.getEmpName());
			empSave.setEmpPhone(employee.getEmpPhone() != null ? employee.getEmpPhone() : empSave.getEmpPhone());
			employeeRepository.save(empSave);
			 return ResponseEntity.ok(empSave);
			
		} else {
			return null;
		}
       
	}

}
