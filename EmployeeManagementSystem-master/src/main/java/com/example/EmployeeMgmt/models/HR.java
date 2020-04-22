package com.example.EmployeeMgmt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "HR_list")
public class HR {

	
	@Transient
    public static final String SEQUENCE_NAME = "HR_Sequence";
	@Id
	private int id;
	private int user_type;
	private String name;
	private String password;
	private String phone;
	private String email;
	public HR()
	{
		
	}
	public HR(int i,int user_type,  String name, String password, String phone, String email, String location) {
		super();
		this.id=i;
		this.user_type = user_type;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.location = location;
	}
	private String location;
	@Override
	public String toString() {
		return "HR [id=" + id + ", user_type=" + user_type + ", name=" + name + ", password=" + password + ", phone="
				+ phone + ", email=" + email + ", location=" + location + "]";
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
	
	

	
}
