package com.revature.beans;

public class EmployeeHasType {
	private int employeeID;
	private int typeID;

	public EmployeeHasType() {

	}

	public EmployeeHasType(int employeeID, int typeID) {
		this.employeeID = employeeID;
		this.typeID = typeID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
}
