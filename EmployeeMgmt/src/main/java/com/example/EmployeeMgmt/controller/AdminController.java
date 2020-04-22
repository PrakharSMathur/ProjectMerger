package com.example.EmployeeMgmt.controller;

import com.example.EmployeeMgmt.model.Employee;
import com.example.EmployeeMgmt.model.HR;
import com.example.EmployeeMgmt.service.AdminService;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminController {
@Autowired
  AdminService admin;

  @GetMapping("/GetAllEmployees")
  public List<Employee> viewAllEmployees()
  {
    return admin.viewAllEmployees();
  }

  @GetMapping("/GetEmployee/{empId}")
  public Optional<Employee> getEmployee(@PathVariable String empId){ return admin.getEmployee(empId);  }

  @PostMapping("/AddEmployee")
  public Serializable addStudentService(@RequestBody Employee employee) {
    return admin.addEmployeeService(employee);
  }

  @PutMapping("/UpdateEmployee/{empId}")
  public String updateEmployee(@RequestBody Employee employee,@PathVariable String empId){
    return admin.updateEmployeeService(employee,empId);
  }

  @DeleteMapping("/DeleteEmployee/{empId}")
  public String deleteEmployee(@PathVariable String empId) {
    return admin.deleteEmployeeService(empId);
  }

  @GetMapping("/GetAllHRs")
  public List<HR> viewAllHRs()
  {
    return admin.viewAllHRs();
  }

  @GetMapping("/GetHR/{hrId}")
  public Optional<HR> getHR(@PathVariable String hrId){
    return admin.getHR(hrId);
  }

  @GetMapping("/GetHRbyName/{name}")
  public Optional<HR> getHRbyName(@PathVariable String name) { return admin.getHRbyName(name);}

  @PostMapping("/AddHR")
  public Serializable addHRService(@RequestBody HR hr) {
    return admin.addHRService(hr);
  }

  @DeleteMapping("/DeleteHR/{hrId}")
  public String deleteHR(@PathVariable String hrId) {
    return admin.deleteHRService(hrId);
  }

  @PutMapping("/UpdateHR/{hrId}")
  public String updateHR(@RequestBody HR hr,@PathVariable String hrId){
    return admin.updateHRService(hr,hrId);
  }





}
