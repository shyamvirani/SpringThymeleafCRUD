package com.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@Controller
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/start")
	public String showSignUpForm(Employee employee) {
		return "add-employee";
	}

	@GetMapping("/list")
	public String showUpdateForm(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "index";
	}

	@PostMapping("/add")
	public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-employee";
		}
		employeeService.addEmployee(employee);
		
		return "redirect:list";
	}

	@GetMapping("/employee/{empId}")
	public String getEmployee(@PathVariable("empId") Long empId, Model model) {
		Optional<Employee> emp = employeeService.getEmployee(empId);
		Employee employee = emp.get();
		model.addAttribute("employee", employee);
		return "update-employee";

	}

	@GetMapping("delete/{empId}")
	public String removeEmployee(@PathVariable("empId") Long empId, Model model) {

		employeeService.removeEmployee(empId);

		model.addAttribute("employees", employeeService.getAllEmployee());
		return "index";
	}
	
	@PostMapping("update/{empId}")
	public String updateEmployee(@PathVariable("empId") Long empId, @Valid Employee employee,
			BindingResult bindingResult, Model model) {
		employeeService.updateEmployee(employee);
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "index";
	}

}
