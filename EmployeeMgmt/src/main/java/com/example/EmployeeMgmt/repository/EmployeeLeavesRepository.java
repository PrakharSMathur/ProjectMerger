package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.model.EmployeeLeaves;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLeavesRepository extends
    MongoRepository<EmployeeLeaves,String> {

}
