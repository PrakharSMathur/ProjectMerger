package com.example.EmployeeMgmt.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeLeaves")
public class EmployeeLeaves {

  public static final String SEQUENCE_NAME = "employee_leaves_sequences";
  @Id
  String id;
  String empid;
  String name;
  int leaves_left;
  int leaves_applied;
  int leaves_approved;

  //Constructor
  public EmployeeLeaves(String empid,String name, int leaves_left, int leaves_applied, int leaves_approved) {
    super();
    this.empid=empid;
    this.name = name;
    this.leaves_left = leaves_left;
    this.leaves_applied = leaves_applied;
    this.leaves_approved = leaves_approved;
  }

  public EmployeeLeaves() {}

  //Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmpid() {
    return empid;
  }

  public void setEmpid(String empid) {
    this.empid = empid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLeaves_left() {
    return leaves_left;
  }

  public void setLeaves_left(int leaves_left) {
    this.leaves_left = leaves_left;
  }

  public int getLeaves_applied() {
    return leaves_applied;
  }

  public void setLeaves_applied(int leaves_applied) {
    this.leaves_applied = leaves_applied;
  }

  public int getLeaves_approved() {
    return leaves_approved;
  }

  public void setLeaves_approved(int leaves_approved) {
    this.leaves_approved = leaves_approved;
  }

  //toString
  @Override
  public String toString() {
    return "EmployeeLeaves{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", leaves_left=" + leaves_left +
        ", leaves_applied=" + leaves_applied +
        ", leaves_approved=" + leaves_approved +
        '}';
  }
}
