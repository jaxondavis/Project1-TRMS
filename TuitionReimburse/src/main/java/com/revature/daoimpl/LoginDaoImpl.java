package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Login;
import com.revature.dao.LoginDao;
import com.revature.util.ConnFactory;

public class LoginDaoImpl implements LoginDao {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Login getLogin(int logID) throws SQLException {
		Login log = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM Login WHERE LoginID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, logID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null)) {
			System.out.println("Couldn't find Login matching Loginid " + logID);
		} else {
			while (rs.next()) {
				if (rs.getInt(1) == logID) {
					log = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				}
			}
		}
		return log;
	}

	public Login getLoginFromEmployee(int empID) throws SQLException {
		Login log = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM Login WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null)) {
			System.out.println("Couldn't find Login matching employeeid " + empID);
		} else {
			while (rs.next()) {
				if (rs.getInt(4) == empID) {
					log = new Login(rs.getInt(1), rs.getString(3), rs.getString(2), rs.getInt(4));
				}
			}
		}
		return log;
	}

	@Override
	public ArrayList<Login> getAllLogins() throws SQLException {
		Login app = null;
		ArrayList<Login> list = new ArrayList<Login>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM Login";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			app = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			list.add(app);
		}
		return list;
	}

	@Override
	public void addLogin(String email, String password, int employeeID) throws SQLException {
		// adds a new Login to the database
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO LOGIN VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setInt(3, employeeID);
		ps.execute();
		System.out.println("Insert sequence complete!");
	}

	@Override
	public void updateLogin(int logID, String email, String password, int employeeID) throws SQLException {
		// updates the Logins info in the database
		Connection conn = cf.getConnection();
		String sql = "UPDATE LOGIN SET EMAIL = ?, PASSWORD = ?, EMPLOYEEID = ? WHERE LOGINID = ?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setInt(3, employeeID);
		ps.setInt(4, logID);
		ps.execute();
		System.out.println("Update sequence complete!");
	}

	@Override
	public void deleteLogin(int logID) throws SQLException {
		// deletes the Login associated with appID in the database
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM LOGIN WHERE LOGINID = ?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setInt(1, logID);
		ps.execute();
	}
}
