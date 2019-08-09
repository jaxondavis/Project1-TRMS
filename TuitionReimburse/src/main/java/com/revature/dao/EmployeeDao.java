package com.revature.dao;

import java.sql.SQLException;
import java.sql.Date;

import com.revature.beans.Address;
import com.revature.beans.Employee;
import com.revature.beans.EmployeeHasType;
import com.revature.beans.Login;

public interface EmployeeDao 
{

	public abstract Employee getEmployee(int userID) throws SQLException;

	//public abstract void employeeReg(String first, String last, Date dob, int sup, String addr) throws SQLException;
	
	public abstract int verifyPassword(String username, String password) throws SQLException;
	
	public abstract void updateEmployee(Employee emp, EmployeeHasType empT, Address add, Login log) throws SQLException;

	public abstract void deleteEmployee(Employee emp) throws SQLException;
}
