package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Application;
import com.revature.dao.ApplicationDao;
import com.revature.util.ConnFactory;

public class ApplicationDaoImpl implements ApplicationDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Application getApplication(int appID) throws SQLException {
		Application app = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM APPLICATION WHERE APPLICATIONID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, appID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null)) {
			System.out.println("Couldn't find Application matching applicationid " + appID);
		} else {
			while (rs.next()) {
				if (rs.getInt(1) == appID) {
					app = new Application(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),
							rs.getInt(6), rs.getInt(7));
				}
			}
		}
		return app;
	}

	@Override
	public ArrayList<Application> getAllApplications() throws SQLException {
		Application app = null;
		ArrayList<Application> list = new ArrayList<Application>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM APPLICATION";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			app = new Application(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),
					rs.getInt(6), rs.getInt(7));
			list.add(app);
		}
		return list;
	}

	@Override
	public ArrayList<Application> getAllApplicationsFromEmployee(int empID) throws SQLException {
		Application app = null;
		ArrayList<Application> list = new ArrayList<Application>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM APPLICATION WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			app = new Application(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),
					rs.getInt(6), rs.getInt(7));
			list.add(app);
		}
		return list;
	}

	@Override
	public void addApplication(String just, int employeeID, int requestStatusID, int eventID, int gradeID, int presID)
			throws SQLException {
		// adds a new application to the database
		Connection conn = cf.getConnection();
		String sql = "{ call insertapplication(?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, just);
		call.setInt(2, employeeID);
		call.setInt(3, requestStatusID);
		call.setInt(4, eventID);
		call.setInt(5, gradeID);
		call.setInt(6, presID);
		call.execute();
		System.out.println("Insert sequence complete!");
	}

	@Override
	public void updateApplication(int appID, String just, int employeeID, int requestStatusID, int eventID, int gradeID,
			int presID) throws SQLException {
		// updates the applications info in the database
		Connection conn = cf.getConnection();
		String sql = "{ call updateapplication(?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, just);
		call.setInt(2, employeeID);
		call.setInt(3, requestStatusID);
		call.setInt(4, eventID);
		call.setInt(5, gradeID);
		call.setInt(6, presID);
		call.execute();
		System.out.println("update sequence complete!");
	}

	@Override
	public void deleteApplication(int appID) throws SQLException {
		// deletes the application associated with appID in the database
		Connection conn = cf.getConnection();
		String sql = "{ call deleteapplication(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, appID);
		call.execute();
	}

}
