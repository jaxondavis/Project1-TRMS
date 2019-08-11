package com.revature.beans;

public class Grade {
	private int gradeID;
	private String grade;

	public Grade() {

	}

	public Grade(int gradeID, String grade) {
		this.gradeID = gradeID;
		this.grade = grade;
	}

	public int getGradeID() {
		return gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
