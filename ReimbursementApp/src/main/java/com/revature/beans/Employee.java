/**
 * 
 */
package com.revature.beans;

import java.util.Date;

/**
 * @author Revature Guest
 *
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

	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the reportsTo
	 */
	public int getReportsTo() {
		return reportsTo;
	}

	/**
	 * @param reportsTo the reportsTo to set
	 */
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the emplTypeID
	 */
	public int getEmplTypeID() {
		return emplTypeID;
	}

	/**
	 * @param emplTypeID the emplTypeID to set
	 */
	public void setEmplTypeID(int emplTypeID) {
		this.emplTypeID = emplTypeID;
	}

	/**
	 * @return the addressID
	 */
	public int getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	/**
	 * @return the availReimbID
	 */
	public int getAvailReimbID() {
		return availReimbID;
	}

	/**
	 * @param availReimbID the availReimbID to set
	 */
	public void setAvailReimbID(int availReimbID) {
		this.availReimbID = availReimbID;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthdate=" + birthdate + ", reportsTo=" + reportsTo + ", email=" + email + ", username="
				+ username + ", password=" + password + ", emplTypeID=" + emplTypeID + ", addressID=" + addressID
				+ ", availReimbID=" + availReimbID + "]";
	}
	
	
	
	
}
