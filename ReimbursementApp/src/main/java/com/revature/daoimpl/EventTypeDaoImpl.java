package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class EventTypeDaoImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();


	public Integer getTypeID(String eventType) throws SQLException
	{
		int typeID = 0;
		Connection conn = cf.getConnection();
		String sql = "SELECT TYPEID FROM EVENTTYPE WHERE TYPE = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, eventType);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			typeID = rs.getInt(1);
		}
		return typeID;
	}

}
