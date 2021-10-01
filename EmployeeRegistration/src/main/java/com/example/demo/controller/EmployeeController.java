package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ExceptionHandler;
import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.MailServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	MailServiceImpl mailServiceImpl;

	@PostMapping(value = "/addEmployee")
	public String addEmployee(@RequestBody Employee employee) throws ExceptionHandler {
		
		if(employee.getMail().isBlank()) {
			throw new ExceptionHandler("mail is blank !");
			
		}
		else {
		employeeService.addEmployee(employee);
		mailServiceImpl.sendVerifyEmail(employee.getMail());
		return "Added successfully";
		}
	}
}
