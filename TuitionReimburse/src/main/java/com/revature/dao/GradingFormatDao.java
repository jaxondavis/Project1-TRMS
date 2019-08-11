package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.GradingFormat;

public interface GradingFormatDao {
	public abstract GradingFormat getGradeFormat(int formID) throws SQLException;
}
