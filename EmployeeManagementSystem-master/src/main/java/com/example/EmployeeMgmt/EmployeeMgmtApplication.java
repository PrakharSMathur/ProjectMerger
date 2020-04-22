package com.example.EmployeeMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication()
//@EnableReactiveMongoRepositories({"com.example.Repository"})
public class EmployeeMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtApplication.class, args);
	}

}
