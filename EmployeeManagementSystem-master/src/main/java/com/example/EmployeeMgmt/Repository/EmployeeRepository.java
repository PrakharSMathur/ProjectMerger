package com.example.EmployeeMgmt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	
}
