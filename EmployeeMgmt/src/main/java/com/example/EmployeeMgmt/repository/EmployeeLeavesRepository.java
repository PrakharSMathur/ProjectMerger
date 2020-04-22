package com.example.EmployeeMgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.model.EmployeeLeaves;

public interface EmployeeLeavesRepository extends MongoRepository<EmployeeLeaves,Integer>{

}
