package com.revature.util;

import java.util.Properties;

/*
 * Mailer class to email employees messages such as approvals/denials for applications, updates to reimbursement totals, etc.
 * TODO: import javax.email.* | further implementation of class (Low Priority)
 * 
 */

public class Mailer {
	
	private static String host = "0.0.0.0"; //Should determine IP address of host.
	private String sender = "bison@shadaloo.gov";
	private String recipient = null;
	private String denyApp = "We're sorry, but your application has been denied. The reason for the denial is as follows:";
	private String cause = null;
	private static Properties properties = System.getProperties();
	
	
	public static void main(String[]args)
	{
		properties.setProperty("mail.smtp.host", host);
	}

}
