package com.example.EmployeeMgmt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AdminRequest")
public class AdminRequest {

  @Id
  String reqID;//(Auto-generated)
  int user_type;
  String from;
  String message;

  public AdminRequest(String reqID, int user_type, String from, String message) {
    this.reqID = reqID;
    this.user_type = user_type;
    this.from = from;
    this.message = message;
  }

  public AdminRequest() {
  }

  public String getReqID() {
    return reqID;
  }

  public void setReqID(String reqID) {
    this.reqID = reqID;
  }

  public int getUser_type() {
    return user_type;
  }

  public void setUser_type(int user_type) {
    this.user_type = user_type;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


}
