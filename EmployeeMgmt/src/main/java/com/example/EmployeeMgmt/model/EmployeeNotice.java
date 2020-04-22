package com.example.EmployeeMgmt.model;

//import javax.persistence.Id;
//import javax.persistence.Transient;

import org.springframework.data.annotation.Id;

public class EmployeeNotice {

	//@Transient
    public static final String SEQUENCE_NAME = "emp_notice_sequence";

	@Override
	public String toString() {
		return "EmpNoticeTemp [id=" + id + ", from=" + from + ", to=" + to + ", message=" + message + "]";
	}
	@Id
	String id;
	String from;
	String to;
	String message;
	public EmployeeNotice(String from, String to) {
		super();
		this.from = from;
		this.to=to;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
