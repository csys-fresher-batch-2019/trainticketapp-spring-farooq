package com.chainsys.service;

import com.chainsys.dao.SeatsDAO;
import com.chainsys.dao.impl.Seatsimplementation;
import com.chainsys.exception.DbException;
import com.chainsys.model.Seats;

public class SeatsService {
	SeatsDAO obj = new Seatsimplementation();
	public int updateSeatsCount(Seats s) throws DbException{
		s.getAvailableseats();
		s.getTrainnumber();
		s.getTravelDate();
		return obj.updateSeatsCount(s); 
	}

	
	public void getSeatsCount(Seats s) throws DbException{
		s.getAvailableseats();
		obj.getSeatsCount(s);
	}

}
