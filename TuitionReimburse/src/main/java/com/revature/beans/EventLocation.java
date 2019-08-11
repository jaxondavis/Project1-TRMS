package com.revature.beans;

public class EventLocation 
{
	private int locationID;
	private String location;
	private String city;
	private String state;
	private String zipcode;
	
	public EventLocation() 
	{
		
	}

	public EventLocation(int locationID, String location, String city, String state, String zipcode)
	{
		this.locationID = locationID;
		this.location = location;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getLocationID() 
	{
		return locationID;
	}

	public void setLocationID(int locationID) 
	{
		this.locationID = locationID;
	}

	public String getLocation() 
	{
		return location;
	}

	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getState() 
	{
		return state;
	}

	public void setState(String state) 
	{
		this.state = state;
	}

	public String getZipcode() 
	{
		return zipcode;
	}

	public void setZipcode(String zipcode) 
	{
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "EventLocation [locationID=" + locationID + ", location=" + location + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + "]";
	}
}
