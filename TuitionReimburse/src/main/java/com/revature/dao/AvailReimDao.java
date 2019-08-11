package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.AvailableReimbursement;

public interface AvailReimDao {
	public abstract AvailableReimbursement getAvailReimbursement(int availID) throws SQLException;

	public abstract ArrayList<AvailableReimbursement> getAllAvailReimbursements() throws SQLException;

	public abstract void addAvailReimbursement(double funds) throws SQLException;

	public abstract void updateAvailReimbursement(int availID, double funds) throws SQLException;

	public abstract void deleteAvailReimbursement(int availID) throws SQLException;

	public abstract int getCurrentIndex() throws SQLException;
}
