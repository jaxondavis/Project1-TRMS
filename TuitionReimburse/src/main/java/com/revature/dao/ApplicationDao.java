package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Application;

public interface ApplicationDao 
{
	public abstract Application getApplication(int appID) throws SQLException;
	
	public abstract ArrayList<Application> getAllApplications() throws SQLException;
	
	public abstract void addApplication(String just, int employeeID, int requestStatusID, int eventID, int gradeID, int presID) throws SQLException;
	
	public abstract void updateApplication(int appID, String just, int employeeID, int requestStatus, int eventID, int gradeID, int presID) throws SQLException;
	
	public abstract void deleteApplication(int appID) throws SQLException;
}
