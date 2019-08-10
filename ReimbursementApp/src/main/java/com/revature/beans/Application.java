/**
 * 
 */
package com.revature.beans;

import java.sql.Date;

/**
 * @author Revature Guest
 *
 */
public class Application {
	
	private String justification;
	private Date submitDate;
	private Integer employeeID;
	private Integer reqID;
	private Integer eventID;
	
	public Application()
	{
		
	}

	public Application(String justification, Date submitDate, Integer employeeID, Integer reqID, Integer eventID) {
		this.justification = justification;
		this.submitDate = submitDate;
		this.employeeID = employeeID;
		this.reqID = reqID;
		this.eventID = eventID;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Integer getReqID() {
		return reqID;
	}

	public void setReqID(Integer reqID) {
		this.reqID = reqID;
	}

	public Integer getEventID() {
		return eventID;
	}

	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}

	@Override
	public String toString() {
		return "Application [justification=" + justification + ", submitDate=" + submitDate + ", employeeID="
				+ employeeID + ", reqID=" + reqID + ", eventID=" + eventID + "]";
	}
	
	

}
