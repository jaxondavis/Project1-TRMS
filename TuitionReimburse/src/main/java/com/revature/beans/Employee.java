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
	private int addressID;
	private int availReimbID;
	
	public Employee()
	{
		
	}

	public Employee(int employeeID, String firstname, String lastname, Date birthdate, int reportsTo, int addressID, int availReimbID) 
	{
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.reportsTo = reportsTo;
		this.addressID = addressID;
		this.availReimbID = availReimbID;
	}

	public int getEmployeeID() 
	{
		return employeeID;
	}

	public void setEmployeeID(int employeeID) 
	{
		this.employeeID = employeeID;
	}

	public String getFirstname() 
	{
		return firstname;
	}

	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}

	public String getLastname() 
	{
		return lastname;
	}

	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}

	public Date getBirthdate() 
	{
		return birthdate;
	}

	public void setBirthdate(Date birthdate) 
	{
		this.birthdate = birthdate;
	}

	public int getReportsTo() 
	{
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) 
	{
		this.reportsTo = reportsTo;
	}

	public int getAddressID() 
	{
		return addressID;
	}

	public void setAddressID(int addressID) 
	{
		this.addressID = addressID;
	}

	public int getAvailReimbID() 
	{
		return availReimbID;
	}

	public void setAvailReimbID(int availReimbID) 
	{
		this.availReimbID = availReimbID;
	}
}
