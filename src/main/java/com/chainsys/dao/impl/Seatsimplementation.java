package com.chainsys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.Util.TestConnect;
import com.chainsys.dao.SeatsDAO;
import com.chainsys.exception.DbException;
import com.chainsys.exception.ErrorMessages;
import com.chainsys.model.Seats;;

@Repository
public class Seatsimplementation implements SeatsDAO {

	/**
	 * Get seats count for particular train and date
	 */
	final static Logger logger = LoggerFactory.getLogger(RegistrationImplementation.class);

	public int updateSeatsCount(Seats s) throws DbException {
	
		
		String sql = "update seats set avail_seats=? where train_num=? and travel_date=?";
		int result=0;
		try(
		Connection connection = TestConnect.getConnection();
		PreparedStatement stmt1 = connection.prepareStatement(sql);){
				stmt1.setInt(1, s.getAvailableseats());
				stmt1.setInt(2, s.getTrainnumber());
				java.sql.Date date = java.sql.Date.valueOf(s.getTravelDate());
				stmt1.setDate(3, date);
			result=stmt1.executeUpdate();
	} catch (Exception e) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
	}
		return result;
		
	}
	
	
	public void getSeatsCount(Seats s) throws DbException {
		String sql = "select avail_seats from seats where train_num=?";
		try( 
			Connection connection = TestConnect.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);){
			stmt.setInt(1, s.getTrainnumber());
			
			try(ResultSet row = stmt.executeQuery();){
			
			if(row.next()) {
				String seats = row.getString("avail_seats");
				System.out.println("AVAILABLE SEATS="+seats);
			}
		} catch (Exception e) {
throw new DbException(ErrorMessages.INVALID_DATA);
		}
		
	} catch (SQLException e1) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);		
	} catch (Exception e1) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
	}
	}
}