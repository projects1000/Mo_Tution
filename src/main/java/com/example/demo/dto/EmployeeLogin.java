package com.example.demo.dto;

public class EmployeeLogin {
	
	private String email;
	private String passsword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	
	public EmployeeLogin(String email, String passsword) {
		super();
		this.email = email;
		this.passsword = passsword;
	}
	
	public EmployeeLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeLogin [email=" + email + ", passsword=" + passsword + "]";
	}
	
	
	
	
}
