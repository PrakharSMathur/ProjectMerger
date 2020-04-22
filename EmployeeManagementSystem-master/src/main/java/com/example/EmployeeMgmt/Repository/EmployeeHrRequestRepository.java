package com.example.EmployeeMgmt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.models.EmployeeHrRequest;

public interface EmployeeHrRequestRepository extends MongoRepository<EmployeeHrRequest, String> {

}
