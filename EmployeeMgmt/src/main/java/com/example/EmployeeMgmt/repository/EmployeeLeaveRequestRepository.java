package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.model.EmployeeLeaveRequest;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeLeaveRequestRepository extends MongoRepository<EmployeeLeaveRequest,String> {

	
}
