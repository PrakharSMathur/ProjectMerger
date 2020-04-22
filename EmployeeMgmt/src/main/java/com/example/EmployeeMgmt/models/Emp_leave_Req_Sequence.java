package com.example.EmployeeMgmt.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emp_leave_req_sequence")
public class Emp_leave_Req_Sequence {

	
	 @Id
	    private String id;

	    private String seq;

	    public Emp_leave_Req_Sequence() {}

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getSeq() {
	        return seq;
	    }

	    public void setSeq(String seq) {
	        this.seq = seq;
	    }
}



