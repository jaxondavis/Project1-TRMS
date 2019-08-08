/**
 * 
 */
package com.revature.beans;

/**
 * @author Revature Guest
 *
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
    
    public Event()
	{
		super();
	}

	public Event(String eventName, String eventDate, String eventTime, Double eventCost, String eventDesc,
			int locationID, int formatID, int typeId) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventCost = eventCost;
		this.eventDesc = eventDesc;
		this.locationID = locationID;
		this.formatID = formatID;
		this.typeId = typeId;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the eventTime
	 */
	public String getEventTime() {
		return eventTime;
	}

	/**
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	/**
	 * @return the eventCost
	 */
	public Double getEventCost() {
		return eventCost;
	}

	/**
	 * @param eventCost the eventCost to set
	 */
	public void setEventCost(Double eventCost) {
		this.eventCost = eventCost;
	}

	/**
	 * @return the eventDesc
	 */
	public String getEventDesc() {
		return eventDesc;
	}

	/**
	 * @param eventDesc the eventDesc to set
	 */
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	/**
	 * @return the locationID
	 */
	public int getLocationID() {
		return locationID;
	}

	/**
	 * @param locationID the locationID to set
	 */
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	/**
	 * @return the formatID
	 */
	public int getFormatID() {
		return formatID;
	}

	/**
	 * @param formatID the formatID to set
	 */
	public void setFormatID(int formatID) {
		this.formatID = formatID;
	}

	/**
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
