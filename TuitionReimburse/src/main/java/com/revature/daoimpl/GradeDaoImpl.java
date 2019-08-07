package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Grade;
import com.revature.dao.GradeDao;
import com.revature.util.ConnFactory;

public class GradeDaoImpl implements GradeDao
{
public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public Grade getGrade(int gradeID) throws SQLException 
	{
		Grade grade = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM GRADE WHERE GRADEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, gradeID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Couldn't find Grade matching Gradeid "+gradeID);
		}
		else
		{
			while (rs.next())
			{
				if(rs.getInt(1) == gradeID)
				{
					grade = new Grade(rs.getInt(1), rs.getString(2));
				}
			}
		}
		return grade;
	}

	@Override
	public ArrayList<Grade> getAllGrades() throws SQLException 
	{
		Grade grade = null;
		ArrayList<Grade> list = new ArrayList<Grade>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM Grade";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			grade = new Grade(rs.getInt(1), rs.getString(2));
			list.add(grade);
		}
		return list;
	}

	@Override
	public void addGrade(String grade) throws SQLException 
	{
		// adds a new Grade to the database
		Connection conn = cf.getConnection();
		String sql = "{ call insertGrade(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(2, grade);
		call.execute();
		System.out.println("Insert sequence complete!");
	}

	@Override
	public void updateGrade(int gradeID, String grade) throws SQLException 
	{
		// updates the Grades info in the database
		Connection conn = cf.getConnection();
		String sql = "{ call updateGrade(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, gradeID);
		call.setString(2, grade);
		call.execute();
		System.out.println("update sequence complete!");
	}

	@Override
	public void deleteGrade(int gradeID) throws SQLException 
	{
		// deletes the Grade associated with gradeID in the database
		Connection conn = cf.getConnection();
		String sql = "{ call deleteGrade(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, gradeID);
		call.execute();
	}
}
