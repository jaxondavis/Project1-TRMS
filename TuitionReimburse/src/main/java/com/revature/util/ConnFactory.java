package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * ConnFactory class "borrowed" from BankApp. :D 
 */

public class ConnFactory {

	// private static instance of self
	private static ConnFactory cf = new ConnFactory();

	// private constructor
	private ConnFactory() {
		super();
	}

	// synchronized "getter" method
	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}

	// FileReader would be useful for the BankApp project.
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		// TryCatch for literally everything. :D
		try { // http://localhost:8080/TuitionReimburse/home
				// prop.load(new
				// FileReader("/TuitionReimburse/src/main/webapp/WEB-INF/lib/database.properties"));
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@pega1907.cunaco3hss3c.us-east-1.rds.amazonaws.com:1521:ORCL", "reimbursementdb",
					"p4ssw0rd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
}
