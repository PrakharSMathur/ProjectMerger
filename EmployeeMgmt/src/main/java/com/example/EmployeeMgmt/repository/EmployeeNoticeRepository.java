package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.model.EmployeeNotice;
import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeNoticeRepository extends MongoRepository<EmployeeNotice,String> {

  //ArrayList<EmployeeNotice> getEmpMsgByEmpId(String empId);

  void deleteAllById(String empId);

  ArrayList<EmployeeNotice> getEmpMsgById(String empId);
}
