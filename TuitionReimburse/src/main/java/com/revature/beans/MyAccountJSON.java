package com.revature.beans;

import java.io.Serializable;
import java.sql.Date;

public class MyAccountJSON implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstname, lastname, email, password, type, address, city, state, zipcode;
	private Date birthdate;
	private int employeeid, reportsto;
	
	
	public MyAccountJSON() 
	{
		
	}
	
	public MyAccountJSON(Employee emp, Address add, Login log, EmployeeHasType empType)
	{
		employeeid = emp.getEmployeeID();
		firstname = emp.getFirstname();
		lastname = emp.getLastname();
		birthdate = emp.getBirthdate();
		reportsto = emp.getReportsTo();
		email = log.getEmail();
		password = log.getPassword();
		address = add.getAddress();
		city = add.getCity();
		state = add.getState();
		zipcode = add.getZipcode();
		
		switch(empType.getTypeID())
		{
			case 1:
				type = "Employee";
			case 2:
				type = "Direct Supervisor";
			case 3:
				type = "Department Head";
			case 4:
				type = "Benefits Coordinator";
		}
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public int getReportsto() {
		return reportsto;
	}

	public void setReportsto(int reportsto) {
		this.reportsto = reportsto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
}
