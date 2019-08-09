package com.revature.beans;

public class EventType 
{

	private int eventTypeID;
	private String eventTypeString;
	private double eventCoverage;
	
	public EventType() 
	{
		// TODO Auto-generated constructor stub
	}

	public EventType(int eventTypeID, String eventTypeString, double eventCoverage) {
		super();
		this.eventTypeID = eventTypeID;
		this.eventTypeString = eventTypeString;
		this.eventCoverage = eventCoverage;
	}

	public int getEventTypeID() {
		return eventTypeID;
	}

	public void setEventTypeID(int eventTypeID) {
		this.eventTypeID = eventTypeID;
	}

	public String getEventTypeString() {
		return eventTypeString;
	}

	public void setEventTypeString(String eventTypeString) {
		this.eventTypeString = eventTypeString;
	}

	public double getEventCoverage() {
		return eventCoverage;
	}

	public void setEventCoverage(double eventCoverage) {
		this.eventCoverage = eventCoverage;
	}

	@Override
	public String toString() {
		return "EventType [eventTypeID=" + eventTypeID + ", eventTypeString=" + eventTypeString + ", eventCoverage="
				+ eventCoverage + "]";
	}
}
