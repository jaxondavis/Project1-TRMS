package com.revature.beans;

public class ApplicationJSON 
{
	private String justification, submitDate, requestStatus, requestStatusInt, 
	eventName, eventDate, eventTime, eventCost, eventDesc, location, city,
	state, zipcode, eventType, eventTypeInt, coverage, employeeID, applicationID;
	
	public ApplicationJSON() 
	{
		
	}

	public ApplicationJSON(Application app, Event eve, EventLocation eveLoc, EventType eveType) 
	
	{
		super();
		this.applicationID = ""+app.getAppID();
		this.justification = app.getJustification();
		this.submitDate = app.getSubmitDate().toString();
		this.requestStatus = ""+app.getReqID();
		switch(app.getReqID())
		{
			case 1:
				this.requestStatus = "Unsubmitted";
				break;
			case 2:
				this.requestStatus = "Pending";
				break;
			case 3:
				this.requestStatus = "Approved";
				break;
			case 4:
				this.requestStatus = "Denied";
				break;
		}
		this.eventTypeInt = ""+eveType.getEventTypeID();
		this.eventName = eve.getEventName();
		this.eventDate = eve.getEventDate().toString();
		this.eventTime = eve.getEventTime().toString();
		this.eventCost = ""+eve.getEventCost();
		this.eventDesc = eve.getEventDesc();
		this.location = eveLoc.getLocation();
		this.city = eveLoc.getLocation();
		this.state = eveLoc.getState();
		this.zipcode = eveLoc.getZipcode();
		this.eventType = eveType.getEventTypeString();
		this.coverage = ""+eveType.getEventCoverage();
		this.employeeID = ""+app.getEmployeeID();
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
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

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventCost() {
		return eventCost;
	}

	public void setEventCost(String eventCost) {
		this.eventCost = eventCost;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getRequestStatusInt() {
		return requestStatusInt;
	}

	public void setRequestStatusInt(String requestStatusInt) {
		this.requestStatusInt = requestStatusInt;
	}

	public String getEventTypeInt() {
		return eventTypeInt;
	}

	public void setEventTypeInt(String eventTypeInt) {
		this.eventTypeInt = eventTypeInt;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
}
