package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();

	}

	public Optional<Employee> getEmployee(Long id) {
		return employeeRepository.findById(id);

	}

	public boolean removeEmployee(Long id) {
		Optional<Employee> emp=employeeRepository.findById(id);
		if(emp!=null) {
			employeeRepository.deleteById(emp.get().getempId());
			return true;
		}
		else {
			return false;
		}
	

	}
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

}
