package com.example.EmployeeMgmt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.models.HR;

public interface HRRepository extends MongoRepository<HR,Integer>{

}
