package com.example.EmployeeMgmt.service;

import com.example.EmployeeMgmt.model.*;
import com.example.EmployeeMgmt.repository.EmployeeLeavesRepository;
import com.example.EmployeeMgmt.repository.EmployeeNoticeRepository;
import com.example.EmployeeMgmt.repository.EmployeeRepository;
import com.example.EmployeeMgmt.repository.HRNoticeRepository;
import com.example.EmployeeMgmt.repository.HRRepository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeLeavesRepository employeeLeavesRepository;
    @Autowired
    EmployeeNoticeRepository employeeNoticeRepository;
    @Autowired
    HRRepository hrRepository;
    @Autowired
    HRNoticeRepository hrNoticeRepository;
//  @Autowired
//  HR hr;
//  private String hrId;

    public Serializable addEmployeeService(Employee employee) {
        //Adding Employee details supplied with Auto-Generated ID
        employee.setEmpId(SequenceGeneratorService.generateEmpIDSequence("employee_sequences"));
        employeeRepository.save(employee);

        //Adding default leaves
        EmployeeLeaves newEmpLeave = new EmployeeLeaves();
        newEmpLeave.setId(SequenceGeneratorService.generateEmpLeaveSequence("employee_leave_sequences"));
        newEmpLeave.setEmpid(employee.getEmpId());
        newEmpLeave.setLeaves_left(20);
        newEmpLeave.setLeaves_approved(0);
        newEmpLeave.setLeaves_applied(0);
        employeeLeavesRepository.save(newEmpLeave);

        EmployeeNotice en =new EmployeeNotice();
        en.setEmpNoticeId(SequenceGeneratorService.generateEmpNoticeSequence("employee_notice_sequences"));
        en.setFrom("Administrator");
        en.setToEmpID(employee.getEmpId());
        en.setMessage("Your account has been created! Welcome to the app.");
        employeeNoticeRepository.save(en);
        return String.format("Employee Inserted and Leave Doc set - %s", employee.getEmpId());

    }

    public String updateEmployeeService(Employee employee, String empId) {
        if (!employeeRepository.findById(empId).isPresent()) {
            return "ID does not exist";
        } else {
            Employee e = employeeRepository.findById(empId).get();
            if (employee.getDOJ() != null) {
                e.setDOJ(employee.getDOJ());
            }
            if (employee.getName() != null) {
                e.setName(employee.getName());
            }
            if (employee.getPassword() != null) {
                e.setPassword(employee.getPassword());
            }
            if (employee.getPhone() != null) {
                e.setPhone(employee.getPhone());
            }
            if (employee.getEmail() != null) {
                e.setEmail(employee.getEmail());
            }
            if (employee.getRole() != null) {
                e.setRole(employee.getRole());
            }
            if (employee.getSalary() != null) {
                e.setSalary(employee.getSalary());
            }
            if (employee.getIncrement_status() != null) {
                e.setIncrement_status(employee.getIncrement_status());
            }
            if (employee.getSecurity_clearance() != null) {
                e.setSecurity_clearance(employee.getSecurity_clearance());
                ;
            }
            if (employee.getLocation() != null) {
                e.setLocation(employee.getLocation());
            }
            employeeRepository.save(e);
            return "Updated : " + e;
        }
    }

    public List<Employee> viewAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(String empId) {
        Optional<Employee> e = employeeRepository.findById(empId);
        return e;
    }

    public String deleteEmployeeService(String empId) {
        if (employeeRepository.existsById(empId)) {
            employeeRepository.deleteById(empId);
            employeeLeavesRepository.deleteById(empId);
            //employeeNoticeRepository.deleteAllByFromempId);
            return "Employee deleted : " + empId;
        } else {
            return "Entry does not exist";
        }
    }

    public Serializable addHRService(HR hr) {
        hr.setHrId(SequenceGeneratorService.generateHrIDSequence("hr_sequences"));
        System.out.print(hr.toString());
        hrRepository.save(hr);

        HRNotice hn =new HRNotice();
        hn.setNoticeID(SequenceGeneratorService.generateHRNoticeSequence("hr_notice_sequences"));
        hn.setFrom("Administrator");
        hn.setToHrID(hr.getHrId());
        hn.setMessage("Your account has been created! Welcome to the app.");
        hrNoticeRepository.save(hn);
        return "Added HR - \n" + hr.toString();
    }

    public String deleteHRService(String hrId) {
        if (hrRepository.existsById(hrId)) {
            hrRepository.deleteById(hrId);
            return "HR deleted : " + hrId;
        } else {
            return "Entry does not exist";
        }
    }

    public List<HR> viewAllHRs() {
        return hrRepository.findAll();
    }

    public Optional<HR> getHR(String hrId) {
        Optional<HR> h = hrRepository.findById(hrId);
        return h;
    }



    public String updateHRService(HR hr, String hrId) {
        if (!hrRepository.findById(hrId).isPresent()) {
            return "ID does not exist";
        } else {
            HR h = hrRepository.findById(hrId).get();
          if (hr.getName() != null) {
            h.setName(hr.getName());
          }
          if (hr.getPassword() != null) {
            h.setPassword(hr.getPassword());
          }
          if (hr.getPhone() != null) {
            h.setPhone(hr.getPhone());
          }
          if (hr.getEmail() != null) {
            h.setEmail(hr.getEmail());
          }
          if (hr.getLocation() != null) {
            h.setLocation(hr.getLocation());
          }
          if (hr.getSecurity_clearance() != null) {
            h.setSecurity_clearance(hr.getSecurity_clearance());
          }
          hrRepository.save(h);
            return "Updated : " + h;
        }
    }

  public Optional<HR> getHRbyName(String name) {
      Optional<HR> h = hrRepository.findByName(name);
      return h;
  }

}


