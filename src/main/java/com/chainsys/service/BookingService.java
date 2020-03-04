package com.chainsys.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.dao.BookingDAO;
import com.chainsys.dao.impl.Bookingimplements;
import com.chainsys.exception.DbException;
import com.chainsys.exception.SqlException;
import com.chainsys.model.Booking;

@Service
public class BookingService {

	BookingDAO obj = new Bookingimplements();
	
	public boolean login(int userid, String password) throws DbException, SqlException 
	{

		return obj.login(userid, password); 
	}

	public void Cancellation(int user_id, int train_number, LocalDate traveldate, long pnrNumber)
			throws DbException, SQLException {
obj.Cancellation(user_id, train_number, traveldate, pnrNumber);
	}

	public ArrayList<Booking> myBooking(int user_id) throws DbException, SqlException {
		
		return obj.myBooking(user_id);

	}

	public int bookSeats1(int trainnumber, int userId, String boarding, String destination, int noOfSeats,
			LocalDate date) throws DbException, SQLException, Exception {
		
				return obj.bookSeats1(trainnumber, userId, boarding, destination, noOfSeats, date);

	}

}
