package com.example.EmployeeMgmt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HRNotice")
public class HRNotice {
  public static final String SEQUENCE_NAME = "hr_notice_sequences";
  @Id
  String id; //(Auto-generated)
  String from;
  String toHrID;
  String message;

  public HRNotice(String noticeID, String from,String toHrID, String message) {
    this.id = noticeID;
    this.from = from;
    this.message = message;
    this.toHrID=toHrID;
  }

  public HRNotice() {

  }

  public String getToHrID() {
    return toHrID;
  }

  public void setToHrID(String toHrID) {
    this.toHrID = toHrID;
  }

  public String getNoticeID() {
    return id;
  }

  public void setNoticeID(String noticeID) {
    this.id = noticeID;
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
