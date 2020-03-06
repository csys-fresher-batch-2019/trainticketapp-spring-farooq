package com.chainsys.model;

import java.sql.Date;

public class Booking {

	
	public long getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBoardingStation() {
		return boardingStation;
	}
	public void setBoardingStation(String boardingStation) {
		this.boardingStation = boardingStation;
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private long pnrNumber;
	private	int trainNumber;
	private	String trainName;
	private	int userId;
	private	String boardingStation;
	private	String destinationStation;
	private int  noOfSeats;
	private	String status;
	private int amount;
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	private String currentStatus;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}
	private Date travel_date;
	
	@Override
	public String toString() {
		return "Booking [pnrNumber=" + pnrNumber + ", trainNumber=" + trainNumber + ", trainName=" + trainName
				+ ", userId=" + userId + ", boardingStation=" + boardingStation + ", destinationStation="
				+ destinationStation + ", noOfSeats=" + noOfSeats + ", status=" + status + ", amount=" + amount + "]";
	}
	public Booking(long pnrNumber, int trainNumber, String trainName, int userId, String boardingStation,
			String destinationStation, int noOfSeats, String status,int amount) {
		super();
		this.pnrNumber = pnrNumber;
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.userId = userId;
		this.boardingStation = boardingStation;
		this.destinationStation = destinationStation;
		this.noOfSeats = noOfSeats;
		this.status = status;
		this.amount = amount;
	}
	public Booking() {
	}
	}
