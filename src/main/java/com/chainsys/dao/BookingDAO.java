package com.chainsys.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.chainsys.exception.DbException;
import com.chainsys.exception.SqlException;
import com.chainsys.model.Booking;


public interface BookingDAO {

	public boolean login(int userid,String password)throws DbException, SqlException;
	 
	public void Cancellation(int user_id, int train_number,LocalDate traveldate,long pnrNumber) throws DbException,SQLException;
	
	public ArrayList<Booking> myBooking(int user_id) throws DbException, SqlException;
	
	public int bookSeats1(int trainnumber,int userId,String boarding,String destination,int noOfSeats,LocalDate date) throws DbException, SQLException, Exception;

}
