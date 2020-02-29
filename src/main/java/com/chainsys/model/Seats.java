package com.chainsys.model;

import java.sql.Date;
import java.time.LocalDate;

public class Seats {
	
	private int trainnumber;
	@Override
	public String toString() {
		return "Seats [trainnumber=" + trainnumber + ", travelDate=" + travelDate + ", availableseats=" + availableseats
				+ "]";
	}
	private LocalDate travelDate;
	private int availableseats;

	public int getTrainnumber() {
		
		return trainnumber;
	}
	public void setTrainnumber(int trainnumber) {
		this.trainnumber = trainnumber;
	}
	public int getAvailableseats() {
		return availableseats;
	}
	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}
	
	public Seats(int trainnumber, int availableseats) {
		this.trainnumber = trainnumber;
		this.availableseats = availableseats;
	}
	public Seats() {
	}
	
	
	
	
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate date) {
		this.travelDate = date;
	}
	
}
