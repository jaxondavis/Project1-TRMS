package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.EventType;

public interface EventTypeDao {
	public abstract EventType getEventType(int eventTypeID) throws SQLException;
}
