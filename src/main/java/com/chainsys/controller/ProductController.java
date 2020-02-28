package com.chainsys.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.booking.Bookingimplements;
import com.chainsys.exception.DbException;
import com.chainsys.viewtrains.ListTrain;
import com.chainsys.viewtrains.ViewTrainsimplementation;
@CrossOrigin( origins="*")
@RestController
@RequestMapping("api")
public class ProductController {

	@GetMapping("/ViewTrains")
	public ArrayList<ListTrain> Viewtrains(@RequestParam("source") String boardingStation,
			@RequestParam("destination") String destinationStation, @RequestParam("traveldate") String traveldate)
			throws DbException {

		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		LocalDate date = LocalDate.parse(traveldate);
		return obj.getTrainDetails(boardingStation, destinationStation, date);
	}
	@PostMapping("/bookings")

	public int bookings(@RequestParam("userid") int userId,
			@RequestParam("trainnumber") int trainnumber, @RequestParam("source") String boarding,@RequestParam("destination") String destination,@RequestParam("noofseats") int noOfSeats,@RequestParam("date") String traveldate)
			throws Exception {

		Bookingimplements obj = new Bookingimplements();
		LocalDate date = LocalDate.parse(traveldate);
		return obj.bookSeats(trainnumber, userId, boarding, destination, noOfSeats, date);
	}

}