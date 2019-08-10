package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class GradingDaoImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();


	public Integer getGradingID(String gradeType) throws SQLException
	{
		int gradingID = 0;
		Connection conn = cf.getConnection();
		String sql = "SELECT FORMATID FROM GRADINGFORMAT WHERE FORMATTYPE = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, gradeType);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			gradingID = rs.getInt(1);
		}
		return gradingID;
	}
	
}
