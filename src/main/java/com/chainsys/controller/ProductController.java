package com.chainsys.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.exception.DbException;
import com.chainsys.viewtrains.ListTrain;
import com.chainsys.viewtrains.ViewTrainsimplementation;

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
}