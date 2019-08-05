package com.revature.beans;

import java.sql.Date;

public class Event 
{
	
	private int eventID;
	private String eventName;
	private Date eventDate;
	private Date eventTime;
	private double eventCost;
	private String eventDesc;
	private int locationID;
	private int formatID;
	private int typeID;
	private int presID;
	
	public Event() 
	{
		
	}

	public Event(int eventID, String eventName, Date eventDate, Date eventTime, double eventCost, String eventDesc, int locationID, int formatID, int typeID, int presID) 
	{
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventCost = eventCost;
		this.eventDesc = eventDesc;
		this.locationID = locationID;
		this.formatID = formatID;
		this.typeID = typeID;
		this.presID = presID;
	}

	public int getEventID() 
	{
		return eventID;
	}

	public void setEventID(int eventID) 
	{
		this.eventID = eventID;
	}

	public String getEventName() 
	{
		return eventName;
	}

	public void setEventName(String eventName) 
	{
		this.eventName = eventName;
	}

	public Date getEventDate() 
	{
		return eventDate;
	}

	public void setEventDate(Date eventDate) 
	{
		this.eventDate = eventDate;
	}

	public Date getEventTime() 
	{
		return eventTime;
	}

	public void setEventTime(Date eventTime) 
	{
		this.eventTime = eventTime;
	}

	public double getEventCost() 
	{
		return eventCost;
	}

	public void setEventCost(double eventCost) 
	{
		this.eventCost = eventCost;
	}

	public String getEventDesc() 
	{
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) 
	{
		this.eventDesc = eventDesc;
	}

	public int getLocationID() 
	{
		return locationID;
	}

	public void setLocationID(int locationID) 
	{
		this.locationID = locationID;
	}

	public int getFormatID() 
	{
		return formatID;
	}

	public void setFormatID(int formatID) 
	{
		this.formatID = formatID;
	}

	public int getTypeID() 
	{
		return typeID;
	}

	public void setTypeID(int typeID) 
	{
		this.typeID = typeID;
	}

	public int getPresID() 
	{
		return presID;
	}

	public void setPresID(int presID) 
	{
		this.presID = presID;
	}
}
