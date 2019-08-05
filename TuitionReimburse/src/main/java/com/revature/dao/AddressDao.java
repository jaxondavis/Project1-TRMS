package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Address;

public interface AddressDao {
	
	public abstract Address getAddress(int addrID) throws SQLException;
	
	public abstract void editAddress(int addrID) throws SQLException;
	
	public abstract void removeAddress(int addrID) throws SQLException;
	
	public abstract void addAddress() throws SQLException;
	
	public abstract int confirmAddress(String addr, String city, String state, String zip) throws SQLException;

}
