package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.Presentation;
import com.revature.dao.PresentationDao;
import com.revature.util.ConnFactory;

public class PresentationDaoImpl implements PresentationDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void addPresentation(String path) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call insertpresentations(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, path);
	}

	@Override
	public void editPresentation(int presID, String newPath) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call updatePresentations(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, presID);
		call.setString(2, newPath);
		
	}

	@Override
	public void removePresentation(int presID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call deletePresentations(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, presID);
	}

	@Override
	public Presentation getPresentation(int presID) throws SQLException {
		Connection conn = cf.getConnection();
		Presentation pres = null;
		String sql = "SELECT * FROM PRESENTATIONS WHERE PRESID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, presID);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			pres = new Presentation(rs.getInt(1), rs.getString(2));
		}
		return pres;
	}
	
	

}
