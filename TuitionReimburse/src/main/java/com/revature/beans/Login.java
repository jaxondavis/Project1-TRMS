package com.revature.beans;

public class Login {
	private int loginID;
	private String email;
	private String password;
	private int employeeID;

	public Login() {

	}

	public Login(int loginID, String email, String password, int employeeID) {
		this.loginID = loginID;
		this.email = email;
		this.password = password;
		this.employeeID = employeeID;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
}
