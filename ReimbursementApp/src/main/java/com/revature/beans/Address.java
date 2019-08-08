/**
 * 
 */
package com.revature.beans;

/**
 * @author Revature Guest
 *
 */
public class Address {

	private String address;
	private String city;
	private String state;
	private String ZIP;
	
	public Address()
	{
		super();
	}

	public Address(String address, String city, String state, String zIP) {
		this.address = address;
		this.city = city;
		this.state = state;
		ZIP = zIP;
	}
	
	public Address(Object[] attr) {
		this((String)attr[1], (String) attr[2], (String)attr[3], (String)attr[4]);
	}
	
	
	
	//Gets address by address ID. Should this be in DaoImpl?
	public static Address getAddress(int addrID)
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
