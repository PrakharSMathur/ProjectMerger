package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.model.EmployeeHrRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.model.EmployeeHrRequest;

public interface EmployeeHrRequestRepository extends MongoRepository<EmployeeHrRequest, String> {

}
