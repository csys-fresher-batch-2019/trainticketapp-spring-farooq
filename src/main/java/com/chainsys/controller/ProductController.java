package com.chainsys.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.dao.impl.Bookingimplements;
import com.chainsys.dao.impl.RegistrationImplementation;
import com.chainsys.dao.impl.ViewTrainsimplementation;
import com.chainsys.exception.DbException;
import com.chainsys.model.ListTrain;
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
	@PostMapping("/newTrains")
	public void NewTrains(@RequestParam("trainnumber") int trainnumber, 
			@RequestParam("trainname") String trainname,
			@RequestParam("traveldate") LocalDate traveldate,
			@RequestParam("boardingstation") String boardingstation,
			@RequestParam("destinationstation") String destinationstation,
	@RequestParam("arrivaltime") String arrivaltime,
@RequestParam("depaturetime") String depaturetime,
@RequestParam("amount") int amount,
@RequestParam("status") String status,
@RequestParam("route") String route)

			throws Exception {

		ViewTrainsimplementation obj  = new ViewTrainsimplementation();
		ListTrain obj1 = new ListTrain();
		obj1.setTrainnumber(trainnumber);
		obj1.setTrainname(trainname);
		obj1.setDate(traveldate);
		obj1.setBoardingstation(boardingstation);
		obj1.setDestinationstation(destinationstation);
		obj1.setArrivaltime(arrivaltime);
		obj1.setDepaturetime(depaturetime);
		obj1.setRoute(route);
		obj1.setAmount(amount);
		obj1.setStatus(status);
		obj.insertnewTrain(obj1);
	}
	@PostMapping("/block")

	public int block(@RequestParam("userid") int userId,
			@RequestParam("status") int status)
			throws Exception {

RegistrationImplementation obj = new RegistrationImplementation();
		return obj.blockUser(userId, status);
	}
	@PostMapping("/cancellation")

	public void cancellation(@RequestParam("userid") int userId,
			@RequestParam("trainnumber") int train_number,
			@RequestParam("traveldate") LocalDate traveldate,
			@RequestParam("pnrNumber") long pnrNumber
			)
			throws Exception {

Bookingimplements obj = new Bookingimplements();

		obj.Cancellation(userId, train_number, traveldate, pnrNumber);
	}
	
}