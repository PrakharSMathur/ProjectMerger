package com.example.EmployeeMgmt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.EmployeeMgmt.Exception.EmployeeNotFoundException;
import com.example.EmployeeMgmt.Exception.RecordNotFoundException;
import com.example.EmployeeMgmt.repository.EmployeeLeaveRequestRepository;
import com.example.EmployeeMgmt.repository.EmployeeLeavesRepository;
import com.example.EmployeeMgmt.service.HRService;

@SpringBootTest
class EmployeeMgmtApplicationTests {

	@Autowired
	HRService serve;
	@Autowired
	EmployeeLeavesRepository leavesaverepo;
	@Autowired
	EmployeeLeaveRequestRepository leavereqrepo;
	@BeforeEach
	public void setup()
	{
		serve.testSaveLeaveEmp();
		serve.testSaveEmp();
		serve.testSaveEmpInfo();
	}
	@Test
	void contextLoads() throws RecordNotFoundException, EmployeeNotFoundException {
//		serve.validateLeave("10001", "1843799");
		
//		EmployeeLeaves empl=serve.viewEmployeeLeaveByid("1843799");
//		leavesaverepo.save(empl);
//		serve.deleteLeaveApplicationById("31");
//		leavereqrepo.deleteById("44");
		assertEquals(serve.validateEmail("taranrishit1234@gmail.com"),true);
		assertEquals(serve.validatePhoneNumber("9182314137"),true);
//		System.out.println(serve.validatePhoneNumber("9182314137"));
//		System.out.println(serve.validateEmail("taranrishit1234@gmail.com"));
		
	}

}
//PersistentEntity