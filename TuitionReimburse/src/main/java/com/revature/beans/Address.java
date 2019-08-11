package com.revature.beans;

/*
 * For use with Address table of DB.
 */

public class Address {

	private int addressID;
	private String address;
	private String city;
	private String state;
	private String zipcode;

	public Address() {

	}

	public Address(int addressID, String address, String city, String state, String zipcode) {
		this.addressID = addressID;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
