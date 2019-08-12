package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.GradingFormat;
import com.revature.dao.GradingFormatDao;
import com.revature.util.ConnFactory;

public class GradingFormatDaoImpl implements GradingFormatDao 
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public GradingFormat getGradeFormat(int formID) throws SQLException 
	{
		GradingFormat request = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM GRADINGFORMAT WHERE FORMATID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, formID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Couldn't find GradingFormat matching id "+formID);
		}
		else
		{
			while (rs.next())
			{
				if(rs.getInt(1) == formID)
				{
					request = new GradingFormat(rs.getInt(1), rs.getString(2));
				}
			}
		}
		return request;
	}
	
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
