package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traning.model.Employee;
import com.training.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/find", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Employee> find() {
		List<Employee> empList = employeeService.findAll();
		System.out.println(employeeService.findAll());
		return empList;
	}
	
	@RequestMapping(value="/records", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody List<Employee> findRecord(@RequestBody Employee employee) {
		System.out.println("Employee FirstName: " + employee.getFirstName());
		List<Employee> empList = employeeService.findAll();
		System.out.println(employeeService.findAll());
		return empList;
	}
	
	@RequestMapping(value="/findQuery", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Employee> findWithParameters(@RequestParam String firstName) {
		System.out.println(firstName + " : " + firstName);
		List<Employee> empList = employeeService.findAll();
		System.out.println(employeeService.findAll());
		return empList;
	}
	
	@RequestMapping(value="/findQuery/{userId}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Employee> findWithParameters1(@RequestParam String firstName, @PathVariable String userId) {
		System.out.println(firstName + " : " + userId);
		List<Employee> empList = employeeService.findAll();
		System.out.println(employeeService.findAll());
		return empList;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
