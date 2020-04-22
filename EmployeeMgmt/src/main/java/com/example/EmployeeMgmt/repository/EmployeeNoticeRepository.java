package com.example.EmployeeMgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.model.EmployeeNotice;

public interface EmployeeNoticeRepository extends MongoRepository<EmployeeNotice,String> {

}
