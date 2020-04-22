package com.example.EmployeeMgmt.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HR")
public class HR {

  public static final String SEQUENCE_NAME = "hr_sequence";

  @Id
  String hrId;
  int user_type;
  String name;
  String password;
  String phone;
  String email;
  String location;
  String security_clearance;

  public HR(String hrId, int user_type, String name, String password, String phone,
      String email, String location, String security_clearance) {
    this.hrId = hrId;
    this.user_type = user_type;
    this.name = name;
    this.password = password;
    this.phone = phone;
    this.email = email;
    this.location = location;
    this.security_clearance = security_clearance;
  }

  @Override
  public String toString() {
    return "HR{" +
        "hrId='" + hrId + '\'' +
        ", user_type=" + user_type +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", location='" + location + '\'' +
        ", security_clearance='" + security_clearance + '\'' +
        '}';
  }

  public HR(){}

  public String getHrId() {
    return hrId;
  }

  public void setHrId(String hrId) {
    this.hrId = hrId;
  }

  public int getUser_type() {
    return user_type;
  }

  public void setUser_type(int user_type) {
    this.user_type = user_type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getSecurity_clearance() {
    return security_clearance;
  }

  public void setSecurity_clearance(String security_clearance) {
    this.security_clearance = security_clearance;
  }
}
