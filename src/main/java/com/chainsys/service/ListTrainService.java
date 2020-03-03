package com.chainsys.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.chainsys.dao.ListTrainDAO;
import com.chainsys.dao.impl.ViewTrainsimplementation;
import com.chainsys.exception.DbException;
import com.chainsys.model.ListTrain;

public class ListTrainService {

	public ArrayList<ListTrain> getTrainDetails(String boardingStation,String destinationStation,LocalDate date) throws DbException{
		ListTrainDAO obj = new ViewTrainsimplementation();
		
		return obj.getTrainDetails(boardingStation, destinationStation, date);
		
	}

}
