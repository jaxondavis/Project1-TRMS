package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.EmpHasTypeDao;
import com.revature.util.ConnFactory;

public class EmpHasTypeDaoImpl implements EmpHasTypeDao
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public int getTypeID(int employeeID) throws SQLException 
	{
		//returns typeID based on query from EMPLOYEEHASTYPE WHERE EMPLOYEEID = ?
		int typeID = 0;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEEHASTYPE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ResultSet rs = ps.executeQuery();
		typeID = rs.getInt(2);
		return typeID;
	}
}