package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Presentation;

public interface PresentationDao {
	
	public abstract Presentation getPresentation(int presID) throws SQLException;

	public abstract void addPresentation(String path) throws SQLException;
	
	public abstract void editPresentation(int presID, String path) throws SQLException;
	
	public abstract void removePresentation(int presID) throws SQLException;
	
	public abstract int getCurrentIndex() throws SQLException;
}
