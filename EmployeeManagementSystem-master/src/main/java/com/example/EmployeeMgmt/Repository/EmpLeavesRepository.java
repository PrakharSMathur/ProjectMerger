package com.example.EmployeeMgmt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.models.EmployeeLeaves;

public interface EmpLeavesRepository extends MongoRepository<EmployeeLeaves,Integer>{

}
