package com.example.EmployeeMgmt.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity
public class EmpLeaveReqTemp {
//
	@Transient
    public static final String SEQUENCE_NAME = "emp_leave_req_sequence";
	
	@Id
	public String id;
	
	public String fromEmpID;
	public String toHRID;
	int leave_req_days;
	public String getLeaveID() {
		return id;
	}
	public void setLeaveID(String leaveID) {
		this.id = leaveID;
	}
	Date leave_start;
	Date leave_end;
	public EmpLeaveReqTemp(){}
	@Override
	public String toString() {
		return "EmpLeaveTemp [leaveID=" + id + ", fromEmpID=" + fromEmpID + ", toHRID=" + toHRID
				+ ", leave_req_days=" + leave_req_days + ", leave_start=" + leave_start + ", leave_end=" + leave_end
				+ "]";
	}
	public String getFromEmpID() {
		return fromEmpID;
	}
	public void setFromEmpID(String fromEmpID) {
		this.fromEmpID = fromEmpID;
	}
	public String getToHRID() {
		return toHRID;
	}
	public void setToHRID(String toHRID) {
		this.toHRID = toHRID;
	}
	public int getLeave_req_days() {
		return leave_req_days;
	}
	public void setLeave_req_days(int leave_req_days) {
		this.leave_req_days = leave_req_days;
	}
	public EmpLeaveReqTemp(String fromEmpID, String toHRID, int leave_req_days, Date leave_start, Date leave_end) {
		super();
		this.fromEmpID = fromEmpID;
		this.toHRID = toHRID;
		this.leave_req_days = leave_req_days;
		this.leave_start = leave_start;
		this.leave_end = leave_end;
	}
	public Date getLeave_start() {
		return leave_start;
	}
	public void setLeave_start(Date leave_start) {
		this.leave_start = leave_start;
	}
	public Date getLeave_end() {
		return leave_end;
	}
	public void setLeave_end(Date leave_end) {
		this.leave_end = leave_end;
	}
	
}
