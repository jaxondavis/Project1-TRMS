package com.revature.dao;

import java.sql.SQLException;
import java.sql.Date;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public abstract Employee getEmployee(int userID) throws SQLException;
	
	//public abstract void employeeReg(String first, String last, Date dob, int sup, String addr) throws SQLException;
	
	public abstract int verifyPassword(String username, String password) throws SQLException;
	
	public abstract void updateEmployee(String username, String password, String first, String last, Date dob, int sup, int addID, int avail) throws SQLException;
}
