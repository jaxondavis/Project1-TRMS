package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Grade;

public interface GradeDao {
	public abstract Grade getGrade(int gradeID) throws SQLException;

	public abstract ArrayList<Grade> getAllGrades() throws SQLException;

	public abstract void addGrade(String grade) throws SQLException;

	public abstract void updateGrade(int gradeID, String grade) throws SQLException;

	public abstract void deleteGrade(int gradeID) throws SQLException;
}
