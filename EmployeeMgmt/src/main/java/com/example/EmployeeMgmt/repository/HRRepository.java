package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.model.HR;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HRRepository extends MongoRepository<HR,String> {

    Optional<HR> findByName(String name);
}
