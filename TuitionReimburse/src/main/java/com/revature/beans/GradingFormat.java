package com.revature.beans;

public class GradingFormat {
	private int formatID;
	private String formatType;

	public GradingFormat() {
		// TODO Auto-generated constructor stub
	}

	public GradingFormat(int formatID, String formatType) {
		super();
		this.formatID = formatID;
		this.formatType = formatType;
	}

	public int getFormatID() {
		return formatID;
	}

	public void setFormatID(int formatID) {
		this.formatID = formatID;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	@Override
	public String toString() {
		return "GradingFormat [formatID=" + formatID + ", formatType=" + formatType + "]";
	}

}
