package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.EventType;
import com.revature.beans.GradingFormat;
import com.revature.dao.EventTypeDao;
import com.revature.util.ConnFactory;

public class EventTypeDaoImpl implements EventTypeDao 
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public EventType getEventType(int eventTypeID) throws SQLException 
	{
		EventType type = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EVENTTYPE WHERE TYPEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, eventTypeID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Couldn't find EventType matching id "+eventTypeID);
		}
		else
		{
			while (rs.next())
			{
				if(rs.getInt(1) == eventTypeID)
				{
					type = new EventType(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				}
			}
		}
		return type;
	}

}
