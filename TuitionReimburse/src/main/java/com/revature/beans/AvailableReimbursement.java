package com.revature.beans;

public class AvailableReimbursement 
{
	private int availID;
	private double availFunds;
	
	public AvailableReimbursement() 
	{
		
	}

	public AvailableReimbursement(int availID, double availFunds) 
	{
		this.availID = availID;
		this.availFunds = availFunds;
	}

	public int getAvailID() 
	{
		return availID;
	}

	public void setAvailID(int availID) 
	{
		this.availID = availID;
	}

	public double getAvailFunds() 
	{
		return availFunds;
	}

	public void setAvailFunds(double availFunds) 
	{
		this.availFunds = availFunds;
	}
}
