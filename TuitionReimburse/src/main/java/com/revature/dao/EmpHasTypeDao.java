package com.revature.dao;

import java.sql.SQLException;

public interface EmpHasTypeDao {
	public abstract int getTypeID(int employeeID) throws SQLException;
}
