package com.revature.beans;

public class Presentation {
	private int presID;
	private String presPath;

	public Presentation() {

	}

	public Presentation(int presID, String presPath) {
		this.presID = presID;
		this.presPath = presPath;
	}

	public int getPresID() {
		return presID;
	}

	public void setPresID(int presID) {
		this.presID = presID;
	}

	public String getPresPath() {
		return presPath;
	}

	public void setPresPath(String presPath) {
		this.presPath = presPath;
	}
}
