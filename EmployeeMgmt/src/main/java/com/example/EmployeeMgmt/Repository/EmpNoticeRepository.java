package com.example.EmployeeMgmt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.EmployeeMgmt.models.EmpNoticeTemp;

public interface EmpNoticeRepository extends MongoRepository<EmpNoticeTemp,String> {

}
