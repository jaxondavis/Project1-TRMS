package com.revature.beans;

public class Event {

	private int eventID;
	private String eventName;
	private String eventDate;
	private String eventTime;
	private double eventCost;
	private String eventDesc;
	private int locationID;
	private int formatID;
	private int typeID;

	public Event() {

	}

	public Event(int eventID, String eventName, String eventDate, String eventTime, double eventCost, String eventDesc, int locationID, int formatID, int typeID) 
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
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) 
	{
		this.eventTime = eventTime;
	}

	public double getEventCost() {
		return eventCost;
	}

	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public int getFormatID() {
		return formatID;
	}

	public void setFormatID(int formatID) {
		this.formatID = formatID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public String toString() {
		return "Event [eventID=" + eventID + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventTime="
				+ eventTime + ", eventCost=" + eventCost + ", eventDesc=" + eventDesc + ", locationID=" + locationID
				+ ", formatID=" + formatID + ", typeID=" + typeID + "]";
	}
}
