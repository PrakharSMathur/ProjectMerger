package com.example.EmployeeMgmt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeMgmt.models.EmpLeaveReqTemp;


public interface EmpLeaveReqRepository extends MongoRepository<EmpLeaveReqTemp,String> {

	
}
