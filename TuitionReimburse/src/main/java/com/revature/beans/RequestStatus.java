package com.revature.beans;

public class RequestStatus {

	private int requestID;
	private String status;

	public RequestStatus() {
		// TODO Auto-generated constructor stub
	}

	public RequestStatus(int requestID, String status) {
		super();
		this.requestID = requestID;
		this.status = status;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RequestStatus [requestID=" + requestID + ", status=" + status + "]";
	}

}
