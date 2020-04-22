package com.example.EmployeeMgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.model.HR;

public interface HRRepository extends MongoRepository<HR,Integer>{

}
