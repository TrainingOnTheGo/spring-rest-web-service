package com.training.repository;

import java.util.List;

import com.traning.model.Employee;

public interface EmployeeRepository {

	List<Employee> findAll();

}