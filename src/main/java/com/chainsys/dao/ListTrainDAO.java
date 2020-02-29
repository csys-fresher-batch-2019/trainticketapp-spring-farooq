package com.chainsys.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.chainsys.exception.DbException;
import com.chainsys.model.ListTrain;

public interface ListTrainDAO {

	
	public ArrayList<ListTrain> getAllTrainsDetails() throws DbException ;
	
	public ArrayList<ListTrain> getTrainsByArrivalTime()throws DbException;
	
	public ArrayList<ListTrain> getTrainsByDeptTime()throws DbException;
	
	public ArrayList<ListTrain> getTrainDetailsByname(String name)throws DbException;
	
	public void insertnewTrain(ListTrain lt)throws DbException;
	
	public ArrayList<ListTrain> getTrainDetails(String boardingStation,String destinationStation,LocalDate date) throws DbException;
	
	public ArrayList<String> getTrainDetailsByBoardingStation() throws SQLException, Exception;
	
	public ArrayList<String> getTrainDetailsByDestinationStation() throws SQLException, Exception;

}