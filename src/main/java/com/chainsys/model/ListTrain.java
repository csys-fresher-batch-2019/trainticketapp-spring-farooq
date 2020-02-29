package com.chainsys.model;

import java.sql.Date;
import java.time.LocalDate;

public class ListTrain {

	public int getTrainnumber() {
		return trainnumber;
	}

	public void setTrainnumber(int trainnumber) {
		this.trainnumber = trainnumber;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getBoardingstation() {
		return Boardingstation;
	}

	public String setBoardingstation(String boardingstation) {
		return Boardingstation = boardingstation;
	}

	public String getDestinationstation() {
		return destinationstation;
	}

	public String setDestinationstation(String destinationstation) {
		return this.destinationstation = destinationstation;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getDepaturetime() {
		return depaturetime;
	}

	public void setDepaturetime(String depaturetime) {
		this.depaturetime = depaturetime;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private int trainnumber;
	private String trainname;
	private String Boardingstation;
	private String destinationstation;
	private String arrivaltime;
	private String depaturetime;
	private String route;
	private String status;
	private int amount;
	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate traveldate) {
		this.date = traveldate;
	}

	public ListTrain(int trainnumber, String trainname, String boardingstation, String destinationstation,
			String arrivaltime, String depaturetime, String route, String status, int amount) {
		this.trainnumber = trainnumber;
		this.trainname = trainname;
		this.Boardingstation = boardingstation;
		this.destinationstation = destinationstation;
		this.arrivaltime = arrivaltime;
		this.depaturetime = depaturetime;
		this.route = route;
		this.status = status;
		this.amount = amount;
	}

	public ListTrain() {
	}

	public String toString() {
		return "ListTrain [trainnumber=" + trainnumber + ", trainname=" + trainname + ", Boardingstation="
				+ Boardingstation + ", destinationstation=" + destinationstation + ", arrivaltime=" + arrivaltime
				+ ", depaturetime=" + depaturetime + ", route=" + route + ", status=" + status + ", amount=" + amount
				+ "]";
	}

}
