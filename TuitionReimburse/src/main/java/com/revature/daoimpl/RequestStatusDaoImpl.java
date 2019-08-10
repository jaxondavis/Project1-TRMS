package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.RequestStatus;
import com.revature.dao.RequestStatusDao;
import com.revature.util.ConnFactory;

public class RequestStatusDaoImpl implements RequestStatusDao 
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public RequestStatus getStatus(int reqID) throws SQLException 
	{
		RequestStatus request = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REQUESTSTATUS WHERE REQID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reqID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Couldn't find RequestStatus matching id "+reqID);
		}
		else
		{
			while (rs.next())
			{
				if(rs.getInt(1) == reqID)
				{
					request = new RequestStatus(rs.getInt(1), rs.getString(2));
				}
			}
		}
		return request;
	}

}
