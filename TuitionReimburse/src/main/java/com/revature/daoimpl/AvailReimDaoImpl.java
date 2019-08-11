package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.AvailableReimbursement;
import com.revature.beans.Employee;
import com.revature.dao.AvailReimDao;
import com.revature.util.ConnFactory;

public class AvailReimDaoImpl implements AvailReimDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public AvailableReimbursement getAvailReimbursement(int availID) throws SQLException {
		AvailableReimbursement avail = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM AvailableReimbursement WHERE AvailableReimbursementID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, availID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null)) {
			System.out.println("Couldn't find AvailableReimbursement matching id " + availID);
		} else {
			while (rs.next()) {
				if (rs.getInt(1) == availID) {
					avail = new AvailableReimbursement(rs.getInt(1), rs.getDouble(2));
				}
			}
		}
		return avail;
	}

	public ArrayList<AvailableReimbursement> getAllAvailReimbursements() throws SQLException {
		AvailableReimbursement avail = null;
		ArrayList<AvailableReimbursement> list = new ArrayList<AvailableReimbursement>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM AvailableReimbursement";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			avail = new AvailableReimbursement(rs.getInt(1), rs.getDouble(2));
			list.add(avail);
		}
		return list;
	}

	public AvailableReimbursement getAvailReimbursementFromEmployee(int empID) throws SQLException {
		AvailableReimbursement avail = null;
		Connection conn = cf.getConnection();
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		Employee e = empDao.getEmployee(empID);
		String sql = "SELECT * FROM AvailableReimbursement WHERE AvailableReimbursementID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, e.getAvailReimbID());
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null)) {
			System.out.println("Couldn't find AvailableReimbursement matching id " + e.getAvailReimbID());
		} else {
			while (rs.next()) {
				if (rs.getInt(1) == e.getAvailReimbID()) {
					avail = new AvailableReimbursement(rs.getInt(1), rs.getDouble(2));
				}
			}
		}
		return avail;
	}

	public void addAvailReimbursement(double funds) throws SQLException {
		// adds a new AvailableReimbursement to the database
		Connection conn = cf.getConnection();
		String sql = "{ call insertAvailableReimbursement(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1, funds);
		call.execute();
		System.out.println("Insert sequence complete!");
	}

	public void updateAvailReimbursement(int availID, double funds) throws SQLException {
		// updates the AvailableReimbursements info in the database
		Connection conn = cf.getConnection();
		String sql = "{ call updateAvailableReimbursement(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, availID);
		call.setDouble(2, funds);
		call.execute();
		System.out.println("update sequence complete!");
	}

	public void deleteAvailReimbursement(int availID) throws SQLException {
		// deletes the AvailableReimbursement associated with appID in the database
		Connection conn = cf.getConnection();
		String sql = "{ call deleteAvailableReimbursement(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, availID);
		call.execute();
	}

	@Override
	public int getCurrentIndex() throws SQLException {
		int max = 1;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM AvailableReimbursement";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			max = rs.getInt(1);
		}
		return max;
	}
}
