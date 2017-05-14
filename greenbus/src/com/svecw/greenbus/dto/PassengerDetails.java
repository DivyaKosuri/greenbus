package com.svecw.greenbus.dto;

public class PassengerDetails {
	private int ticketId;
	private int seatNo;
	private int age;
	private String name;
	private String gender;
	public PassengerDetails() {
		super();
	}
	public PassengerDetails(int ticketId, int seatNo, int age, String name, String gender) {
		super();
		this.ticketId = ticketId;
		this.seatNo = seatNo;
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "PassengerDetails [ticketId=" + ticketId + ", seatNo=" + seatNo + ", age=" + age + ", name=" + name
				+ ", gender=" + gender + "]";
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
