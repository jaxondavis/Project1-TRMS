package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Address;

public interface EventLocationDao {
	
public abstract Address getEventLocation(int addrID) throws SQLException;
	
	public abstract void updateEventLocation(int addrID, String addr, String city, String state, String zip) throws SQLException;
	
	public abstract void removeEventLocation(int addrID) throws SQLException;
	
	public abstract void addEventLocation(String addr, String city, String state, String zip) throws SQLException;
	
	public abstract int confirmEventLocation(String addr, String city, String state, String zip) throws SQLException;

}
