package com.example.EmployeeMgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	
}
