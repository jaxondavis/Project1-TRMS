package com.revature.beans;

/*
 * For use with Address table of DB.
 */

public class Address {

	private String address;
	private String city;
	private String state;
	private String ZIP;
	
	public Address()
	{
		
	}

	public Address(String address, String city, String state, String zIP) {
		this.address = address;
		this.city = city;
		this.state = state;
		ZIP = zIP;
	}
	
	//Gets address by address ID. Should this be in DaoImpl?
	public Address getAddress(int addrID)
	{
		return null;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZIP() {
		return ZIP;
	}
	
	
}
