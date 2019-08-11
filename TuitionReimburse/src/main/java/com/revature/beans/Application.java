package com.revature.beans;

import java.sql.Date;

/*
 * Object class for handling employee applications. Should pull from DB table.
 */

public class Application 
{
	private int appID;
	private String justification;
	private Date submitDate;
	private int employeeID;
	private int reqID;
	private int eventID;
	private int gradeID;
	
	public Application() 
	{
		
	}

	public Application(int appID, String justification, Date submitDate, int employeeID, int reqID, int eventID, int gradeID) 
	{
		this.appID = appID;
		this.justification = justification;
		this.submitDate = submitDate;
		this.employeeID = employeeID;
		this.reqID = reqID;
		this.eventID = eventID;
		this.gradeID = gradeID;
	}

	public int getAppID() 
	{
		return appID;
	}

	public void setAppID(int appID) 
	{
		this.appID = appID;
	}

	public String getJustification() 
	{
		return justification;
	}

	public void setJustification(String justification) 
	{
		this.justification = justification;
	}

	public Date getSubmitDate() 
	{
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) 
	{
		this.submitDate = submitDate;
	}

	public int getEmployeeID() 
	{
		return employeeID;
	}

	public void setEmployeeID(int employeeID) 
	{
		this.employeeID = employeeID;
	}

	public int getReqID() 
	{
		return reqID;
	}

	public void setReqID(int reqID) 
	{
		this.reqID = reqID;
	}

	public int getEventID() 
	{
		return eventID;
	}

	public void setEventID(int eventID) 
	{
		this.eventID = eventID;
	}

	public int getGradeID() 
	{
		return gradeID;
	}

	public void setGradeID(int gradeID) 
	{
		this.gradeID = gradeID;
	}

	@Override
	public String toString() {
		return "Application [appID=" + appID + ", justification=" + justification + ", submitDate=" + submitDate
				+ ", employeeID=" + employeeID + ", reqID=" + reqID + ", eventID=" + eventID + ", gradeID=" + gradeID
				+ "]";
	}
}
