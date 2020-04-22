package com.example.EmployeeMgmt.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emp_leave_sequence")
public class Emp_Leave_Sequence {

	
	 @Id
	    private String id;

	    private int seq;

	    public Emp_Leave_Sequence() {}

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public int getSeq() {
	        return seq;
	    }

	    public void setSeq(int seq) {
	        this.seq = seq;
	    }
}



