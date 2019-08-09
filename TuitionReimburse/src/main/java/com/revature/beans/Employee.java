package com.revature.beans;

import java.sql.Date;

/*
 * Object class for Employee from the Tuition Reimbursement program. For use w/Data in SQL
 */

public class Employee {
	
	private int employeeID;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private int reportsTo;
	private String email;
	private String username;
	private String password;
	private int emplTypeID;
	private int addressID;
	private int availReimbID;
	
	public Employee()
	{
		
	}

	public Employee(int employeeID, String firstname, String lastname, Date birthdate, int reportsTo, String email,
			String username, String password, int emplTypeID, int addressID, int availReimbID) {
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.reportsTo = reportsTo;
		this.email = email;
		this.username = username;
		this.password = password;
		this.emplTypeID = emplTypeID;
		this.addressID = addressID;
		this.availReimbID = availReimbID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getEmplTypeID() {
		return emplTypeID;
	}

	public int getAddressID() {
		return addressID;
	}

	public int getAvailReimbID() {
		return availReimbID;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthdate=" + birthdate + ", reportsTo=" + reportsTo + ", email=" + email + ", username="
				+ username + ", password=" + password + ", emplTypeID=" + emplTypeID + ", addressID=" + addressID
				+ ", availReimbID=" + availReimbID + "]";
	}
	
	
}
