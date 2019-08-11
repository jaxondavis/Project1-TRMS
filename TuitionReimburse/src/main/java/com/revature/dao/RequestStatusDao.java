package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.RequestStatus;

public interface RequestStatusDao {
	public abstract RequestStatus getStatus(int reqID) throws SQLException;
}
