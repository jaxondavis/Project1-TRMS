package com.revature.beans;

/*
 * For use with Event table in DB.
 */

public class Event {
	
	private String eventName;
    private String eventDate;
    private String eventTime;
    private Double eventCost;
    private String eventDesc;
    private int locationID;
    private int formatID;
    private int typeId;
    private int gradeID;
    private int presentationID;

	public Event()
	{
		
	}

	public Event(String eventName, String eventDate, String eventTime, Double eventCost, String eventDesc,
			int locationID, int formatID, int typeId, int gradeID, int presentationID) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventCost = eventCost;
		this.eventDesc = eventDesc;
		this.locationID = locationID;
		this.formatID = formatID;
		this.typeId = typeId;
		this.gradeID = gradeID;
		this.presentationID = presentationID;
	}

	public String getEventName() {
		return eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public Double getEventCost() {
		return eventCost;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public int getLocationID() {
		return locationID;
	}

	public int getFormatID() {
		return formatID;
	}

	public int getTypeId() {
		return typeId;
	}

	public int getGradeID() {
		return gradeID;
	}

	public int getPresentationID() {
		return presentationID;
	}
	
	
	
}
