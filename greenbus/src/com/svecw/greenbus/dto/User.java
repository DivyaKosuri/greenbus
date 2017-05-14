package com.svecw.greenbus.dto;

public class User {

	private String userName;
	private String password;
	private String emailId;
	private int phoneNumber;
	public User( String userName, String password, String emailId, int phoneNumber) {
		super();

		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
