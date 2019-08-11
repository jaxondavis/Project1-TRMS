package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Login;

public interface LoginDao {
	public abstract Login getLogin(int logID) throws SQLException;

	public abstract ArrayList<Login> getAllLogins() throws SQLException;

	public abstract void addLogin(String email, String password, int employeeID) throws SQLException;

	public abstract void updateLogin(int logID, String email, String password, int employeeID) throws SQLException;

	public abstract void deleteLogin(int logID) throws SQLException;
}
